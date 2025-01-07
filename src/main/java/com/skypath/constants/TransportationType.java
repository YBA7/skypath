package com.skypath.constants;

public enum TransportationType {
    FLIGHT(1),
    OTHER(2);

    private final int value;

    TransportationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
