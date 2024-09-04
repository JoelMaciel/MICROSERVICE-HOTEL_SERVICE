package com.hotel_service.api.controllers;


import com.hotel_service.api.dtos.response.HotelDTO;
import com.hotel_service.api.dtos.response.HotelRequestDTO;
import com.hotel_service.domain.services.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public Page<HotelDTO> getAll(
            @PageableDefault(page = 0, size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable) {
        return hotelService.getAll(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HotelDTO saveHotel(@RequestBody @Valid HotelRequestDTO hotelRequestDTO) {
        return hotelService.saveHotel(hotelRequestDTO);
    }

    @GetMapping("/{hotelId}")
    public HotelDTO getOne(@PathVariable UUID hotelId) {
        return hotelService.findById(hotelId);
    }

    @PatchMapping("/{hotelId}")
    public HotelDTO updateHotel(@PathVariable UUID hotelId, @RequestBody @Valid HotelRequestDTO hotelRequestDTO) {
        return hotelService.updateHotel(hotelId, hotelRequestDTO);
    }

    @PutMapping("/{hotelId}/open")
    public void openHotel(@PathVariable UUID hotelId) {
        hotelService.openHotel(hotelId);
    }

    @DeleteMapping("/{hotelId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable UUID hotelId) {
        hotelService.deleteHotel(hotelId);
    }
}
