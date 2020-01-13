package com.bladejs.spaceship.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bladejs.spaceship.Game;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Spaceship";
		config.width = 1280;
		config.height = 720;
		new LwjglApplication(new Game(), config);
	}
}
