package com.desmonddavid.lfm4j.common.utils.httpclient;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.common.exceptions.LastFmResponseException;
import com.desmonddavid.lfm4j.common.response.ErrorResponse;
import com.desmonddavid.lfm4j.common.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
public class OkHttpClient implements HttpClient {

    private static final okhttp3.OkHttpClient client = new okhttp3.OkHttpClient();

    /**
     * Makes a GET request to the Last FM API with the given query parameters and deserializes the response into an of the type of the given class.
     * @param queryParameters Query parameters
     * @param tClass The model class whose type of object is to be returned.
     * @param <T> The type of the response
     * @return A model object containing the response.
     */
    @Override
    public <T> T makeGetRequest(Map<String, String> queryParameters, Class<T> tClass) {
        HttpUrl.Builder httpUrlBuilder = HttpUrl.parse(Lfm4J.LAST_FM_ENDPOINT + "/").newBuilder();
        queryParameters.forEach(httpUrlBuilder::addQueryParameter);
        String url = httpUrlBuilder.toString();
        log.debug("Requesting GET "+url);

        Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        ObjectMapper objectMapper = Utils.getObjectMapper();
        try(Response response = call.execute()) {
            if(response.isSuccessful()) {
                String responseString = response.body().string();
                log.trace("Received response: "+responseString);
                JsonNode jsonNode = objectMapper.readTree(responseString);
                T responseObject;
                if(jsonNode.elements().next().elements().hasNext())
                    // For parsing responses which have a single wrapped JSON object.
                    // For example {"user":{"firstName":"Desmond","lastName":"David"}}
                    // Here the contents of "user" will be serialized as the given type rather than the whole response.
                    responseObject = objectMapper.readValue(jsonNode.elements().next().toString(), tClass);
                else
                    responseObject = objectMapper.readValue(responseString, tClass);
                return responseObject;
            }
            else {
                ErrorResponse errorResponse = objectMapper.readValue(response.body().string(), ErrorResponse.class);
                throw new LastFmResponseException(errorResponse);
            }
        } catch (JsonProcessingException e1) {
            log.error("An exception occurred when parsing the response JSON. ", e1);
            return null;
        } catch (IOException e) {
            log.error("An exception occurred when making a GET request. ", e);
            return null;
        }
    }

    /**
     * [NOT TESTED] Makes a POST request to the Last FM API with the given query parameters and deserializes the response into an of the type of the given class.
     * @param parameters The parameters to be sent to the Last FM API as a POST request.
     * @param tClass The model class whose type of object is to be returned.
     * @param <T> The type of the response
     * @return A model object containing the response.
     */
    @Override
    public <T> T makePostRequest(Map<String, String> parameters, Class<T> tClass){
        FormBody.Builder requestBodyBuilder = new FormBody.Builder();

        parameters.forEach(requestBodyBuilder::add);
        RequestBody requestBody = requestBodyBuilder.build();

        Request request = new Request.Builder()
                .url(Lfm4J.LAST_FM_ENDPOINT + "/")
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        Response response;
        ObjectMapper objectMapper = Utils.getObjectMapper();
        try {
            response = call.execute();
            if(response.isSuccessful()) {
                return objectMapper.readValue(response.body().string(), tClass);
            }
            else {
                ErrorResponse errorResponse = objectMapper.readValue(response.body().string(), ErrorResponse.class);
                throw new LastFmResponseException(errorResponse);
            }

        } catch (IOException e) {
            log.error("An exception occurred when making a POST request. ", e);
            return null;
        }
    }
}
