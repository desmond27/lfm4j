package com.desmonddavid.lfm4j.user.response.topAlbums;

import com.desmonddavid.lfm4j.artist.response.Artist;
import com.desmonddavid.lfm4j.common.response.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Album {

    @JsonProperty("@attr")
    private Map<String, Object> attributes;

    private String name;
    private Artist artist;
    private List<Image> image;

    private String mbid;
    private String url;
    private Integer playcount;
}
