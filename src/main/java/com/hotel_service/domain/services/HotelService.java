package com.hotel_service.domain.services;

import com.hotel_service.api.dtos.response.HotelDTO;
import com.hotel_service.api.dtos.response.HotelRequestDTO;
import com.hotel_service.domain.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface HotelService {

    HotelDTO saveHotel(HotelRequestDTO hotelRequestDTO);

    Page<HotelDTO> getAll(Pageable pageable);

    Hotel optionalHotel(UUID hotelId);

    HotelDTO updateHotel(UUID hotelId, HotelRequestDTO hotelRequestDTO);

    HotelDTO findById(UUID hotelId);

    void openHotel(UUID hotelId);

    void deleteHotel(UUID hotelId);
}
