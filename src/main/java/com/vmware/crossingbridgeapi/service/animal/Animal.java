package com.vmware.crossingbridgeapi.service.animal;

public abstract class Animal {

    private final int duration;
    private int crossingDuration;
    private int torchHoldingDuration;

    public Animal(int duration) {
        this.duration = duration;
    }

    public abstract String walk();

    public abstract AnimalType getType();

    public String talk() {
        return String.format("We devised our crossing plan, according to which I(%s) should " +
                        "%s for %d minutes in total, and I'll be holding the torch for %d minutes overall.",
                getType(), walk(), crossingDuration, torchHoldingDuration);
    }

    public void addToTorchHoldingDuration(int duration) {
        torchHoldingDuration += duration;
    }

    public void addToCrossingDuration(int duration) {
        crossingDuration += duration;
    }

    public int getDuration() {
        return duration;
    }
}
