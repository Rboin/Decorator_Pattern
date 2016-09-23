package com.dp.game;

import com.dp.entity.Character;
import com.dp.entity.Entity;
import com.dp.entity.RedEntityDecorator;
import com.dp.entity.YellowEntityDecorator;
import com.dp.entity.movement.BasicMoveStrategy;
import com.dp.entity.movement.MoveStrategy;
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

    private List<Entity> entities;

    public Game(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        this.random = new Random();
        this.entities = new ArrayList<>();

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
        long startTime = 0,
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
            return createRedEntity(width, height);
        return createYellowEntity(width, height);
    }

    private Entity createRedEntity(int width, int height) {
        MoveStrategy strategy = new BasicMoveStrategy(new float[]{random.nextInt(WIDTH), random.nextInt(HEIGHT)}, new float[]{1f, 1f},
                new float[]{0f, 0f}, width, height, WIDTH, HEIGHT);
        Entity e = new Character(width, height, strategy);

        Entity decorator = new RedEntityDecorator(e);
        return decorator;
    }

    private Entity createYellowEntity(int width, int height) {
        MoveStrategy strategy = new BasicMoveStrategy(new float[]{random.nextInt(WIDTH), random.nextInt(HEIGHT)}, new float[]{1f, 1f},
                new float[]{0f, 0f}, width, height, WIDTH, HEIGHT);
        Entity e = new Character(width, height, strategy);

        Entity decorator = new YellowEntityDecorator(e);
        return decorator;
    }


}
