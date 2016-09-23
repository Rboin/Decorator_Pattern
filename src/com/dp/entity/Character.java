package com.dp.entity;

import com.dp.entity.movement.MoveStrategy;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public class Character implements Entity {

    private final MoveStrategy strategy;
    private Color color;
    private int width, height;

    private int MAX_WIDTH, MAX_HEIGHT;

    public Character(int width, int height, MoveStrategy strategy) {
        this.width = width;
        this.height = height;
        this.strategy = strategy;
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

    //</editor-fold>

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(((int) (this.strategy.getX())), ((int) (this.strategy.getY())),
                this.width, this.height);
    }

    /**
     * Basic move function.
     * Just uses position, velocity and acceleration vectors
     * and moves based on the elapsed time.
     *
     * @param deltaTime
     */
    @Override
    public void move(long deltaTime) {
        this.strategy.move(deltaTime);
    }

    @Override
    public void setColor(Color c) {
        this.color = c;
    }
}
