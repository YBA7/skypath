package com.skypath.validation.validator;

import com.skypath.validation.annotation.ValidLocationType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class LocationTypeValidator implements ConstraintValidator<ValidLocationType, Integer> {

    private static final Set<Integer> VALID_TYPES = Set.of(1, 2);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && VALID_TYPES.contains(value);
    }
}
