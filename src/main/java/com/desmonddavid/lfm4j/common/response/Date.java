package com.desmonddavid.lfm4j.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Date {
    private String uts;
    @JsonProperty("#text")
    private String text;
}
