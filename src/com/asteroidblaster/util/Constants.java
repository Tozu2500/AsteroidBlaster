package com.asteroidblaster.util;

public final class Constants {

    private Constants() {}

    // Window
    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;
    public static final String TITLE = "Asteroid Blaster";

    // Game loop
    public static final int TARGET_FPS = 60;
    public static final long FRAME_TIME_NS = 1_000_000_000L / TARGET_FPS;

    // Player
    public static final double PLAYER_ACCELERATION = 0.35;
    public static final double PLAYER_MAX_SPEED = 7.0;
    public static final double PLAYER_FRICTION = 0.97;
    public static final double PLAYER_ROTATION_SPEED = 4.5;  // In degrees per frame
    public static final int PLAYER_LIVES = 3;
    public static final int PLAYER_INVINCIBLE_MS = 2500;
    public static final int PLAYER_SIZE = 18;

    // Bullets
    public static final double BULLET_SPEED = 12.0;
    public static final int BULLET_LIFETIME = 55; // Frames
    public static final int SHOOT_COOLDOWN = 10; // Frames

    // Asteroids
    public static final int ASTEROID_SPAWN_MARGIN = 60;
    public static final double ASTEROID_LARGE_RADIUS = 42;
    public static final double ASTEROID_MEDIUM_RADIUS = 24;
    public static final double ASTEROID_SMALL_RADIUS = 13;
    public static final double ASTEROID_LARGE_SPEED = 1.2;
    public static final double ASTEROID_MEDIUM_SPEED = 2.1;
    public static final double ASTEROID_SMALL_SPEED = 3.4;

    // Scoring
    public static final int SCORE_LARGE = 20;
    public static final int SCORE_MEDIUM = 50;
    public static final int SCORE_SMALL = 100;

    // Star background
    public static final int STAR_COUNT = 140;

}
