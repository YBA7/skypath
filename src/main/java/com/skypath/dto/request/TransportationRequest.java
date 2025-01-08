package com.skypath.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransportationRequest {
    @NotNull(message = "originId cannot be null.")
    private Long originId;
    @NotNull(message = "destinationId cannot be null.")
    private Long destinationId;
    @NotNull(message = "transportationType cannot be null.")
    @Min(value = 1, message = "Transportation type must be at least 1.")
    @Max(value = 2, message = "Transportation type cannot be greater than 2.")
    private Integer transportationType;
}
