package com.desmonddavid.lfm4j.user;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.TestUtils;
import com.desmonddavid.lfm4j.common.utils.ClientType;
import com.desmonddavid.lfm4j.user.response.recentTracks.RecentTracks;
import com.desmonddavid.lfm4j.user.response.userInfo.User;
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

    @Test
    public void testGetUserInfo() {
        User userInfo = LfmUserService.getInfo(TestUtils.USERNAME);
        Assertions.assertNotNull(userInfo);
        Assertions.assertEquals("Des27", userInfo.getName());
    }

    @Test
    public void testGetUserRecentTracksForUserNameOnly() {
        RecentTracks recentTracks = LfmUserService.getRecentTracks(TestUtils.USERNAME);
        Assertions.assertNotNull(recentTracks);
        Assertions.assertEquals(50, recentTracks.getTracks().size());
    }

    @Test
    public void testGetUserRecentTracksWithLimits() {
        RecentTracks recentTracks = LfmUserService.getRecentTracks(TestUtils.USERNAME, 1, 5, null, null, false);
        Assertions.assertNotNull(recentTracks);
        Assertions.assertEquals(5, recentTracks.getTracks().size());
    }
}