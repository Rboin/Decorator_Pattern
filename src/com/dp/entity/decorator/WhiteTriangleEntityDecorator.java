package com.dp.entity.decorator;

import com.dp.entity.Entity;

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
        int[] x = new int[]{
                (int) this.getX(),
                (int) this.getX() + getWidth() / 2,
                (int) this.getX() + getWidth()
        };
        int[] y = new int[]{
                (int) this.getY(),
                (int) this.getY() - getHeight() / 2,
                (int) this.getY()
        };
        g.fillPolygon(x, y, 3);
    }
}

