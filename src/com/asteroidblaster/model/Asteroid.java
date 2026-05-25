package com.asteroidblaster.model;

public class Asteroid {

    public enum Size { LARGE, MEDIUM, SMALL };

    public double x, y;
    public double velocityX, velocityY;
    public double rotation;  // In degrees
}
