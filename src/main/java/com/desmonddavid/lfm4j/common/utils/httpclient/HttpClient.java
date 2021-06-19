package com.desmonddavid.lfm4j.common.utils.httpclient;

import java.util.Map;

public interface HttpClient {

    <T> T makeGetRequest(Map<String, String> queryParameters, Class<T> tClass);

    <T> T makePostRequest(Map<String, String> parameters, Class<T> tClass);
}
