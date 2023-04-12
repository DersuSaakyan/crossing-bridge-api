package com.vmware.crossingbridgeapi.service.animal;

public class Bear extends Animal {

    public Bear(int duration) {
        super(duration);
    }

    @Override
    public String walk() {
        return "lumber";
    }

    @Override
    public AnimalType getType() {
        return AnimalType.BEAR;
    }
}
