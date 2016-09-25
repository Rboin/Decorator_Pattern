package com.dp;

import com.dp.game.Animation;

public class Main {

    public static void main(String[] args) {

        int WIDTH = 1366, HEIGHT = 768;

        Animation animation = new Animation(WIDTH, HEIGHT);
        animation.init(5, 100, 100);

    }
}
