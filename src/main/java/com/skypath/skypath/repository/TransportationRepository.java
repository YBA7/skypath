package com.skypath.skypath.repository;

import com.skypath.skypath.entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportationRepository extends JpaRepository<Transportation, Long> {
    boolean existsByOriginIdAndDestinationIdAndTransportationType(Long originId, Long destinationId, Integer transportationType);

}
