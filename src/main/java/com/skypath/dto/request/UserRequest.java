package com.skypath.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "Username cannot be null.")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters.")
    private String username;

    @NotNull(message = "Password cannot be null.")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @NotNull(message = "Role cannot be null.")
    private String role;
}
