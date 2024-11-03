package com.emezon.user.domain.exceptions.paginatedresponse;

import com.emezon.user.domain.constants.PaginatedResponseErrorMessages;

public class PaginatedResponseSortDirectionInvalidException extends RuntimeException {

    public PaginatedResponseSortDirectionInvalidException() {
        super(PaginatedResponseErrorMessages.SORT_DIRECTION_INVALID);
    }

}
