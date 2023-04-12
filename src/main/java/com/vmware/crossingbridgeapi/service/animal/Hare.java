package com.vmware.crossingbridgeapi.service.animal;

public class Hare extends Animal {

    public Hare(int duration) {
        super(duration);
    }

    @Override
    public String walk() {
        return "bound";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.HARE;
    }
}
