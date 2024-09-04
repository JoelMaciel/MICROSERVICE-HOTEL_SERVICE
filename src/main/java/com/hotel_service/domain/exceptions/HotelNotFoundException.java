package com.hotel_service.domain.exceptions;

public class HotelNotFoundException extends EntityNotFoundException{

    public HotelNotFoundException(String message) {
        super(message);
    }

}
