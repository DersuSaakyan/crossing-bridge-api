package com.vmware.crossingbridgeapi.service;

import com.vmware.crossingbridgeapi.service.animal.Animal;

import java.util.List;

public class AnimalCrossingData {
    private final Animal crosser1;
    private Animal crosser2;

    private AnimalCrossingData(Animal crosser1, Animal crosser2) {
        this.crosser1 = crosser1;
        this.crosser2 = crosser2;
    }

    private AnimalCrossingData(Animal torchReturner) {
        this.crosser1 = torchReturner;
    }

    public List<Animal> getCrossingAnimals() {
        return List.of(crosser1, crosser2);
    }

    public Animal getTorchReturner() {
        return crosser1;
    }

    public boolean isBackCrossingTime() {
        return crosser2 == null;
    }

    public static AnimalCrossingData crossingAnimals(Animal crosser1, Animal crosser2) {
        return new AnimalCrossingData(crosser1, crosser2);
    }

    public static AnimalCrossingData torchReturner(Animal torchReturner) {
        return new AnimalCrossingData(torchReturner);
    }
}
