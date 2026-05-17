package com.asteroidblaster.model;

import java.awt.Color;
import java.util.Random;

public class ParticleSystem {

    private static final Random random = new Random();

    private static class Particle() {
        double x, y, vx, vy;
        int life, maxLife;
        Color color;
        float size;
    }

}
