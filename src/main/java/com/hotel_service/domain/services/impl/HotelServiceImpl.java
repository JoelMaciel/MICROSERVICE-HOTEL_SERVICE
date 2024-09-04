package com.hotel_service.domain.services.impl;

import com.hotel_service.api.dtos.converter.HotelConverter;
import com.hotel_service.api.dtos.response.HotelDTO;
import com.hotel_service.api.dtos.response.HotelRequestDTO;
import com.hotel_service.domain.entities.Hotel;
import com.hotel_service.domain.exceptions.HotelAlreadyExistsException;
import com.hotel_service.domain.exceptions.HotelNotFoundException;
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

    public static final String MSG_HOTEL_NOT_FOUND = "Hotel not registered in the database.";
    public static final String MSG_HOTEL_ALREADY_EXISTS = "There is already a hotel with that name registered in the database";
    private final HotelRepository hotelRepository;
    private final HotelConverter hotelConverter;

    @Transactional
    @Override
    public HotelDTO saveHotel(HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = hotelConverter.toEntity(hotelRequestDTO);
        validateNameHotel(hotelRequestDTO.getName());
        return hotelConverter.toDTO(hotelRepository.save(hotel));
    }

    @Override
    public Page<HotelDTO> getAll(Pageable pageable) {
        Page<Hotel> hotelPage = hotelRepository.findAll(pageable);
        return hotelConverter.toPageDTO(hotelPage);
    }

    @Transactional
    @Override
    public HotelDTO updateHotel(UUID hotelId, HotelRequestDTO hotelRequestDTO) {
        Hotel hotel = optionalHotel(hotelId);
        validateNameHotel(hotelRequestDTO.getName());
        Hotel newHotel = hotelConverter.updateEntity(hotel, hotelRequestDTO);
        return hotelConverter.toDTO(hotelRepository.save(newHotel));
    }

    @Override
    public HotelDTO findById(UUID hotelId) {
        Hotel hotel = optionalHotel(hotelId);
        return hotelConverter.toDTO(hotel);
    }

    @Transactional
    @Override
    public void openHotel(UUID hotelId) {
        Hotel hotel = optionalHotel(hotelId);
        hotel.open();
    }

    @Transactional
    @Override
    public void deleteHotel(UUID hotelId) {
        Hotel hotel = optionalHotel(hotelId);
        hotelRepository.delete(hotel);
    }

    @Override
    public Hotel optionalHotel(UUID hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new HotelNotFoundException(MSG_HOTEL_NOT_FOUND));
    }

    private void validateNameHotel(String name) {
        if (hotelRepository.existsByName(name)) {
            throw new HotelAlreadyExistsException(MSG_HOTEL_ALREADY_EXISTS);
        }
    }
}
