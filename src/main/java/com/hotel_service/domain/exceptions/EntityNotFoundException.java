package com.hotel_service.domain.exceptions;

public abstract class EntityNotFoundException extends BusinessException {

    protected EntityNotFoundException(String message) {
        super(message);
    }


}
