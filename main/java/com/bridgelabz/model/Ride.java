package com.bridgelabz.model;

public class Ride {
    public double distance;
    public int time;
    public Ride(double distance, int time) {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
