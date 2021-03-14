import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javafx.util.Pair;

/** 
 * @author oyuz
 */

public class GamePanel extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
    
    private static final int UNITSIZE = 16;
    private static final int PADDING = 4;
    
    private Snake snake;
    private Pair<Integer, Integer> snack;
    
    public GamePanel(Snake snake) {
	this.snake = snake;
	snack = new Pair<>(200, 200);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.setColor(Color.GREEN);
       ArrayList<Pair<Integer, Integer>> body = snake.getBody();
       for (Pair<Integer, Integer> bodyPart : body) {
	   g.fillRect(bodyPart.getKey() + PADDING,  bodyPart.getValue() + PADDING, UNITSIZE, UNITSIZE);
       }
       g.setColor(Color.RED);
       g.fillRect(snack.getKey() + PADDING, snack.getValue() + PADDING, UNITSIZE, UNITSIZE);
    }
    
    
    /* Adds a new snack to the board */
    public void newSnack(int x, int y) {
	Pair<Integer, Integer> newSnack = new Pair<>(x, y);
	snack = newSnack;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	repaint();
    }
    
}
