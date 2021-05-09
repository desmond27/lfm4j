package com.desmonddavid.lfm4j.utils;

import com.desmonddavid.lfm4j.Lfm4J;
import com.desmonddavid.lfm4j.common.utils.ClientType;
import com.desmonddavid.lfm4j.common.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class UtilsTests {

    @BeforeAll
    public static void setup() {
        Lfm4J.init("TestKey12345", "TestSecret12345", ClientType.DESKTOP);
    }

    @Test
    public void testMakeSignature() {
        log.info("Testing makeSignature()");
        TreeMap<String, String> parameters = new TreeMap<>();
        parameters.put("token", "TestToken12345");
        parameters.put("api_key", Lfm4J.getApiKey());
        parameters.put("method", "auth.getSession");

        String expectedSignature = DigestUtils.md5Hex("api_keyTestKey12345methodauth.getSessiontokenTestToken12345TestSecret12345");
        String signature = Utils.makeSignature(parameters);
        log.info("Expected: "+expectedSignature);
        log.info("Actual: "+signature);
        assertEquals(expectedSignature, signature);
    }
}
