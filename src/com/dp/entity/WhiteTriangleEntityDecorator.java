package com.dp.entity;

import java.awt.*;

/**
 * Created by robin on 9/24/16.
 */
public class WhiteTriangleEntityDecorator extends AbstractEntityDecorator {

    public WhiteTriangleEntityDecorator(Entity e) {
        super(e);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.WHITE);
        g.fillPolygon(new int[]{(int) this.getX(), (int) this.getX() + getWidth() / 2, (int) this.getX() + getWidth()},
                new int[]{(int) this.getY(), (int) this.getY() - getHeight(), (int) this.getY()}, 3);
    }
}
