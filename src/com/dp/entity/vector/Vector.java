package com.dp.entity.vector;

/**
 * Created by robin on 9/24/16.
 */
public abstract class Vector<T> implements Comparable<Vector> {

    T x, y;

    public Vector(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public void setX(T data) {
        this.x = data;
    }

    public T getY() {
        return this.y;
    }

    public void setY(T data) {
        this.y = data;
    }

    public abstract void add(T x, T y);

}
