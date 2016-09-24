package com.dp.entity.factory;

import com.dp.entity.Character;
import com.dp.entity.*;
import com.dp.entity.movement.BasicMoveStrategy;
import com.dp.entity.movement.MoveStrategy;
import com.dp.entity.vector.Vector2D;

import java.awt.*;
import java.util.Random;

public class EntityFactory {

    public Entity getEntity(EntityType type, int maxWidth, int maxHeight, int width, int height, Random random) {
        switch (type) {
            case BASIC:
                return createBasicEntity(maxWidth, maxHeight, width, height, random);
            case RED:
                return createRedEntity(maxWidth, maxHeight, width, height, random);
            case YELLOW:
                return createYellowEntity(maxWidth, maxHeight, width, height, random);
            case RED_WITH_WHITE_HAT:
                return createRedEntityWithWhiteHat(maxWidth, maxHeight, width, height, random);
            case YELLOW_WITH_WHITE_HAT:
                return createYellowEntityWithWhiteHat(maxWidth, maxHeight, width, height, random);
        }
        return null;
    }

    private Entity createBasicEntity(int maxWidth, int maxHeight, int width, int height, Random random) {
        // Create a position vector.
        Vector2D vector = new Vector2D((float) random.nextInt(maxWidth), (float) random.nextInt(maxHeight));
        // Create a basic movement strategy
        MoveStrategy strategy = new BasicMoveStrategy(vector, new float[]{1f, 1f},
                new float[]{0f, 0f}, width, height, maxWidth, maxHeight);
        // Create base character
        Entity e = new Character(width, height, vector, strategy);
        e.setColor(Color.WHITE);
        return e;
    }

    private Entity createRedEntity(int maxWidth, int maxHeight, int width, int height, Random random) {
        // Create a position vector.
        Vector2D vector = new Vector2D((float) random.nextInt(maxWidth), (float) random.nextInt(maxHeight));

        // Create a basic movement strategy
        MoveStrategy strategy = new BasicMoveStrategy(vector, new float[]{1f, 1f},
                new float[]{0f, 0f}, width, height, maxWidth, maxHeight);

        // Create base character
        Entity e = new Character(width, height, vector, strategy);

        // Decorate character
        Entity decorator = new RedEntityDecorator(e);
        return decorator;
    }

    private Entity createYellowEntity(int maxWidth, int maxHeight, int width, int height, Random random) {
        // Create a position vector.
        Vector2D vector = new Vector2D((float) random.nextInt(maxWidth), (float) random.nextInt(maxHeight));

        // Create a basic movement strategy
        MoveStrategy strategy = new BasicMoveStrategy(vector, new float[]{1f, 1f},
                new float[]{0f, 0f}, width, height, maxWidth, maxHeight);

        // Create base character
        Entity e = new Character(width, height, vector, strategy);

        // Decorate character
        Entity decorator = new YellowEntityDecorator(e);
        return decorator;
    }

    private Entity createRedEntityWithWhiteHat(int maxWidth, int maxHeight, int width, int height, Random random) {
        // Create a position vector.
        Vector2D vector = new Vector2D((float) random.nextInt(maxWidth), (float) random.nextInt(maxHeight));

        // Create a basic movement strategy
        MoveStrategy strategy = new BasicMoveStrategy(vector, new float[]{1f, 1f},
                new float[]{0f, 0f}, width, height, maxWidth, maxHeight);

        // Create base character
        Entity e = new Character(width, height, vector, strategy);

        // Decorate character
        Entity decorator = new RedEntityDecorator(e);
        // Decorate decorator
        Entity decorator2 = new WhiteTriangleEntityDecorator(decorator);
        return decorator2;
    }

    private Entity createYellowEntityWithWhiteHat(int maxWidth, int maxHeight, int width, int height, Random random) {
        // Create a position vector.
        Vector2D vector = new Vector2D((float) random.nextInt(maxWidth), (float) random.nextInt(maxHeight));

        // Create a basic movement strategy
        MoveStrategy strategy = new BasicMoveStrategy(vector, new float[]{1f, 1f},
                new float[]{0f, 0f}, width, height, maxWidth, maxHeight);

        // Create base character
        Entity e = new Character(width, height, vector, strategy);

        // Decorate character
        Entity decorator = new YellowEntityDecorator(e);
        // Decorate decorator
        Entity decorator2 = new WhiteTriangleEntityDecorator(decorator);
        return decorator2;
    }


}
