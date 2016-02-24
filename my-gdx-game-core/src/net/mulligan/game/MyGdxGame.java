package net.mulligan.game;

import javax.swing.JOptionPane;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private ShapeRenderer shapeRenderer;
	private OrthographicCamera camera;
	private float gameHeight;
	private float gameWidth;

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	int speed = 1;

	
	@Override
	public void create() {
		shapeRenderer = new ShapeRenderer();
//		batch = new SpriteBatch();
//		camera = new OrthographicCamera(gameWidth, gameHeight);
        gameWidth = Gdx.graphics.getWidth();
        gameHeight = Gdx.graphics.getHeight();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
//		batch.setProjectionMatrix(camera.combined);
		
//		batch.begin();
//		batch.end();
		
		ball.render();
		racquet.render();

	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public ShapeRenderer getShapeRenderer() {
		return shapeRenderer;
	}

	public OrthographicCamera getCamera() {
		return camera;
	}

	public float getGameHeight() {
		return gameHeight;
	}

	public float getGameWidth() {
		return gameWidth;
	}

	public void gameOver() {
/*		Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
*/
	}

	private void move() {
		ball.move();
		racquet.move();
	}

	private int getScore() {
		return speed - 1;
	}
}
