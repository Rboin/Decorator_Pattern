package com.dp.entity;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public class RedEntityDecorator extends AbstractEntityDecorator {

    public RedEntityDecorator(Entity e) {
        super(e);
        setColor(Color.red);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        System.out.println("Drawing red.");
    }

    @Override
    public void move(long deltaTime) {
        super.move(deltaTime);
        System.out.println("Moving red.");
    }

    @Override
    public void setColor(Color c) {
        super.setColor(c);
    }
}
