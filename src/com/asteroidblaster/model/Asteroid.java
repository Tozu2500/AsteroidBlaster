package com.asteroidblaster.model;

import java.util.Random;

public class Asteroid {

    public enum Size { LARGE, MEDIUM, SMALL };

    public double x, y;
    public double velocityX, velocityY;
    public double rotation;  // In degrees
    public double rotationSpeed;
    public final Size size;
    public boolean dead;

    private final int[] polygonX, polygonY;
    private static final Random random = new Random();

    public Asteroid(double x, double y, double velocityX, double velocityY, Size size) {
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.size = size;
        this.rotationSpeed = (random.nextDouble() * 2.5 + 0.5) * (random.nextBoolean() ? 1 : -1);

        // Generate a jagged polygon
        int baseRadius = (int) radius();
        int points = 10 + random.nextInt(4);

        polygonX = new int[points];
        polygonY = new int[points];

        for (int i = 0; i < points; i++) {
            double a = Math.PI * 2 * i / points;
            double jaggedRadius = baseRadius * (0.72 + random.nextDouble() * 0.28);
            polygonX[i] = (int) (Math.cos(a) * jaggedRadius);
            polygonY[i] = (int) (Math.sin(a) * jaggedRadius);
        }
    }

    
}
