package com.desmonddavid.lfm4j.auth;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.auth.response.Token;
import com.desmonddavid.lfm4j.common.utils.httpclient.HttpClient;
import com.desmonddavid.lfm4j.common.utils.httpclient.OkHttpClient;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class AuthService {

    private static HttpClient httpClient = new OkHttpClient();

    public static Token getToken() {

        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("method", "auth.getToken");
        queryParameters.put("api_key", Lfm4J.getApiKey());
        queryParameters.put("format", "json");
        return httpClient.makeGetRequest(queryParameters, Token.class);
    }

    public String getSession(String token) {

        //TODO

        return null;
    }

    public String getMobileSession(String username, String password) {

        //TODO

        return null;
    }
}
