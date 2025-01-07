package com.skypath.service.impl;

import com.skypath.dto.RouteStepDto;
import com.skypath.dto.response.RouteResponse;
import com.skypath.entity.Transportation;
import com.skypath.repository.LocationRepository;
import com.skypath.repository.TransportationRepository;
import com.skypath.service.RouteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RouteServiceImpl implements RouteService {

    private final TransportationRepository transportationRepository;
    private final LocationRepository locationRepository;


    @Override
    public LinkedList<RouteResponse> findRoutes(Long fromLocationId, Long toLocationId) {
        LinkedList<RouteResponse> routes = new LinkedList<>();
        LinkedList<RouteStepDto> currentPath = new LinkedList<>();
        if (!locationRepository.existsById(fromLocationId) || !locationRepository.existsById(toLocationId)) {
            throw new IllegalArgumentException("Location does not exist.");
        }
        exploreRoutes(fromLocationId, toLocationId, currentPath, routes);
        return routes;
    }

    private void exploreRoutes(Long fromLocationId, Long toLocationId, LinkedList<RouteStepDto> currentPath,
                               List<RouteResponse> routes) {
        List<Transportation> transportations = transportationRepository.findByOriginId(fromLocationId);
        for (Transportation transportation : transportations) {
            String type = transportation.getTransportationType() == 1 ? "FLIGHT" : "OTHER";
            RouteStepDto step = new RouteStepDto(
                    transportation.getOrigin().getName(),
                    transportation.getDestination().getName(),
                    type
            );
            currentPath.addLast(step); // LinkedList'in sonuna ekle
            if (transportation.getDestination().getId().equals(toLocationId)) {
                if (isValidRoute(currentPath)) {
                    routes.add(new RouteResponse(new LinkedList<>(currentPath)));
                }
            } else {
                exploreRoutes(transportation.getDestination().getId(), toLocationId, currentPath, routes);
            }
            currentPath.removeLast(); // Geri dönüş için son öğeyi çıkar
        }
    }

    private boolean containsFlight(LinkedList<RouteStepDto> currentPath) {
        return currentPath.stream().anyMatch(step -> step.getTransportationType().equals("FLIGHT"));
    }

    private boolean isValidRoute(LinkedList<RouteStepDto> currentPath) {
        if (currentPath.size() > 3) return false; // 3'ten fazla transportation yasak
        if (!containsFlight(currentPath)) return false; // En az bir uçuş olmalı

        int flightCount = 0;
        int beforeFlightCount = 0;
        int afterFlightCount = 0;
        boolean flightOccurred = false; // Uçuşun gerçekleşip gerçekleşmediğini takip eder

        for (RouteStepDto step : currentPath) {
            String type = step.getTransportationType();

            if (type.equals("FLIGHT")) {
                flightCount++;
                flightOccurred = true;
            } else if (!flightOccurred) {
                beforeFlightCount++;
            } else {
                afterFlightCount++;
            }
            if (flightCount > 1 || beforeFlightCount > 1 || afterFlightCount > 1) {
                return false; // Kısıtlamalardan herhangi biri ihlal edilirse
            }
        }
        return true;
    }
}