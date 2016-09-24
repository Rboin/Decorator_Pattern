package com.dp.entity.decorator;

import com.dp.entity.Entity;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public class RedEntityDecorator extends AbstractEntityDecorator {

    public RedEntityDecorator(Entity e) {
        super(e);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.red);
        g.fillRect((int) this.getX(), (int) this.getY(), this.getWidth(), this.getHeight());
    }

    @Override
    public void move(long deltaTime) {
        super.move(deltaTime);
    }

}
