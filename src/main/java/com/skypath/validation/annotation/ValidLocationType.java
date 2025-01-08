package com.skypath.validation.annotation;

import com.skypath.validation.validator.LocationTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocationTypeValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidLocationType {
    String message() default "Invalid location type. Allowed values are 1 or 2.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
