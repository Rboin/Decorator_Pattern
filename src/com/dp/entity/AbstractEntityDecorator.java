package com.dp.entity;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public abstract class AbstractEntityDecorator implements Entity {

    private Entity entity;

    public AbstractEntityDecorator(Entity e) {
        this.entity = e;
    }

    /**
     * Draws the base Entity. You can add extra graphics in the decorators.
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        this.entity.draw(g);
    }

    @Override
    public void move(long deltaTime) {
        this.entity.move(deltaTime);
    }

    @Override
    public void setColor(Color c) {
        this.entity.setColor(c);
    }
}
