package com.desmonddavid.lfm4j.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {
    private String size;
    @JsonProperty("#text")
    private String text;
}
