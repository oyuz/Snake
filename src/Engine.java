import java.util.Observable;
import java.util.Observer;

import javafx.util.Pair;

/**
 * @author oyuz
 *
 */

public class Engine implements Observer {

    private int[][] gameField;
    private static final int SNAKEPART = 1;
    private static final int FOOD = 2;
    private static final int LOWBOUNDARY = 0;
    private static final int VERTICALBOUNDARY = 540;
    private static final int HORIZONTALBOUNDARY = 560;
    private GUI gui;
    private Snake snake;
    private boolean gameFlag;
    
    private Pair<Integer, Integer> snakeHead;
    
    public Engine(GUI gui, Snake snake) {
	gameField = new int[30][30];
	this.gui = gui;
	this.snake = snake;
	gameFlag = true;
    }
    
    // CREATE FOOD GENERATOR
    
    // GENERATE SNAKE STARTING POSITION
    
    // MAKE SNAKE MOVE AT TIMED INTERVALLS
    public void run() {
	while (gameFlag) {
	    // check if player has made a move recently (predefined value), if not, move snake.
	}
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
	}
	else if (y < LOWBOUNDARY || y > VERTICALBOUNDARY) {
	    gameFlag = false;
	    gui.gameOver();
	}
	else if (gameField[x][y] == SNAKEPART) {
	    gameFlag = false;
	    gui.gameOver();
	}
	else if (gameField[x][y] == FOOD) {
	    
	}
	
    }

}
