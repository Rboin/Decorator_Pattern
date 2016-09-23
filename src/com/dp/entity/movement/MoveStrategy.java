package com.dp.entity.movement;

/**
 * Created by robin on 9/23/16.
 */
public interface MoveStrategy {

    void move(long deltaTime);
    float getX();
    float getY();

}
