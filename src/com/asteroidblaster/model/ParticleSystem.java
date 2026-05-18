package com.asteroidblaster.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticleSystem {

    private static final Random random = new Random();

    private static class Particle {
        double x, y, velocityX, velocityY;
        int life, maxLife;
        Color color;
        float size;
    }

    private final List<Particle> particles = new ArrayList<>();

    public void explode(double x, double y, int count, Color baseColor, float sizeRange) {
        for (int i = 0; i < count; i++) {
            Particle particle = new Particle();
            particle.x = x + random.nextGaussian() * 3;
            particle.y = y + random.nextGaussian() * 3;

            double angle = random.nextDouble() * Math.PI * 2;
            double speed = 1.5 + random.nextDouble() * 4;

            particle.velocityX = Math.cos(angle) * speed;
            particle.velocityY = Math.sin(angle) * speed;
            particle.maxLife = particle.life = 30 + random.nextInt(30);
            particle.size = 1.5f + random.nextFloat() * sizeRange;

            // Randomize coloring
            int red = Math.min(255, baseColor.getRed() + random.nextInt(40) - 20);
            int green = Math.min(255, baseColor.getGreen() + random.nextInt(40) - 20);
            int blue = Math.min(255, baseColor.getBlue() + random.nextInt(40) - 20);

            particle.color = new Color(Math.max(0, red), Math.max(0, green), Math.max(0, blue));
            particles.add(particle);
        }
    }

    public void update() {
        particles.removeIf(particle -> {
            particle.x += particle.velocityX;
            particle.y += particle.velocityY;

            particle.velocityX *= 0.93;
            particle.velocityY *= 0.93;

            return --particle.life <= 0;
        });
    }

    public void draw(Graphics2D g2) {
        for (Particle particle : particles) {
            float alpha = (float) particle.life / particle.maxLife;

            Color c = new Color(particle.color.getRed() / 255f,
                particle.color.getGreen() / 255f,
                particle.color.getBlue() / 255f, alpha * alpha);
            g2.setColor(c);
            int s = (int) (particle.size * alpha + 1);
            g2.fillOval((int) particle.x - s / 2, (int) particle.y - s / 2, s, s);
        }
    }
}
