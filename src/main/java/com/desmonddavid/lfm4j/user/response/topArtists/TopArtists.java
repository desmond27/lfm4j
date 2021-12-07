package com.desmonddavid.lfm4j.user.response.topArtists;

import com.desmonddavid.lfm4j.artist.response.Artist;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TopArtists {

    @JsonProperty("@attr")
    private Map<String, Object> attributes;

    @JsonProperty("artist")
    private List<Artist> artists;
}
