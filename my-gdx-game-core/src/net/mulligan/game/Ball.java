package net.mulligan.game;

import java.awt.Rectangle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Ball {
	private static final int DIAMETER = 30;

	int x = DIAMETER;
	int y = 450 - DIAMETER;
	int xa = 1;
	int ya = 1;
	private MyGdxGame game;

	public Ball(MyGdxGame game) {
		this.game = game;
	}

	void move() {
		boolean changeDirection = true;
//		System.out.println("y="+y +"ya="+ya);
		if (x + xa < DIAMETER) {
			xa = game.speed;
		} else if (x + xa > game.getGameWidth() - DIAMETER) {
			xa = -game.speed;
		} else if (y + ya > game.getGameHeight() - DIAMETER) {
			ya = game.speed;
		} else if (y + ya < DIAMETER) {
			game.gameOver();
		} else if (collision()) {
			ya = -game.speed;
			y = game.racquet.getTopY() + DIAMETER;
			System.out.println("y="+y +"ya="+ya);
			game.speed++;
		} else {
			changeDirection = false;
		}
		if (changeDirection) {
			// Sound.BALL.play();
		}
		x = x + xa;
		y = y - ya;
	}

	private boolean collision() {
		boolean intersects = game.racquet.getBounds().intersects(getBounds());
//		System.out.println("RAQ [" + game.racquet.getBounds() + "] BALL [" + getBounds() + "] Intersects=" + intersects);
		return intersects;
	}

	public void render() {
		this.move();
		game.getShapeRenderer().setColor(Color.BLACK);
		game.getShapeRenderer().begin(ShapeType.Filled);
		game.getShapeRenderer().circle(x, y, DIAMETER);
		game.getShapeRenderer().end();
	}

	public Rectangle getBounds() {
		return new Rectangle(x-DIAMETER, y-DIAMETER, DIAMETER*2, DIAMETER*2);
	}
}