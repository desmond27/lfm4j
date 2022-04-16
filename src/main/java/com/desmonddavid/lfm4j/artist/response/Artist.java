package com.desmonddavid.lfm4j.artist.response;

import com.desmonddavid.lfm4j.common.NumericBooleanDeserializer;
import com.desmonddavid.lfm4j.common.response.Image;
import com.desmonddavid.lfm4j.common.response.Stats;
import com.desmonddavid.lfm4j.common.response.Tags;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Data
public class Artist {

    @JsonProperty("@attr")
    private Map<String, Object> attributes;

    private String name;
    private String mbid;
    private String url;

    @JsonProperty("image")
    private List<Image> images;

    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private Boolean streamable;

    @JsonDeserialize(using = NumericBooleanDeserializer.class)
    private Boolean onTour;

    private Stats stats;

    private Similar similar;

    private Tags tags;

    @JsonIgnore // Temporarily ignored
    private Bio bio;

    @JsonProperty("#text")
    private String text;

    private Integer playcount;

}

@Getter
@Setter
@ToString
class Bio {

}
