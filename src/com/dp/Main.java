package com.dp;

import com.dp.entity.Character;
import com.dp.entity.Entity;
import com.dp.entity.RedEntityDecorator;
import com.dp.entity.YellowEntityDecorator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int WIDTH = 800, HEIGHT = 600;

        List<Entity> entities = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Entity e = new Character(new float[] {i*10, i*10}, new float[] {1f, 1f},
                    new float[] {0f, 0f}, 10, 10, WIDTH, HEIGHT);

            if(i % 2 == 0)
                entities.add(new YellowEntityDecorator(e));
            else
                entities.add(new RedEntityDecorator(e));
        }

    }
}
