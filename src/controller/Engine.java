package controller;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import gui.GamePanel;
import snake.Snake;

/**
 * @author oyuz
 *
 */

class Mover implements Runnable {

    private static final int TICKSPEED = 100;
    
    private Snake snake;
    private boolean stopFlag;
    
    Mover(Snake snake) {
	this.snake = snake;
	stopFlag = false;
    }
    
    @Override
    public void run() {
	snake.move();
	while (!stopFlag) {
	    try {
		Thread.sleep(TICKSPEED);
		run();
	    } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		stopFlag = true;
	    }
	}
    }
}

public class Engine implements Observer {

    private int[][] gameField;
    private static final int SNAKEPART = 1;
    private static final int FOOD = 2;
    private static final int LOWBOUNDARY = 0;
    private static final int VERTICALBOUNDARY = 28;
    private static final int HORIZONTALBOUNDARY = 29;
    private Snake snake;
    private GamePanel gamePanel;
    private Mover mover;
    private Random rng;
    private Thread moveThread;
    
    
    public Engine(Snake snake, GamePanel gamePanel) {
	gameField = new int[HORIZONTALBOUNDARY][VERTICALBOUNDARY];
	this.snake = snake;
	this.gamePanel = gamePanel;
	this.mover = new Mover(snake);
	rng = new Random();
	moveThread = new Thread(mover);
	generateFood();
	start();
    }
    
    /* Initiate the game by starting the snake-moving thread */
    public void start() {
	moveThread.start();
    }
    
    /* Generates a food item on a random square that is not occupied by the snake*/
    public void generateFood() {
	int randomX = rng.nextInt(HORIZONTALBOUNDARY);
	int randomY = rng.nextInt(VERTICALBOUNDARY);
	while (gameField[randomX][randomY] == SNAKEPART) {
	    randomX = rng.nextInt(HORIZONTALBOUNDARY);
	    randomY = rng.nextInt(VERTICALBOUNDARY);
	}
	gameField[randomX][randomY] = FOOD;
	gamePanel.newSnack(randomX, randomY);
    }
    
    /* Update sequence for when snake makes a new move */
    public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	int[] headTail = (int[]) arg1;
	int x = headTail[0];
	int y = headTail[1];
	if (x < LOWBOUNDARY || x >= HORIZONTALBOUNDARY) {
	    moveThread.interrupt();
	    gamePanel.gameOver();
	}
	else if (y < LOWBOUNDARY || y >= VERTICALBOUNDARY) {
	    moveThread.interrupt();
	    gamePanel.gameOver();
	}
	else if (gameField[x][y] == SNAKEPART) {
	    moveThread.interrupt();
	    gamePanel.gameOver();
	}
	else if (gameField[x][y] == FOOD) {
	    gameField[x][y] = SNAKEPART;
	    generateFood();
	    snake.grow();
	    gameField[x][y] = 0; // clear eaten food
	} else {
	    gameField[x][y] = SNAKEPART; // add latest move to game-grid
	}
	int oldTailX = headTail[2];
	int oldTailY = headTail[3];
	gameField[oldTailX][oldTailY] = 0; // delete old tail end
    }

}
