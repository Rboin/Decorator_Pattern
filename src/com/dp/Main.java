package com.dp;

import com.dp.entity.Character;
import com.dp.entity.Entity;
import com.dp.entity.RedEntityDecorator;
import com.dp.entity.YellowEntityDecorator;
import com.dp.game.Game;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int WIDTH = 800, HEIGHT = 600;

        Game game = new Game(WIDTH, HEIGHT);
        game.init(10, 10, 10);

    }
}
