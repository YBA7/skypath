package com.skypath.skypath.service;

import com.skypath.skypath.response.RouteResponse;

import java.util.List;

public interface RouteService {
    List<RouteResponse> calculateRoutes(Long fromLocationId, Long toLocationId);
}
