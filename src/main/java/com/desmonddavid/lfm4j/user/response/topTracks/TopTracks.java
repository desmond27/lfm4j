package com.desmonddavid.lfm4j.user.response.topTracks;

import com.desmonddavid.lfm4j.track.response.Track;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class TopTracks {

    @JsonProperty("@attr")
    private Map<String, Object> attributes;

    @JsonProperty("track")
    private List<Track> tracks;

}
