package com.desmonddavid.lfm4j.common.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseWrapper<T> {
    private T responseBody;

}
