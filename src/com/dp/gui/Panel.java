package com.dp.gui;

import com.dp.entity.Entity;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robin on 9/22/16.
 */
public class Panel extends JPanel {

    private List<Entity> entities;
    private BufferedImage buffer;
    private Graphics2D graphics2D;

    public Panel(int width, int height) {
        this.entities = new ArrayList<>();
    }

    public void addEntity(Entity e) {
        this.entities.add(e);
    }

    public void setEntities(List<Entity> l) {
        this.entities = l;
    }

    private void createGraphics() {
        this.buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        this.graphics2D = this.buffer.createGraphics();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if (this.graphics2D == null)
            createGraphics();

        this.graphics2D.setColor(Color.BLACK);
        this.graphics2D.fillRect(0, 0, getWidth(), getHeight());

        for (Entity e : this.entities)
            e.draw(this.graphics2D);

        graphics.drawImage(this.buffer, 0, 0, null);
    }
}
