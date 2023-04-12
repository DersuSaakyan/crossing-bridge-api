package com.vmware.crossingbridgeapi.request;

public class AnimalCrossingRequest {

    private String type;
    private int duration;

    public String getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
