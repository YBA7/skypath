package com.skypath.skypath.request;

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
    private Integer transportationType;
}
