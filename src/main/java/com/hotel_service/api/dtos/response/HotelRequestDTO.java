package com.hotel_service.api.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelRequestDTO {

    @NotBlank
    @Size(min = 6, max = 50)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String localization;

    @NotBlank
    @Size(max = 200)
    private String information;
}
