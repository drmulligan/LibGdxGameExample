package net.mulligan.game;

import java.awt.Rectangle;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Ball {
	private static final int DIAMETER = 30;
	
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private MyGdxGame game;

	public Ball(MyGdxGame game) {
		this.game = game;
	}

	void move() {
		boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		else if (x + xa > game.getGameWidth() - DIAMETER)
			xa = -game.speed;
		else if (y + ya < 0)
			ya = game.speed;
		else if (y + ya > game.getGameHeight() - DIAMETER)
			game.gameOver();
		else if (collision()){
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			game.speed++;
		} else 
			changeDirection = false;
		
		if (changeDirection) { 
//			Sound.BALL.play();
		}
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void render() {
		this.move();
		game.getShapeRenderer().setColor(Color.BLACK);
		game.getShapeRenderer().begin(ShapeType.Filled);
//		game.getShapeRenderer().circle(DIAMETER, game.getCamera().viewportHeight - 32, 32);
		game.getShapeRenderer().circle(DIAMETER+x, y - DIAMETER, DIAMETER);
		game.getShapeRenderer().end();
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}