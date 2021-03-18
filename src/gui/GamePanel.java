package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javafx.util.Pair;
import snake.Snake;

/** 
 * @author oyuz
 */

public class GamePanel extends JPanel implements Observer {

    private static final long serialVersionUID = 1L;
    
    private static final int UNITSIZE = 16;
    private static final int PADDING = 4;
    private static final int XSCORE = 510;
    private static final int YSCORE = 15;
    
    private Snake snake;
    private Pair<Integer, Integer> snack;
    private int score;
    private boolean stopFlag;
    
    public GamePanel(Snake snake) {
	this.snake = snake;
	score = 0;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.WHITE);
	g.drawString("SCORE: " + score, XSCORE, YSCORE);
	ArrayList<Pair<Integer, Integer>> body = snake.getBody();
	for (Pair<Integer, Integer> bodyPart : body) {
	    g.fillRect(bodyPart.getKey() + PADDING,  bodyPart.getValue() + PADDING, UNITSIZE, UNITSIZE);
	}
	g.fillRect(snack.getKey() + PADDING, snack.getValue() + PADDING, UNITSIZE, UNITSIZE);
	
	if (stopFlag) {
	    g.fillRect(0, 230, 600, 60);
	    g.setColor(Color.BLACK);
	    g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
	    g.drawString("GAME OVER", 210, 265);
	}

    }

    
    /* Adds a new snack to the board */
    public void newSnack(int x, int y) {
	Pair<Integer, Integer> newSnack = new Pair<>(x*20, y*20);
	snack = newSnack;
	score++;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
	// TODO Auto-generated method stub
	repaint();
    }
    
    public void gameOver() {
	stopFlag = true;
    }
}
