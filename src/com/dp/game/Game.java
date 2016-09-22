package com.dp.game;

import com.dp.entity.Entity;
import com.dp.gui.Panel;

import javax.swing.*;
import java.util.Random;

/**
 * Created by robin on 9/22/16.
 */
public class Game {

    private final int WIDTH, HEIGHT;

    private JFrame frame;
    private Panel panel;
    private Random random;

    public Game(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.random = new Random();

        this.frame = new JFrame("Decorator");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(WIDTH, HEIGHT);

        this.panel = new Panel(WIDTH, HEIGHT);

        this.frame.add(this.panel);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }

    public void initEntities(int n) {
        for (int i = 0; i < n; i++)
            this.panel.addEntity(createEntity(i));
    }

    private Entity createEntity(int i) {
        if (i % 2 == 0)
            return createRedEntity();
        return createYellowEntity();
    }

    private Entity createRedEntity() {

    }

    private Entity createYellowEntity() {

    }


}
