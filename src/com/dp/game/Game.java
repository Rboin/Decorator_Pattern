package com.dp.game;

import com.dp.entity.Entity;
import com.dp.entity.factory.EntityFactory;
import com.dp.entity.factory.EntityType;
import com.dp.gui.Panel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by robin on 9/22/16.
 */
public class Game {

    public final int WIDTH, HEIGHT;

    private JFrame frame;
    private Panel panel;
    private Random random;
    private EntityFactory factory;

    private List<Entity> entities;

    public Game(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        this.random = new Random();
        this.entities = new ArrayList<>();
        this.factory = new EntityFactory();

        this.frame = new JFrame("Decorator");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(WIDTH, HEIGHT);

        this.panel = new Panel(WIDTH, HEIGHT);
        this.panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        this.frame.add(this.panel);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }

    public void init(int n, int width, int height) {
        initEntities(n, width, height);
        this.panel.setEntities(this.entities);
        loop();
    }

    private void loop() {
        long startTime,
                deltaTime = 0;
        while (true) {
            startTime = System.currentTimeMillis();
            for (Entity e : this.entities)
                e.move(deltaTime);
            this.frame.repaint();

            deltaTime = System.currentTimeMillis() - startTime;
        }
    }

    private void initEntities(int n, int width, int height) {
        for (int i = 0; i < n; i++) {
            this.entities.add(createEntity(i, width, height));
        }
    }

    private Entity createEntity(int i, int width, int height) {
        if (i % 2 == 0)
            return this.factory.getEntity(EntityType.RED, this.panel.getWidth(), this.panel.getHeight(), width, height, this.random);
        return this.factory.getEntity(EntityType.YELLOW, this.panel.getWidth(), this.panel.getHeight(), width, height, this.random);
    }


}
