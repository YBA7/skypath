package com.skypath.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {
    @NotNull(message = "Location name cannot be null.")
    @Size(min = 3, max = 255, message = "Location name must be between 3 and 255 characters.")
    private String name;

    @NotNull(message = "Location type is required.")
    private Integer type;

    private Long id;

    private Integer isDeleted;

    private String createdBy;

    private OffsetDateTime createDate;

    private String updatedBy;

    private OffsetDateTime updateDate;
}
