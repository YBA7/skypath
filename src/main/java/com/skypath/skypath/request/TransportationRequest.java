package com.skypath.skypath.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportationRequest {
    private Long originId;         // Başlangıç noktasının ID'si (Location ID)
    private Long destinationId;    // Varış noktasının ID'si (Location ID)
    private Integer transportationType; // Taşımacılık tipi (1: FLIGHT, 2: OTHER)
}
