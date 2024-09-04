package com.hotel_service.api.dtos.converter;

import com.hotel_service.api.dtos.response.HotelDTO;
import com.hotel_service.api.dtos.response.HotelRequestDTO;
import com.hotel_service.domain.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class HotelConverter {

    private HotelConverter() {
    }

    public Page<HotelDTO> toPageDTO(Page<Hotel> hotelPage) {
        return hotelPage.map(this::toDTO);
    }

    public Hotel toEntity(HotelRequestDTO hotelRequestDTO) {
        return Hotel.builder()
                .name(hotelRequestDTO.getName())
                .information(hotelRequestDTO.getInformation())
                .localization(hotelRequestDTO.getLocalization())
                .creationDate(LocalDate.now())
                .build();
    }

    public HotelDTO toDTO(Hotel hotel) {
        return HotelDTO.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .localization(hotel.getLocalization())
                .information(hotel.getInformation())
                .isOpen(hotel.isOpen())
                .creationDate(hotel.getCreationDate())
                .build();
    }

    public Hotel updateEntity(Hotel hotel, HotelRequestDTO hotelRequestDTO) {
        return hotel.toBuilder()
                .name(hotelRequestDTO.getName())
                .information(hotelRequestDTO.getInformation())
                .localization(hotelRequestDTO.getLocalization())
                .build();
    }
}
