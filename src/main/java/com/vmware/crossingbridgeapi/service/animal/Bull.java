package com.vmware.crossingbridgeapi.service.animal;

public class Bull extends Animal{

    public Bull(int duration) {
        super(duration);
    }

    @Override
    public String walk() {
        return "charge";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.BULL;
    }
}
