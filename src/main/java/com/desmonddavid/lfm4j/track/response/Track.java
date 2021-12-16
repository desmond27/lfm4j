package com.desmonddavid.lfm4j.track.response;

import com.desmonddavid.lfm4j.album.response.Album;
import com.desmonddavid.lfm4j.artist.response.Artist;
import com.desmonddavid.lfm4j.common.response.Date;
import com.desmonddavid.lfm4j.common.response.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Track {

    @JsonProperty("@attr")
    Map<String, Object> attributes;

    private String name;
    private String mbid;
    private String url;
    private int duration;
    private int listeners;
    private int playcount;

    private Map<String, Object> streamableMap;
    private Boolean isStreamable;

    private Artist artist;
    private Album album;

    @JsonProperty("image")
    private List<Image> images;
    private Date date;

    @JsonSetter("streamable")
    public void setStreamable(JsonNode streamable) {
        if (streamable != null) {
            if (streamable.isTextual()) {
                // If the value of streamable is String, then store the value in isStreamable as boolean appropriately.
                String s = streamable.textValue();
                if (s.equals("1")) isStreamable = true;
                else if (s.equals("0")) isStreamable = false;
                else isStreamable = null;
            } else {
                // If the value is non-textual, then deserialize its value as Map.
                streamableMap = new HashMap<>();
                Iterator<Map.Entry<String, JsonNode>> sIterator = streamable.fields();
                while (sIterator.hasNext()) {
                    Map.Entry<String, JsonNode> entry = sIterator.next();
                    streamableMap.put(entry.getKey(), entry.getValue().textValue());
                }
            }
        }
    }
}
