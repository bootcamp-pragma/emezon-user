package com.emezon.user.domain.exceptions.paginatedresponse;

import com.emezon.user.domain.constants.PaginatedResponseErrorMessages;

public class PaginatedResponsePageSizeInvalidException extends RuntimeException {
    public PaginatedResponsePageSizeInvalidException() {
        super(PaginatedResponseErrorMessages.PAGE_SIZE_INVALID);
    }
}
