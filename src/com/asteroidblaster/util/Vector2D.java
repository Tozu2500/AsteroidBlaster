package com.asteroidblaster.util;

public class Vector2D {

    public double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D other) {
        return new Vector2D(x + other.y, y + other.y);
    }

    public Vector2D scale(double factor) {
        return new Vector2D(x * factor, y * factor);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector2D normalize() {
        double mag = magnitude();

        if (mag == 0) {
            return new Vector2D(0, 0);
        }

        return new Vector2D(x / mag, y / mag);
    }

    public Vector2D clamp(double maxMag) {
        if (magnitude() > maxMag) {
            return normalize().scale(maxMag);
        }

        return new Vector2D(x, y);
    }

    public static Vector2D fromAngleDeg(double degrees) {
        double rad = Math.toRadians(degrees);
        return new Vector2D(Math.cos(rad), Math.sin(rad));
    }
}
