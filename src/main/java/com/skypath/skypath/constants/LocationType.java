package com.skypath.skypath.constants;

public enum LocationType {
    FROM(1),
    TO(2);

    private final int value;

    LocationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

