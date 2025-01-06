package com.skypath.skypath.service.impl;

import com.skypath.skypath.dto.TransportationDto;
import com.skypath.skypath.entity.Location;
import com.skypath.skypath.entity.Transportation;
import com.skypath.skypath.mapper.TransportationMapper;
import com.skypath.skypath.repository.LocationRepository;
import com.skypath.skypath.repository.TransportationRepository;
import com.skypath.skypath.request.TransportationRequest;
import com.skypath.skypath.response.TransportationResponse;
import com.skypath.skypath.service.TransportationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportationServiceImpl implements TransportationService {
    private final TransportationRepository transportationRepository;
    private final TransportationMapper transportationMapper;
    private final LocationRepository locationRepository;


    //todo unique pk koy buraya origin destination ve type
    @Override
    public Boolean createTransportation(TransportationRequest request) {
        Location origin = locationRepository.findById(request.getOriginId())
                .orElseThrow(() -> new RuntimeException("Origin not found with id: " + request.getOriginId()));
        Location destination = locationRepository.findById(request.getDestinationId())
                .orElseThrow(() -> new RuntimeException("Destination not found with id: " + request.getDestinationId()));
        Transportation transportation = transportationMapper.toEntity(request, origin, destination);
        transportationRepository.save(transportation);
        return true;
    }


    @Override
    public TransportationResponse getAllTransportations(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Transportation> transportationPage = transportationRepository.findAll(pageable);
        List<TransportationDto> transportationDtoList = transportationMapper.toDtoList(transportationPage.getContent());

        return new TransportationResponse(transportationDtoList, transportationPage.getTotalElements(), transportationPage.getTotalPages());
    }


    @Override
    public TransportationDto getTransportaionById(Long id) {
        Transportation transportation = transportationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transportation not found"));
        return transportationMapper.toDto(transportation);
    }

    @Override
    public Boolean updateTransportation(Long id, TransportationDto dto) {
        Transportation existingTransportation = transportationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transportation not found with id: " + id));
        Location origin = null;
        if (dto.getOriginId() != null) {
            origin = locationRepository.findById(dto.getOriginId())
                    .orElseThrow(() -> new RuntimeException("Origin not found with id: " + dto.getOriginId()));
        }
        Location destination = null;
        if (dto.getDestinationId() != null) {
            destination = locationRepository.findById(dto.getDestinationId())
                    .orElseThrow(() -> new RuntimeException("Destination not found with id: " + dto.getDestinationId()));
        }
        transportationMapper.updateEntityFromDto(existingTransportation, dto, origin, destination);
        transportationRepository.save(existingTransportation);
        return true;
    }


    public void deleteTransportation(Long id) {
        Transportation transportation = transportationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("transportation not found with id: " + id));
        transportationRepository.delete(transportation);
    }
}
