import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javafx.util.Pair;

/**
 * @author oyuz
 *
 */

class Mover implements Runnable {

    private static final int TICKSPEED = 150;
    
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
    private static final int VERTICALBOUNDARY = 540;
    private static final int HORIZONTALBOUNDARY = 560;
    private GUI gui;
    private Snake snake;
    private GamePanel gamePanel;
    private Mover mover;
    private Random rng;
    private Thread moveThread;
    private boolean gameFlag;
    
    private Pair<Integer, Integer> snakeHead;
    
    public Engine(GUI gui, Snake snake, GamePanel gamePanel) {
	gameField = new int[30][30];
	this.gui = gui;
	this.snake = snake;
	this.gamePanel = gamePanel;
	this.mover = new Mover(snake);
	moveThread = new Thread(mover);
	gameFlag = true;
	start();
    }
    
    // CREATE FOOD GENERATOR
    
    // GENERATE SNAKE STARTING POSITION
    
    // MAKE SNAKE MOVE AT TIMED INTERVALLS
    public void start() {
	moveThread.start();
    }
    
    public void generateFood() {
	// Randomize a square that is not occupied by snake
	int randomX = rng.nextInt(30);
	int randomY = rng.nextInt(30);
	while (gameField[randomX][randomY] != SNAKEPART) {
	    randomX = rng.nextInt(30);
	    randomY = rng.nextInt(30);
	}
	gamePanel.newSnack(randomX, randomY);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	snakeHead = (Pair<Integer, Integer>) arg1;
	int x = snakeHead.getKey();
	int y = snakeHead.getValue();
	if (x < LOWBOUNDARY || x > HORIZONTALBOUNDARY) {
	    gameFlag = false;
	    gui.gameOver();
	    moveThread.interrupt();
	}
	else if (y < LOWBOUNDARY || y > VERTICALBOUNDARY) {
	    gameFlag = false;
	    gui.gameOver();
	    moveThread.interrupt();
	}
//	else if (gameField[x][y] == SNAKEPART) {
//	    gameFlag = false;
//	    gui.gameOver();
//	}
//	else if (gameField[x][y] == FOOD) {
//	    
//	}
	
    }

}
