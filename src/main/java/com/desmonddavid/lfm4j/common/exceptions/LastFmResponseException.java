package com.desmonddavid.lfm4j.common.exceptions;

import com.desmonddavid.lfm4j.common.response.ErrorResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LastFmResponseException extends RuntimeException {
    private int errorNumber;

    public LastFmResponseException(ErrorResponse errorResponse) {
       super(errorResponse.getMessage());
       errorNumber = errorResponse.getError();
    }

}
