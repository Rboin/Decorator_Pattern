package com.dp.entity.movement;

import com.dp.entity.vector.Vector2D;

/**
 * Created by robin on 9/23/16.
 */
public class BasicMoveStrategy implements MoveStrategy {

    private final int MAX_WIDTH, MAX_HEIGHT;
    private int width, height;
    private float[] velocity, acceleration;

    private Vector2D position;

    public BasicMoveStrategy(Vector2D position, float[] velocity, float[] acceleration,
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

        if (this.position.getX() <= 0) {
            this.position.setX(0f);
            if (this.velocity[0] <= 0)
                this.velocity[0] *= -1;
        } else if (this.position.getX() + width >= MAX_WIDTH) {
            this.position.setX((float) MAX_WIDTH - width);
            if (this.velocity[0] >= 0)
                this.velocity[0] *= -1;
        }

        if (this.position.getY() <= 0) {
            this.position.setY(0f);
            if (this.velocity[1] <= 0)
                this.velocity[1] *= -1;
        } else if (this.position.getY() + height >= MAX_HEIGHT) {
            this.position.setY((float) MAX_HEIGHT - height);
            if (this.velocity[1] >= 0)
                this.velocity[1] *= -1;
        }

        this.position.add(this.velocity[0] * (deltaTime * 0.3f),
                this.velocity[1] * (deltaTime * 0.3f));
    }

    @Override
    public float getX() {
        return this.position.getX();
    }

    @Override
    public float getY() {
        return this.position.getY();
    }
}
