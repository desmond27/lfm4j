package com.desmonddavid.lfm4j.common.response;

import com.desmonddavid.lfm4j.track.response.Track;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Tracks {
    private List<Track> track;
}
