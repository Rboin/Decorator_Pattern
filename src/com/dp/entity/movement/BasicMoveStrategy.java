package com.dp.entity.movement;

/**
 * Created by robin on 9/23/16.
 */
public class BasicMoveStrategy implements MoveStrategy {

    private final int MAX_WIDTH, MAX_HEIGHT;
    private int width, height;
    private float[] position, velocity, acceleration;

    public BasicMoveStrategy(float[] position, float[] velocity, float[] acceleration,
                             int width, int height, int maxWidth, int maxHeight) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.width = width;
        this.height = height;
        this.MAX_WIDTH = maxWidth;
        this.MAX_HEIGHT = maxHeight;
    }

    @Override
    public void move(long deltaTime) {
        this.velocity[0] += this.acceleration[0] * deltaTime;
        this.velocity[1] += this.acceleration[1] * deltaTime;

        if (this.position[0] <= 0) {
            this.position[0] = 0;
            if (this.velocity[0] <= 0)
                this.velocity[0] *= -1;
        } else if (this.position[0] + width >= MAX_WIDTH) {
            this.position[0] = MAX_WIDTH - width;
            if (this.velocity[0] >= 0)
                this.velocity[0] *= -1;
        }

        if (this.position[1] <= 0) {
            this.position[1] = 0;
            if (this.velocity[1] <= 0)
                this.velocity[1] *= -1;
        } else if (this.position[1] + height >= MAX_HEIGHT) {
            this.position[1] = MAX_HEIGHT - height;
            if (this.velocity[1] >= 0)
                this.velocity[1] *= -1;
        }

        this.position[0] += this.velocity[0] * (deltaTime * 0.5f);
        this.position[1] += this.velocity[1] * (deltaTime * 0.5f);
    }

    @Override
    public float getX() {
        return this.position[0];
    }

    @Override
    public float getY() {
        return this.position[1];
    }
}
