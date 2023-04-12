package com.vmware.crossingbridgeapi.service;

import com.vmware.crossingbridgeapi.request.AnimalCrossingRequest;
import com.vmware.crossingbridgeapi.response.AnimalCrossingResponse;
import com.vmware.crossingbridgeapi.service.animal.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    public AnimalCrossingResponse crossingCalculate(List<AnimalCrossingRequest> animaDtoList) {
        final List<Animal> animals = animaDtoList.stream()
                .map(this::getAnimal)
                .collect(Collectors.toList());

        final Bridge bridge = new Bridge();
        bridge.crossingBridge(animals);

        final List<String> animalsCrossingPLan = animals.stream()
                .map(Animal::talk)
                .collect(Collectors.toList());

        return new AnimalCrossingResponse(animalsCrossingPLan, bridge.getCrossingDuration(), bridge.getCrossingCount());
    }

    private Animal getAnimal(AnimalCrossingRequest animalCrossingRequest) {
        final AnimalType animalType = AnimalType.fromString(animalCrossingRequest.getType())
                .orElseThrow(() -> new IllegalArgumentException("Unsupported animal type. See supported types: " + Arrays.toString(AnimalType.values())));

        switch (animalType) {
            case BEAR:
                return new Bear(animalCrossingRequest.getDuration());
            case BIRD:
                return new Bird(animalCrossingRequest.getDuration());
            case BULL:
                return new Bull(animalCrossingRequest.getDuration());
            case PIG:
                return new Pig(animalCrossingRequest.getDuration());
            case COW:
                return new Cow(animalCrossingRequest.getDuration());
            case HARE:
                return new Hare(animalCrossingRequest.getDuration());
            case HORSE:
                return new Horse(animalCrossingRequest.getDuration());
            default:
                throw new IllegalArgumentException("Invalid animal type");
        }
    }
}
