package com.desmonddavid.lfm4j.common.response;

import com.desmonddavid.lfm4j.track.response.Tag;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Tags {

    @JsonProperty("tag")
    private List<Tag> tags;
}
