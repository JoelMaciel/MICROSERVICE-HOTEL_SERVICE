package com.hotel_service.domain.services;

import com.hotel_service.api.dtos.response.HotelDTO;
import com.hotel_service.api.dtos.response.HotelRequestDTO;
import com.hotel_service.domain.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface HotelService {

    HotelDTO createHotel(HotelRequestDTO hotelRequestDTO);

    Page<HotelDTO> getAll(Pageable pageable);

    HotelDTO getOne(UUID hotelId);

    Hotel optionalHotel(UUID hotelId);

    HotelDTO updateHotel(UUID hotelId, HotelRequestDTO hotelRequestDTO);
}
