package com.desmonddavid.lfm4j.common.utils;

import com.desmonddavid.lfm4j.Lfm4J;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.TreeMap;
import java.util.stream.Collectors;

public class Utils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String makeSignature(TreeMap<String, String> parameters) {
        // `parameters` is a TreeMap so that keys are sorted alphabetically.
        String parameterString = parameters.entrySet().stream().map(e -> e.getKey() + e.getValue()).collect(Collectors.joining());
        parameterString += Lfm4J.getApiSecret();
        return DigestUtils.md5Hex(parameterString);
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
