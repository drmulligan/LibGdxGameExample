package net.mulligan.game;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Racquet {
	private static final int Y = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
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
		System.out.println("...");
	}

	public void render() {
		this.move();
		game.getShapeRenderer().setColor(Color.BLACK);
		game.getShapeRenderer().begin(ShapeType.Filled);
		game.getShapeRenderer().rect(x, Y, WIDTH, HEIGHT);
		game.getShapeRenderer().end();
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -game.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = game.speed;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIDTH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
}