package com.hotel_service.domain.repositories;

import com.hotel_service.domain.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {

    boolean existsByName(String name);
}
