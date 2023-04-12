package com.vmware.crossingbridgeapi.service.animal;

public class Cow extends Animal {

    public Cow(int duration) {
        super(duration);
    }

    @Override
    public String walk() {
        return "wander";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.COW;
    }
}
