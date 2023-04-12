package com.vmware.crossingbridgeapi.service.animal;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Optional;

public enum AnimalType {
    BEAR,
    BULL,
    BIRD,
    HARE,
    HORSE,
    PIG,
    COW;

    public static Optional<AnimalType> fromString(String type) {
        return Arrays.stream(AnimalType.values())
                .filter(item -> StringUtils.hasLength(type) && item.name().equalsIgnoreCase(type))
                .findFirst();
    }
}
