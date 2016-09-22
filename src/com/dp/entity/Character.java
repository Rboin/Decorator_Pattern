package com.dp.entity;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public class Character implements Entity {

    private Color color;
    private int width, height;

    private int MAX_WIDTH, MAX_HEIGHT;
    private float[] position, velocity, acceleration;

    public Character(float[] position, float[] velocity, float[] acceleration,
                     int width, int height, int maxWidth, int maxHeight) {
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.width = width;
        this.height = height;
        this.MAX_WIDTH = maxWidth;
        this.MAX_HEIGHT = maxHeight;
    }

    //<editor-fold desc="Setters">
    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMaxWidth(int mWidth) {
        this.MAX_WIDTH = mWidth;
    }

    public void setMaxHeight(int mHeight) {
        this.MAX_HEIGHT = mHeight;
    }

    public void setPosition(float[] initial) {
        this.position = initial;
    }

    public void setVelocity(float[] initial) {
        this.velocity = initial;
    }

    public void setAcceleration(float[] initial) {
        this.acceleration = initial;
    }
    //</editor-fold>

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(((int) (this.position[0])), ((int) (this.position[1])),
                this.width, this.height);
    }

    @Override
    public void move(long deltaTime) {
        System.out.println("Moving Character.");
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
    public void setColor(Color c) {
        this.color = c;
    }
}
