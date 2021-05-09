package com.desmonddavid.lfm4j;

import com.desmonddavid.lfm4j.common.utils.ClientType;
import com.desmonddavid.lfm4j.common.utils.httpclient.HttpClient;
import com.desmonddavid.lfm4j.common.utils.httpclient.OkHttpClient;
import lombok.extern.slf4j.Slf4j;

/**
 * The main library class exposing Last.fm API endpoints.
 */
@Slf4j
public class Lfm4J {

    public static final String LAST_FM_ENDPOINT = "https://ws.audioscrobbler.com/2.0";
    private static String apiKey;
    private static String apiSecret;
    private static ClientType clientType;
    private static HttpClient httpClient;

    private static Lfm4J instance;

    public static void init(String apiKey, String apiSecret, ClientType clientType) {

        log.info("Initializing LastFm4J for client type: "+clientType.name());

        Lfm4J.apiKey = apiKey;
        Lfm4J.apiSecret = apiSecret;
        Lfm4J.clientType = clientType;

        // Initialize OkHttp as the default HTTP client
        httpClient = new OkHttpClient();
    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getApiSecret() {
        return apiSecret;
    }

    public static ClientType getClientType() {
        return clientType;
    }
}
