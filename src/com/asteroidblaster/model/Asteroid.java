package com.asteroidblaster.model;

import com.asteroidblaster.util.Constants;
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

    public static Asteroid spawnRandom(int screenW, int screenH) {
        // Spawn on the edge of screen
        double x, y;

        if (random.nextBoolean()) {
            x = random.nextBoolean() ? -Constants.ASTEROID_SPAWN_MARGIN : screenW + Constants.ASTEROID_SPAWN_MARGIN;
            y = random.nextDouble() * screenH;
        } else {
            x = random.nextDouble() * screenW;
            y = random.nextBoolean() ? -Constants.ASTEROID_SPAWN_MARGIN : screenH + Constants.ASTEROID_SPAWN_MARGIN;
        }

        double angle = random.nextDouble() * Math.PI * 2;
        double speed = Constants.ASTEROID_LARGE_SPEED * (0.8 + random.nextDouble() * 0.4);
        
        return new Asteroid(x, y, Math.cos(angle) * speed, Math.sin(angle) * speed, Size.LARGE);
    }

    public void update(int screenW, int screenH) {
        x += velocityX;
        y += velocityY;
        rotation += rotationSpeed;

        // Wrap
        double wrapMargin = radius() + 10;
        if (x < -wrapMargin) {
            x += screenW + wrapMargin * 2;
        } else if (x > screenW + wrapMargin) {
            x -= screenW + wrapMargin * 2;
        } else if (y < -wrapMargin) {
            y += screenH + wrapMargin * 2;
        } else if (y > screenH + wrapMargin) {
            y -= screenH + wrapMargin * 2;
        }
    }
}
