package com.desmonddavid.lfm4j.common.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonRootName("@attr")
public class Attributes {
    private String page;
    private String perPage;
    private String user;
    private String total;
    private String totalPages;
}
