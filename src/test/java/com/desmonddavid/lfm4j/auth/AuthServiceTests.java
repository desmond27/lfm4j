package com.desmonddavid.lfm4j.auth;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.TestUtils;
import com.desmonddavid.lfm4j.auth.response.Token;
import com.desmonddavid.lfm4j.common.utils.ClientType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@Slf4j
public class AuthServiceTests {

    @BeforeAll
    public static void init() {
        Lfm4J.init(TestUtils.API_KEY, TestUtils.API_SECRET, ClientType.DESKTOP);
    }

    @Test
    public void testGetToken() {
        Token token = AuthService.getToken();
        Assertions.assertNotNull(token);
    }
}
