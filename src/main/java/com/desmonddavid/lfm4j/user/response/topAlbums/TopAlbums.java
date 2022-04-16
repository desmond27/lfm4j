package com.desmonddavid.lfm4j.user.response.topAlbums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TopAlbums {

    @JsonProperty("@attr")
    private Map<String, Object> attributes;

    @JsonProperty("album")
    private List<Album> albums;
}
