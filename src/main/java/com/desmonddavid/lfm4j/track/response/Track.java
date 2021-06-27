package com.desmonddavid.lfm4j.track.response;

import com.desmonddavid.lfm4j.album.response.Album;
import com.desmonddavid.lfm4j.artist.response.Artist;
import com.desmonddavid.lfm4j.common.NumericBooleanDeserializer;
import com.desmonddavid.lfm4j.common.response.Date;
import com.desmonddavid.lfm4j.common.response.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private Boolean streamable;

    private Artist artist;
    private Album album;

    @JsonProperty("image")
    private List<Image> images;
    private Date date;
}
