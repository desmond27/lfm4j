package com.desmonddavid.lfm4j;

import com.desmonddavid.lfm4j.common.utils.ClientType;
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
    //private static HttpClient httpClient;

    private static Lfm4J instance;

    /**
     * Initialize the library with the API key and API secret obtained from the last.fm website.<br /><br />
     * You must obtain your own API key and secret by creating an API account <a href="https://www.last.fm/api/account/create">here</a>.
     *
     * @param apiKey The API key obtained after creating an API account in last.fm.
     * @param apiSecret The API secret obtained after crating an API account in last.fm.
     * @param clientType An enum with values WEB, DESKTOP and MOBILE. Used for authenticating users for web, desktop or mobile respectively. Currently only desktop works.
     */
    public static void init(String apiKey, String apiSecret, ClientType clientType) {

        log.info("Initializing LastFm4J for client type: "+clientType.name());

        Lfm4J.apiKey = apiKey;
        Lfm4J.apiSecret = apiSecret;
        Lfm4J.clientType = clientType;

        // Initialize OkHttp as the default HTTP client
        //httpClient = new OkHttpClient();
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
