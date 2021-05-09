package com.desmonddavid.lfm4j.user;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.common.utils.httpclient.HttpClient;
import com.desmonddavid.lfm4j.common.utils.httpclient.OkHttpClient;
import com.desmonddavid.lfm4j.user.response.recentTracks.RecentTracks;
import com.desmonddavid.lfm4j.user.response.userInfo.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class LfmUserService {

    private static final HttpClient client = new OkHttpClient();

    public static User getInfo(String user) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("method", "user.getInfo");
        queryParameters.put("user", user);
        queryParameters.put("api_key", Lfm4J.getApiKey());
        queryParameters.put("format", "json");
        return client.makeGetRequest(queryParameters, User.class);
    }

    public static RecentTracks getRecentTracks(String user) {
        return getRecentTracks(user, null, null, null, null, null);
    }

    public static RecentTracks getRecentTracks(@NotNull String user, @Nullable Integer page, @Nullable Integer limit,
                                               @Nullable Integer from, @Nullable Integer to, @Nullable Boolean extended) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("method", "user.getrecenttracks");
        queryParameters.put("user", user);
        queryParameters.put("api_key", Lfm4J.getApiKey());
        queryParameters.put("format", "json");
        if(page != null)
            queryParameters.put("page", page.toString());
        if(limit != null)
            queryParameters.put("limit", limit.toString());
        if(from != null)
            queryParameters.put("from", from.toString());
        if(to != null)
            queryParameters.put("to", to.toString());
        if(extended != null)
            queryParameters.put("extended", extended ? "1" : "0");

        return client.makeGetRequest(queryParameters, RecentTracks.class);
    }

}
