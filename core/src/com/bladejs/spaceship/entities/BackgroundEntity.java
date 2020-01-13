package com.bladejs.spaceship.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class BackgroundEntity extends Entity {
    private float speed;

    private float width;
    private float height;

    public BackgroundEntity(String spritePath) {
        this.sprite = new Texture(spritePath);
        this.x = 0;
        this.y = 0;
        width = (Gdx.graphics.getHeight() / (float) sprite.getHeight()) * sprite.getWidth();
        height = Gdx.graphics.getHeight();
    }

    public void setMoveSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public void update() {
        move(-speed, 0);
        if(width + x <= 0) x += width;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(sprite, x, y, width, height);
        batch.draw(sprite, width + x, y, width, height);
    }
}
