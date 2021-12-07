package com.desmonddavid.lfm4j.common;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * Deserializes numeric values to boolean. That is 0 becomes false and 1 becomes true. Any other numeric value results in null.
 */
public class NumericBooleanDeserializer extends JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode node = p.getCodec().readTree(p);
        int value = Integer.parseInt(node.asText());
        if(value == 0) return false;
        else if(value == 1) return true;
        else return null;
    }
}
