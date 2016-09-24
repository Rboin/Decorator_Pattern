package com.dp.entity;

import com.dp.entity.movement.MoveStrategy;
import com.dp.entity.vector.Vector2D;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public class Character implements Entity {

    private MoveStrategy strategy;
    private Vector2D position;
    private Color color;
    private int width, height;

    private int MAX_WIDTH, MAX_HEIGHT;

    public Character(int width, int height, Vector2D position, MoveStrategy strategy) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.strategy = strategy;
    }

    //<editor-fold desc="Setters">

    public void setMaxWidth(int mWidth) {
        this.MAX_WIDTH = mWidth;
    }

    public void setMaxHeight(int mHeight) {
        this.MAX_HEIGHT = mHeight;
    }

    @Override
    public float getX() {
        return this.position.getX();
    }

    @Override
    public float getY() {
        return this.position.getY();
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    //</editor-fold>

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.drawRect((int) this.getX(), (int) this.getY(),
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
