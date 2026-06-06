package com.asteroidblaster.model;

import com.asteroidblaster.util.Constants;

public class Player {

    public double x, y;
    public double velocityX, velocityY;
    public double angle;  // in degrees
    public int lives;
    public boolean thrusting;
    public boolean dead;

    private long invincibleUntil;
    private int shootCooldown;

    // Exhaust flicker effect
    private int flameTick;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        this.angle = 90;
        this.lives = Constants.PLAYER_LIVES;
    }

}
