package com.hotel_service.api.dtos.response;

import lombok.*;

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
    private String information;
}
