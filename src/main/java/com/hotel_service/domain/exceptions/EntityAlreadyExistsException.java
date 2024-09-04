package com.hotel_service.domain.exceptions;

public abstract class EntityAlreadyExistsException extends BusinessException {

    protected EntityAlreadyExistsException(String message) {
        super(message);
    }


}
