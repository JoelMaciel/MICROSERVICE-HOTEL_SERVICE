package com.hotel_service.api.dtos.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelRequestDTO {

    private String name;
    private String localization;
    private boolean isOpen;
    private LocalDate creationDate;
    private String information;
}
