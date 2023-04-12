package com.vmware.crossingbridgeapi.response;

import java.util.List;

public class AnimalCrossingResponse {

    private final List<String> crossingPlan;
    private final int totalCrossingDuration;
    private final int totalCrossingCount;

    public AnimalCrossingResponse(List<String> crossingPlan, int totalCrossingDuration, int totalCrossingCount) {
        this.crossingPlan = crossingPlan;
        this.totalCrossingDuration = totalCrossingDuration;
        this.totalCrossingCount = totalCrossingCount;
    }

    public List<String> getCrossingPlan() {
        return crossingPlan;
    }

    public int getTotalCrossingDuration() {
        return totalCrossingDuration;
    }

    public int getTotalCrossingCount() {
        return totalCrossingCount;
    }
}
