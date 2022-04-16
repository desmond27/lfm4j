package com.desmonddavid.lfm4j.user;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.artist.response.Artist;
import com.desmonddavid.lfm4j.common.utils.httpclient.HttpClient;
import com.desmonddavid.lfm4j.common.utils.httpclient.OkHttpClient;
import com.desmonddavid.lfm4j.track.response.Track;
import com.desmonddavid.lfm4j.user.response.recentTracks.RecentTracks;
import com.desmonddavid.lfm4j.user.response.topArtists.Period;
import com.desmonddavid.lfm4j.user.response.topArtists.TopArtists;
import com.desmonddavid.lfm4j.user.response.topTracks.TopTracks;
import com.desmonddavid.lfm4j.user.response.getInfo.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class LfmUserService {

    private static final HttpClient client = new OkHttpClient();

    private static final String USER_GET_INFO_METHOD = "user.getInfo";
    private static final String USER_GET_RECENT_TRACKS_METHOD = "user.getrecenttracks";
    private static final String USER_GET_TOP_ARTISTS_METHOD = "user.gettopartists";
    private static final String USER_GET_TOP_TRACKS_METHOD = "user.gettoptracks";

    /**
     * Gets the information of the user identified by the given username.<br />
     * <a href="https://www.last.fm/api/show/user.getInfo">More info in the Last FM API documentation.</a>
     * @param user A user's username as String.
     * @return An object of type {@link User} containing the user's information.
     */
    public static User getInfo(String user) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("method", USER_GET_INFO_METHOD);
        queryParameters.put("user", user);
        queryParameters.put("api_key", Lfm4J.getApiKey());
        queryParameters.put("format", "json");
        return client.makeGetRequest(queryParameters, User.class);
    }

    /**
     * Gets recent tracks played by the user identified by the given username. Fetches all recently played tracks by default limited to 50 entries.<br /><br />
     * <a href="https://www.last.fm/api/show/user.getRecentTracks">More info in the Last FM API documentation.</a>
     * @param user A user's username as String.
     * @return An object of type {@link RecentTracks} containing the user's recently played tracks.
     */
    public static RecentTracks getRecentTracks(String user) {
        return getRecentTracks(user, null, null, null, null, null);
    }

    /**
     * Gets recent tracks played by the user identified by the given username after applying the given limits.<br />
     * <a href="https://www.last.fm/api/show/user.getRecentTracks">More info in the Last FM API documentation.</a>
     * @param user A user's username as String.
     * @param page (Optional) The page number of the list to fetch. Defaults to 1.
     * @param limit (Optional) The number of entries of the list to be returned per page. Defaults to 50. Maximum value 200.
     * @param from (Optional) Beginning timestamp of the date range in UNIX timestamp format (seconds). The response
     *             will have scrobbles after this time.
     * @param to (Optional) End timestamp of the date range in UNIX timestamp format (seconds). The response will have
     *           scrobbles before this time.
     * @param extended (Optional) If set to true will return additional inforamtion with each scrobble including
     *                 extended artist data and whether the user has loved the track or not.
     * @return An object of type {@link RecentTracks} containing the user's recently played tracks.
     */
    public static RecentTracks getRecentTracks(@NotNull String user, @Nullable Integer page, @Nullable Integer limit,
                                               @Nullable Integer from, @Nullable Integer to, @Nullable Boolean extended) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("method", USER_GET_RECENT_TRACKS_METHOD);
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

    /**
     * Gets a list of the given user's top (most played) artists.<br />
     * <a href="https://www.last.fm/api/show/user.getTopArtists">More info in the Last FM API documentation.</a>
     * @param user A user's username as String.
     * @return An object of type {@link TopArtists} containing the user's top artists as a list of {@link Artist} objects.
     */
    public static TopArtists getTopArtists(String user) {
        return getTopArtists(user, null, null, null);
    }

    /**
     * Gets a list of the given user's top (most played) artists.<br />
     * <a href="https://www.last.fm/api/show/user.getTopArtists">More info in the Last FM API documentation.</a>
     * @param user A user's username as String.
     * @param page (Optional) The page number of the list to fetch. Defaults to 1.
     * @param limit (Optional) The number of entries of the list to be returned per page. Defaults to 50. Maximum value 200.
     * @param period The time period for the list of top artists. These are defined in the enum {@link Period}.
     * @return An object of type {@link TopArtists} containing the user's top artists as a list of {@link Artist} objects.
     */
    public static TopArtists getTopArtists(@NotNull String user, @Nullable Integer page, @Nullable Integer limit, @Nullable Period period) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("method", USER_GET_TOP_ARTISTS_METHOD);
        queryParameters.put("user", user);
        queryParameters.put("api_key", Lfm4J.getApiKey());
        queryParameters.put("format", "json");
        if(page != null)
            queryParameters.put("page", page.toString());
        if(limit != null)
            queryParameters.put("limit", limit.toString());
        if(period != null)
            queryParameters.put("period", period.value);
        return client.makeGetRequest(queryParameters, TopArtists.class);
    }

    /**
     * Gets a list of the given user's top (most played) tracks.<br />
     * <a href="https://www.last.fm/api/show/user.getTopTracks">More info in the Last FM API documentation.</a>
     * @param user A user's username as String.
     * @return An object of type {@link TopTracks} containing the user's top artists as a list of {@link Track} objects.
     */
    public static TopTracks getTopTracks(@NotNull String user) {
        return getTopTracks(user, null, null, null);
    }

    /**
     * Gets a list of the given user's top (most played) tracks.<br />
     * <a href="https://www.last.fm/api/show/user.getTopTracks">More info in the Last FM API documentation.</a>
     * @param user A user's username as String.
     * @param page (Optional) The page number of the list to fetch. Defaults to 1.
     * @param limit (Optional) The number of entries of the list to be returned per page. Defaults to 50. Maximum value 200.
     * @param period The time period for the list of top artists. These are defined in the enum {@link Period}.
     * @return An object of type {@link TopTracks} containing the user's top artists as a list of {@link Track} objects.
     */
    public static TopTracks getTopTracks(@NotNull String user, @Nullable Integer page, @Nullable Integer limit, @Nullable Period period) {
        Map<String, String> queryParameters = new HashMap<>();
        queryParameters.put("method", USER_GET_TOP_TRACKS_METHOD);
        queryParameters.put("user", user);
        queryParameters.put("api_key", Lfm4J.getApiKey());
        queryParameters.put("format", "json");
        if(page != null)
            queryParameters.put("page", page.toString());
        if(limit != null)
            queryParameters.put("limit", limit.toString());
        if(period != null)
            queryParameters.put("period", period.value);
        return client.makeGetRequest(queryParameters, TopTracks.class);
    }
}
