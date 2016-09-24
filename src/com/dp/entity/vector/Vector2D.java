package com.dp.entity.vector;

/**
 * Created by robin on 9/24/16.
 */
public class Vector2D extends Vector<Float> {

    public Vector2D(Float x, Float y) {
        super(x, y);
    }

    @Override
    public void add(Float x, Float y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public int compareTo(Vector vector) {
        float vecX = (float) vector.getX(),
                vecY = (float) vector.getY();

        if (this.x < vecX && this.y < vecY)
            return -1;
        if (this.x == vecX && this.y == vecY)
            return 0;
        if (this.x > vecX && this.y > vecY)
            return 1;

        return -2;
    }
}
