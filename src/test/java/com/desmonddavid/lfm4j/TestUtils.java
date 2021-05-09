package com.desmonddavid.lfm4j;

import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
@Setter
public class TestUtils {
    public static final String LAST_FM_ENDPOINT;
    public static final String API_KEY;
    public static final String API_SECRET;
    public static final String USERNAME;

    static {
        InputStream propertiesStream = TestUtils.class.getClassLoader().getResourceAsStream("lastfm.properties");
        Properties lastFmProperties = new Properties();
        try {
            lastFmProperties.load(propertiesStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        API_KEY = lastFmProperties.getProperty("lastfm.apiKey");
        API_SECRET = lastFmProperties.getProperty("lastfm.apiSecret");
        LAST_FM_ENDPOINT = lastFmProperties.getProperty("lastfm.endpoint");
        USERNAME = lastFmProperties.getProperty("lastfm.user");
        assert(API_KEY != null && !API_KEY.isEmpty());
        assert(API_SECRET != null && !API_SECRET.isEmpty());
        assert(USERNAME != null && !USERNAME.isEmpty());
    }
}
