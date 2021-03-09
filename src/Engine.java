import java.util.Observable;
import java.util.Observer;

import javafx.util.Pair;

/**
 * @author oyuz
 *
 */

public class Engine implements Observer {

    private int[][] gameField;
    private static final int SNAKE = 1;
    private static final int FOOD = 2;
    private static final int LOWBOUNDARY = 0;
    private static final int VERTICALBOUNDARY = 540;
    private static final int HORIZONTALBOUNDARY = 560;
    private GUI gui;
    
    private Pair<Integer, Integer> snakePos;
    
    public Engine(GUI gui) {
	gameField = new int[30][30];
	this.gui = gui;
    }
    
    // CREATE FOOD GENERATOR
    
    // GENERATE SNAKE STARTING POSITION
    
    // CREATE BOUNDS CHECKER
    
    @SuppressWarnings("unchecked")
    @Override
    public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	snakePos = (Pair<Integer, Integer>) arg1;
	int x = snakePos.getKey();
	if (x < LOWBOUNDARY || x > HORIZONTALBOUNDARY) {
	    gui.gameOver();
	}
	int y = snakePos.getValue();
	if (y < LOWBOUNDARY || y > VERTICALBOUNDARY) {
	    gui.gameOver();
	}
	
    }

}
