package com.emezon.user.domain.exceptions.paginatedresponse;

import com.emezon.user.domain.constants.PaginatedResponseErrorMessages;

public class PaginatedResponsePageNumberInvalidException extends RuntimeException {
    public PaginatedResponsePageNumberInvalidException() {
        super(PaginatedResponseErrorMessages.PAGE_NUMBER_INVALID);
    }
}
