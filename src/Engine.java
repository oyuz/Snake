import java.util.Observable;
import java.util.Observer;

/**
 * @author oyuz
 *
 */

public class Engine implements Observer {

    private int[][] gameField;
    private static final int SNAKE = 1;
    private static final int FOOD = 2;
    
    
    public Engine() {
	gameField = new int[30][30];
    }
    
    // CREATE FOOD GENERATOR
    
    // GENERATE SNAKE STARTING POSITION
    
    // CREATE BOUNDS CHECKER
    
    @Override
    public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	
    }

}
