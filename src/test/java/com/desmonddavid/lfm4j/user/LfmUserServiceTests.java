package com.desmonddavid.lfm4j.user;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.TestUtils;
import com.desmonddavid.lfm4j.common.utils.ClientType;
import com.desmonddavid.lfm4j.user.response.recentTracks.RecentTracks;
import com.desmonddavid.lfm4j.user.response.topArtists.TopArtists;
import com.desmonddavid.lfm4j.user.response.topTracks.TopTracks;
import com.desmonddavid.lfm4j.user.response.getInfo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
public class LfmUserServiceTests {

    @BeforeAll
    public static void init() {
        Lfm4J.init(TestUtils.API_KEY, TestUtils.API_SECRET, ClientType.DESKTOP);
    }

    /**
     * The user must exist in last fm for this test to pass.
     */
    @Test
    public void testGetUserInfo() {
        User userInfo = LfmUserService.getInfo(TestUtils.USERNAME);
        Assertions.assertNotNull(userInfo);
        Assertions.assertEquals("Des27", userInfo.getName());
    }

    /**
     * Prerequisite: The test user must have greater than zero scrobbles for this test to pass.
     */
    @Test
    public void testGetUserRecentTracksForUserNameOnly() {
        RecentTracks recentTracks = LfmUserService.getRecentTracks(TestUtils.USERNAME);
        Assertions.assertNotNull(recentTracks);

        // If the user has a track currently playing, the count returned is always one greater than the limit.
        // 51 in this case because the default limit is 50.
        Assertions.assertTrue(recentTracks.getTracks().size() == 50 || recentTracks.getTracks().size() == 51);
    }

    /**
     * Prerequisite: The test user must have at least 5 scrobbles for this test to pass.
     */
    @Test
    public void testGetUserRecentTracksWithLimits() {
        RecentTracks recentTracks = LfmUserService.getRecentTracks(TestUtils.USERNAME, 1, 5, null, null, false);
        Assertions.assertNotNull(recentTracks);

        // If the user has a track currently playing, the count returned is always one greater than the limit.
        Assertions.assertTrue(recentTracks.getTracks().size() == 5 || recentTracks.getTracks().size() == 6);
    }

    /**
     * Prerequisite: The test user must have greater than zero top artists for this test to pass.
     */
    @Test
    public void testGetUserTopArtistsWithUserNameOnly() {
        TopArtists topArtists = LfmUserService.getTopArtists(TestUtils.USERNAME);
        Assertions.assertNotNull(topArtists);
        Assertions.assertTrue(topArtists.getArtists().size() > 0);
    }

    /**
     * Prerequisite: The test user must have greater than zero top artists for this test to pass.
     */
    @Test
    public void testGetUserTopArtistsWithLimits() {
        TopArtists topArtists = LfmUserService.getTopArtists(TestUtils.USERNAME, 1, 5, null);
        Assertions.assertNotNull(topArtists);
        Assertions.assertEquals(5, topArtists.getArtists().size());
    }

    /**
     * Prerequisite: The test user must have greater than zero top artists for this test to pass.
     */
    @Test
    public void testGetUserTopTracksWithUserNameOnly() {
        TopTracks topTracks = LfmUserService.getTopTracks(TestUtils.USERNAME);
        Assertions.assertNotNull(topTracks);
        Assertions.assertTrue(topTracks.getTracks().size() > 0);
    }

    /**
     * Prerequisite: The test user must have greater than zero top artists for this test to pass.
     */
    @Test
    public void testGetUserTopTracksWithLimits() {
        TopTracks topTracks = LfmUserService.getTopTracks(TestUtils.USERNAME, 1, 5, null);
        Assertions.assertNotNull(topTracks);
        Assertions.assertEquals(5, topTracks.getTracks().size());
    }
}