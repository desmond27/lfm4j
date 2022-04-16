package com.desmonddavid.lfm4j.user.response.getInfo;

import com.desmonddavid.lfm4j.common.response.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
}

@Data
class Registered {
    private String unixtime;
    @JsonProperty("#text")
    private String text;
}
