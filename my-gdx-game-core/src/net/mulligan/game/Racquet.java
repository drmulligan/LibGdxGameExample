package net.mulligan.game;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Racquet {
	private static final int Y = 30;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 30;
	int x = 0;
	int xa = 0;
	private MyGdxGame game;

	public Racquet(MyGdxGame game) {
		this.game = game;
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getGameWidth() - WIDTH) {
			x = x + xa;
		}
	}

	public void render() {
		this.move();
		game.getShapeRenderer().setColor(Color.BLACK);
		game.getShapeRenderer().begin(ShapeType.Filled);
		game.getShapeRenderer().rect(x, Y, WIDTH, HEIGHT);
		game.getShapeRenderer().end();
	}

	public void keyUp() {
		xa = 0;
	}

	public void keyDown(boolean isLeft) {
		if (isLeft) {
			xa = -(int)( 400 * Gdx.graphics.getDeltaTime() );  
		} else {
			xa = (int)( 400 * Gdx.graphics.getDeltaTime() );
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return Y + HEIGHT;
	}
}