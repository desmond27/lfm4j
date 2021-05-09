package com.desmonddavid.lfm4j.album.response;

import com.desmonddavid.lfm4j.common.response.Image;
import com.desmonddavid.lfm4j.common.response.Wiki;
import com.desmonddavid.lfm4j.track.response.Tag;
import com.desmonddavid.lfm4j.track.response.Track;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Album {
    private String name;
    private String artist;
    private String mbid;
    private String url;

    @JsonProperty("image")
    private List<Image> images;

    private int listeners;
    private int playcount;

    private Tracks tracks;

    private Tags tags;

    private Wiki wiki;

    @JsonProperty("#text")
    private String text;
}

@Getter
@Setter
@ToString
class Tracks {
    @JsonProperty("track")
    private List<Track> trackList;
}

@Getter
@Setter
@ToString
class Tags {
    @JsonProperty("tag")
    private List<Tag> tagList;
}