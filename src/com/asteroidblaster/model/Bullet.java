package com.asteroidblaster.model;

import com.asteroidblaster.util.Constants;
import com.asteroidblaster.util.Vector2D;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bullet {

    public double x, y;
    private final double velocityX, velocityY;
    private int life;
    public boolean dead;

    public Bullet(double x, double y, double angleDeg) {
        this.x = x;
        this.y = y;
        Vector2D dir = Vector2D.fromAngleDeg(angleDeg);
        this.velocityX = dir.x * Constants.BULLET_SPEED;
        this.velocityY = dir.y * Constants.BULLET_SPEED;
        this.life = Constants.BULLET_LIFETIME;
    }

    public void update(int screenW, int screenH) {
        x += velocityX;
        y += velocityY;

        // Wrap
        if (x < 0) {
            x += screenW;
        } else if (x > screenW) {
            x -= screenW;
        } else if (y < 0) {
            y += screenH;
        } else if (y > screenH) {
            y -= screenH;
        }

        if (--life <= 0) dead = true;
    }

    public void draw(Graphics2D g2) {
        // Bright yellow white core with glow
        float alpha = Math.min(1f, life / 15f);
        g2.setColor(new Color(1f, 1f, 0.5f, alpha * 0.35f));
        g2.fillOval((int) x - 5, (int) y - 5, 10, 10);

        g2.setColor(new Color(255, 255, 180));
        g2.fillOval((int) x - 2, (int) y - 2, 5, 5);
    }

    public double radius() {
        return 3;
    }

}
