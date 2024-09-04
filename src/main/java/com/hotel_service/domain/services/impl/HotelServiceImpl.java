package com.hotel_service.domain.services.impl;

import com.hotel_service.api.dtos.response.HotelDTO;
import com.hotel_service.api.dtos.response.HotelRequestDTO;
import com.hotel_service.domain.entities.Hotel;
import com.hotel_service.domain.repositories.HotelRepository;
import com.hotel_service.domain.services.HotelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Transactional
    @Override
    public HotelDTO createHotel(HotelRequestDTO hotelRequestDTO) {
        return null;
    }

    @Override
    public Page<HotelDTO> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public HotelDTO getOne(UUID hotelId) {
        return null;
    }

    @Override
    public Hotel optionalHotel(UUID hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public HotelDTO updateHotel(UUID hotelId, HotelRequestDTO hotelRequestDTO) {
        return null;
    }
}
