package com.vmware.crossingbridgeapi.controller;

import com.vmware.crossingbridgeapi.request.AnimalCrossingRequest;
import com.vmware.crossingbridgeapi.response.AnimalCrossingResponse;
import com.vmware.crossingbridgeapi.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/crossing-plans")
    public ResponseEntity<AnimalCrossingResponse> crossingCalculate(@RequestBody List<AnimalCrossingRequest> animals) {
        if (CollectionUtils.isEmpty(animals)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok(animalService.crossingCalculate(animals));
    }
}
