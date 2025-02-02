package com.desmonddavid.lfm4j.user.response.getInfo;

import com.desmonddavid.lfm4j.common.response.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String name;
    private String realname;
    private String url;
    private List<Image> image;
    private String country;
    private int age;
    private String gender;
    private int subscriber;
    private int playcount;
    private String playlists;
    private String bootstrap;
    private Registered registered;
    private String type;
    @JsonProperty("artist_count")
    private String artistCount;
    @JsonProperty("track_count")
    private String trackCount;
    @JsonProperty("album_count")
    private String albumCount;
}

@Data
class Registered {
    private String unixtime;
    @JsonProperty("#text")
    private String text;
}
