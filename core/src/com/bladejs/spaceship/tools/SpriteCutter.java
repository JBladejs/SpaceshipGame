package com.bladejs.spaceship.tools;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteCutter {
    public static TextureRegion[] cutSprite(Texture sprite, int columns, int rows) {
        TextureRegion[] sprites = new TextureRegion[rows * columns];
        float width = sprite.getWidth() / (float) columns;
        float height = sprite.getHeight() / (float) rows;
        int k = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                sprites[k] = new TextureRegion(sprite, ((int) (i * width)), ((int) (j * height)), (int) width, (int) height);
                k++;
            }
        }
        return sprites;
    }
}
