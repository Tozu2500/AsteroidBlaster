package com.asteroidblaster.model;

import com.asteroidblaster.util.Constants;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Starfield {

    private final int[] starX, starY, brightness;
    private final float[] sizes;
    private static final Random random = new Random();

    public Starfield(int screenWidth, int screenHeight) {
        int starCount = Constants.STAR_COUNT;
        starX = new int[starCount];
        starY = new int[starCount];

        brightness = new int[starCount];
        sizes = new float[starCount];

        for (int i = 0; i < starCount; i++) {
            starX[i] = random.nextInt(screenWidth);
            starY[i] = random.nextInt(screenHeight);
            brightness[i] = 60 + random.nextInt(160);
            sizes[i] = 0.8f + random.nextFloat() * 1.8f;
        }
    }

    public void draw(Graphics2D graphics) {
        for (int i = 0; i < starX.length; i++) {
            int currentBrightness = brightness[i];

            // A subtle twinkle using index as phase offset
            long currentTimeMs = System.currentTimeMillis();
            float twinkle = 0.7f + 0.3f * (float) Math.sin(currentTimeMs / 700.0 + i * 1.3);
            int adjustedBrightness = (int)(currentBrightness * twinkle);
            graphics.setColor(new Color(adjustedBrightness, adjustedBrightness, Math.min(255, adjustedBrightness + 20)));
            int starSize = Math.max(1, (int) sizes[i]);
            graphics.fillOval(starX[i] - starSize / 2, starY[i] - starSize / 2, starSize, starSize);
        }
    }
}
