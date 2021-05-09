package com.desmonddavid.lfm4j.common.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Wiki {
    private String published;
    private String summary;
    private String content;
}
