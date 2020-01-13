package com.bladejs.spaceship.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public abstract class Entity {
    float x;
    float y;

    Texture sprite;

    public void setCoordinates(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    abstract public void render(SpriteBatch batch);
    abstract public void update();

    public Texture getSprite() {
        return sprite;
    }

    public void dispose() {
        sprite.dispose();
    }
}
