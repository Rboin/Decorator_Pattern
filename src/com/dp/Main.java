package com.dp;

import com.dp.game.Game;

public class Main {

    public static void main(String[] args) {

        int WIDTH = 1366, HEIGHT = 768;

        Game game = new Game(WIDTH, HEIGHT);
        game.init(2, 100, 100);

    }
}
