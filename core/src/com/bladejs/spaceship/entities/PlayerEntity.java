package com.bladejs.spaceship.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Iterator;

import static com.badlogic.gdx.Input.Keys.*;
import static com.badlogic.gdx.Input.Keys.S;

public class PlayerEntity extends AnimatedEntity {

    private int frameNum;
    private int wait;

    public PlayerEntity() {
        super("spaceship.png", 2, 2, 20, Gdx.graphics.getHeight() / 2f, 5);
        frameNum = 0;
        wait = 0;
    }

    @Override
    public void update() {
        for (Iterator<Entity> iter = alsoRendered.iterator(); iter.hasNext(); ) {
            Bullet bullet = (Bullet) iter.next();
            bullet.update();
            if (bullet.deleted) iter.remove();
        }
        setFrame(frameNum);
        frameNum++;
        if(frameNum > 3) frameNum = 0;
        float speed = 5;
        if(Gdx.input.isKeyPressed(UP) || Gdx.input.isKeyPressed(W)) move(0, speed);
        if(Gdx.input.isKeyPressed(DOWN) || Gdx.input.isKeyPressed(S)) move(0, -speed);
        if(Gdx.input.isKeyPressed(SPACE)){
            if(wait >= 5) wait = 0;
            if(wait == 0) alsoRendered.add(new Bullet(x + ((frame.getRegionWidth() * scale) / 2), y - frame.getRegionHeight() + 18));
            wait++;
        }
    }
}
