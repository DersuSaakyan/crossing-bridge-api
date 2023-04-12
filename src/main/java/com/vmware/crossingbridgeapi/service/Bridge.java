package com.vmware.crossingbridgeapi.service;

import com.vmware.crossingbridgeapi.service.animal.Animal;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Bridge {

    private int crossingDuration;
    private int crossingCount;
    private final Queue<AnimalCrossingData> animalCrossingData;

    public Bridge() {
        animalCrossingData = new LinkedList<>();
    }

    public void crossingBridge(List<Animal> animals) {

        final List<Animal> sortedAnimals = animals.stream()
                .sorted(Comparator.comparingInt(Animal::getDuration))
                .collect(Collectors.toList());

        addCrossingAnimalsToQueue(sortedAnimals);
        crossingCount = animalCrossingData.size();

        for (AnimalCrossingData crossingData : animalCrossingData) {
            if (crossingData.isBackCrossingTime()) {
                final Animal torchReturner = crossingData.getTorchReturner();
                calculateBackCrossingDurations(torchReturner);
            } else {
                calculateForthCrossingDurations(crossingData.getCrossingAnimals());
            }
        }
    }

    public int getCrossingDuration() {
        return crossingDuration;
    }

    public int getCrossingCount() {
        return crossingCount;
    }

    // Add both pairs of animals and torch holders passing in the most optimal way to the queue
    private void addCrossingAnimalsToQueue(List<Animal> animals) {
        int size = animals.size();

        // Since there are 3 animals, it doesn't matter who brings back the torch and which pair goes first.
        // So adding them to the queue randomly.
        if (size <= 3) {
            addToQueueFor3OrLessAnimals(animals, size);
            return;
        }

        while (size >= 4) {
            // For larger elements, we use a greedy approach.
            // Choose the two elements with the smallest and largest durations and combine them with the first and second-smallest durations.
            if ((2 * animals.get(1).getDuration()) <= animals.get(size - 2).getDuration()) {

                animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(0), animals.get(1)));
                animalCrossingData.add(AnimalCrossingData.torchReturner(animals.get(0)));

                animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(size - 1), animals.get(size - 2)));
                animalCrossingData.add(AnimalCrossingData.torchReturner(animals.get(1)));
            } else {
                animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(size - 1), animals.get(0)));
                animalCrossingData.add(AnimalCrossingData.torchReturner(animals.get(0)));

                animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(size - 2), animals.get(0)));
                animalCrossingData.add(AnimalCrossingData.torchReturner(animals.get(0)));
            }

            size -= 2;
        }

        // Add remaining animals (3 or fewer) using the same approach as before.
        addToQueueFor3OrLessAnimals(animals, size);
    }

    private void addToQueueFor3OrLessAnimals(List<Animal> animals, int size) {
        if (size > 3) {
            throw new IllegalArgumentException("Size must be lower than 3");
        }

        if (animals.size() == 1) {
            animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(0), null));
            return;
        }

        if (size == 2) {
            animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(0), animals.get(1)));
            return;
        }

        animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(0), animals.get(1)));
        animalCrossingData.add(AnimalCrossingData.torchReturner(animals.get(0)));
        animalCrossingData.add(AnimalCrossingData.crossingAnimals(animals.get(0), animals.get(2)));
    }

    private void calculateForthCrossingDurations(List<Animal> crossingAnimals) {

        final Animal slowerAnimal = crossingAnimals.stream()
                .max(Comparator.comparing(Animal::getDuration)).get();

        final Animal fastestAnimal = crossingAnimals.stream()
                .min(Comparator.comparing(Animal::getDuration)).get();

        fastestAnimal.addToTorchHoldingDuration(slowerAnimal.getDuration());
        fastestAnimal.addToCrossingDuration(slowerAnimal.getDuration());

        slowerAnimal.addToCrossingDuration(slowerAnimal.getDuration());

        crossingDuration += slowerAnimal.getDuration();
    }

    private void calculateBackCrossingDurations(Animal torchReturner) {
        torchReturner.addToCrossingDuration(torchReturner.getDuration());
        torchReturner.addToTorchHoldingDuration(torchReturner.getDuration());

        crossingDuration += torchReturner.getDuration();
    }
}
