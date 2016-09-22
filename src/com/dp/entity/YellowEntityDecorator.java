package com.dp.entity;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public class YellowEntityDecorator extends AbstractEntityDecorator {
    public YellowEntityDecorator(Entity e) {
        super(e);
        setColor(Color.yellow);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        System.out.println("Drawing yellow.");
    }

    @Override
    public void move(long deltaTime) {
        super.move(deltaTime);
        System.out.println("Moving yellow.");
    }

    @Override
    public void setColor(Color c) {
        super.setColor(c);
    }
}
