package com.hotel_service.domain.exceptions;

public class HotelAlreadyExistsException extends EntityAlreadyExistsException{

    public HotelAlreadyExistsException(String message) {
        super(message);
    }
}
