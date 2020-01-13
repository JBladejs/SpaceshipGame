package com.bladejs.spaceship;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bladejs.spaceship.entities.BackgroundEntity;
import com.bladejs.spaceship.entities.PlayerEntity;

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private BackgroundEntity background;
	private BackgroundEntity foreground;
	private PlayerEntity spaceship;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 720);
		background = new BackgroundEntity("space_background.png");
		foreground = new BackgroundEntity("space_foreground.png");
		background.setMoveSpeed(1);
		foreground.setMoveSpeed(10);
		spaceship = new PlayerEntity();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		background.render(batch);
		foreground.render(batch);
		spaceship.render(batch);
		batch.end();

		background.update();
		foreground.update();
		spaceship.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
		foreground.dispose();
		spaceship.dispose();
	}
}
