package com.dp.entity;

import java.awt.*;

/**
 * Created by robin on 9/22/16.
 */
public interface Entity {
    void draw(Graphics g);

    void move(long deltaTime);

    void setColor(Color c);
}
