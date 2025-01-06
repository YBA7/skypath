package com.skypath.skypath.service.impl;

import com.skypath.skypath.dto.RouteStepDto;
import com.skypath.skypath.entity.Transportation;
import com.skypath.skypath.repository.LocationRepository;
import com.skypath.skypath.repository.TransportationRepository;
import com.skypath.skypath.response.RouteResponse;
import com.skypath.skypath.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final TransportationRepository transportationRepository;
    private final LocationRepository locationRepository;


    @Override
    public List<RouteResponse> calculateRoutes(Long fromLocationId, Long toLocationId) {
        List<RouteResponse> routes = new ArrayList<>();
        List<RouteStepDto> currentPath = new ArrayList<>();
        findRoutes(fromLocationId, toLocationId, currentPath, routes);
        return routes;
    }

    private void findRoutes(Long fromLocationId, Long toLocationId, List<RouteStepDto> currentPath, List<RouteResponse> routes) {
        if (!locationRepository.existsById(fromLocationId)) {
            throw new IllegalArgumentException("Location with ID " + fromLocationId + " does not exist.");
        }

        if (!locationRepository.existsById(toLocationId)) {
            throw new IllegalArgumentException("Location with ID " + toLocationId + " does not exist.");
        }

        List<Transportation> transportations = transportationRepository.findAll();

        for (Transportation transportation : transportations) {
            if (transportation.getOrigin().getId().equals(fromLocationId)) {
                String type = transportation.getTransportationType() == 1 ? "FLIGHT" : "OTHER";
                RouteStepDto step = new RouteStepDto(
                        transportation.getOrigin().getName(),
                        transportation.getDestination().getName(),
                        type
                );
                currentPath.add(step);
                if (transportation.getDestination().getId().equals(toLocationId)) {
                    if (containsFlight(currentPath) && isValidRoute(currentPath)) {
                        routes.add(new RouteResponse(new ArrayList<>(currentPath)));
                    }
                } else {
                    findRoutes(transportation.getDestination().getId(), toLocationId, currentPath, routes);
                }
                //fonk içinde fonk çağırdığım için bir önceki adımı çıkartıyorum
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    private boolean containsFlight(List<RouteStepDto> currentPath) {
        return currentPath.stream().anyMatch(step -> step.getTransportationType().equals("FLIGHT"));
    }

    private boolean isValidRoute(List<RouteStepDto> currentPath) {
        int flightCount = 0;
        int beforeFlightCount = 0;
        int afterFlightCount = 0;

        boolean flightOccurred = false;// befor ve after uçuşlarını kontrol etmek için ekledim.

        for (int i = 0; i < currentPath.size(); i++) {
            String type = currentPath.get(i).getTransportationType();

            if (type.equals("FLIGHT")) {
                flightCount++;
                flightOccurred = true;
            } else if (!flightOccurred) {
                beforeFlightCount++;
            } else {
                afterFlightCount++;
            }

            if (flightCount > 1) return false; // birden fazla uçuş var mı kontrolü
            if (beforeFlightCount > 1) return false; // before flighta birden fazla other var mı
            if (afterFlightCount > 1) return false; // after flighta birden fazla other var mı
        }

        if (currentPath.size() > 3) return false; // 3 ten fazla tranportation yasak
        if (flightCount == 0) return false; // bir tane uçuş olmalı

        return true;
    }
}
