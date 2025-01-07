package com.skypath.repository;

import com.skypath.entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long> {
    boolean existsByOriginIdAndDestinationIdAndTransportationType(Long originId, Long destinationId, Integer transportationType);

    List<Transportation> findByOriginId(Long originId);

}
