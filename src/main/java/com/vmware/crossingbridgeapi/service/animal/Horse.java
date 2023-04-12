package com.vmware.crossingbridgeapi.service.animal;

public class Horse extends Animal {

    public Horse(int duration) {
        super(duration);
    }

    @Override
    public String walk() {
        return "gallop";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.HORSE;
    }
}
