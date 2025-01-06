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

    //todo dokümandaki gibi koşullar uymadığında hata bastırmayı unutma burada kontrolleri eklemedik henüz.
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
                RouteStepDto step = new RouteStepDto(
                        transportation.getOrigin().getName(),
                        transportation.getDestination().getName(),
                        transportation.getTransportationType() == 1 ? "FLIGHT" : "OTHER"
                );

                currentPath.add(step);
                if (transportation.getDestination().getId().equals(toLocationId)) {
                    routes.add(new RouteResponse(new ArrayList<>(currentPath)));
                } else {
                    findRoutes(transportation.getDestination().getId(), toLocationId, currentPath, routes);
                }
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

}
