package com.hotel_service.api.dtos.response;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDTO {

    private UUID id;
    private String name;
    private String localization;
    private boolean isOpen;
    private LocalDate creationDate;
    private String information;
}
