package com.vmware.crossingbridgeapi.service.animal;

public class Pig extends Animal {

    public Pig(int duration) {
        super(duration);
    }

    @Override
    public String walk() {
        return "trot";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.PIG;
    }
}
