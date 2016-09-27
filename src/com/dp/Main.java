package com.dp;

import com.dp.game.Animation;

public class Main {

    public static void main(String[] args) {

        int WIDTH = 1366, HEIGHT = 768;

        Animation animation = new Animation(WIDTH, HEIGHT);
        animation.init(5, 100, 100);
        //animation.init(100, 50, 50);
        //animation.init(5000, 10, 10);
        //animation.init(100000, 5, 5);

    }
}
