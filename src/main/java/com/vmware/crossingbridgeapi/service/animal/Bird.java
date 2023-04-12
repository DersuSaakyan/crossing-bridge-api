package com.vmware.crossingbridgeapi.service.animal;

public class Bird extends Animal{

    public Bird(int duration) {
        super(duration);
    }

    @Override
    public String walk() {
        return "fly";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.BIRD;
    }
}
