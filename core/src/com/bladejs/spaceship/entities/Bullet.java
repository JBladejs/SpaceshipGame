package com.bladejs.spaceship.entities;

import com.badlogic.gdx.Gdx;

public class Bullet extends AnimatedEntity {

    boolean deleted;
    int frameNum;

    Bullet(float x, float y) {
        super("bullet.png", 3, 2, x, y, 5);
        deleted = false;
        frameNum = 0;
    }

    @Override
    public void update() {
        setFrame(frameNum);
        if(x + (frame.getRegionWidth() * scale) >= Gdx.graphics.getWidth()) {
            x = Gdx.graphics.getWidth() - (frame.getRegionWidth() * scale);
            frameNum++;
            if(frameNum >= 6) deleted = true;
        } else move(30, 0);
    }
}
