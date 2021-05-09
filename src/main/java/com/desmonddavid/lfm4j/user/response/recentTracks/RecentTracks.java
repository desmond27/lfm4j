package com.desmonddavid.lfm4j.user.response.recentTracks;

import com.desmonddavid.lfm4j.common.response.Attributes;
import com.desmonddavid.lfm4j.track.response.Track;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class RecentTracks {
    @JsonProperty("@attr")
    private Attributes attributes;

    @JsonProperty("track")
    private List<Track> tracks;

}
