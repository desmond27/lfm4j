package com.desmonddavid.lfm4j.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int error;
    private String message;
}
