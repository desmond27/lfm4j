package com.desmonddavid.lfm4j.artist.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Similar {

    @JsonProperty("artist")
    private List<Artist> artists;
}
