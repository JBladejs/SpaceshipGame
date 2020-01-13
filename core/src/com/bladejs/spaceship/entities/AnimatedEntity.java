package com.bladejs.spaceship.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

import static com.bladejs.spaceship.tools.SpriteCutter.cutSprite;

public abstract class AnimatedEntity extends Entity {
    Array<Entity> alsoRendered;
    float scale;

    private TextureRegion[] sprites;

    TextureRegion frame;

    AnimatedEntity(String spritePath, int columns, int rows, float x, float y, float scale) {
        this.sprite = new Texture(spritePath);
        sprites = cutSprite(sprite, columns, rows);
        this.x = x;
        this.y = y;
        this.scale = scale;
        setFrame(0);
        alsoRendered = new Array<>();
    }

    void setFrame(int frame) {
        this.frame = sprites[frame];
    }

    @Override
    public void render(SpriteBatch batch) {
        for (Entity entity : alsoRendered) {
            entity.render(batch);
        }
        batch.draw(frame, x, y, frame.getRegionWidth() * scale, frame.getRegionHeight() * scale);
    }

    @Override
    public void dispose() {
        super.dispose();
        for (Entity entity : alsoRendered) {
            entity.dispose();
        }
    }
}
