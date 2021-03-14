import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** 
 * @author oyuz
 */

public class GUI extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    
    private static final int UP = 1;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int LEFT = 4;
    
    private GamePanel gamePanel;
    private Snake snake;
    
    JLabel label;

    public GUI(Snake snake, GamePanel gamePanel) {
	
        super("Snake");
   
        this.snake = snake;
        
        gamePanel.setBackground(Color.black);
        add(gamePanel);
        addKeyListener(this);
        setSize(600, 600);
        setVisible(true);
        snake.addObserver(gamePanel);
        
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT /*&& snake.getDirection() != RIGHT*/) {
            snake.setDirection(RIGHT);
            snake.move();
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT /*&& snake.getDirection() != LEFT*/) {
            snake.setDirection(LEFT);
            snake.move();
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP /*&& snake.getDirection() != UP*/) {
            snake.setDirection(UP);
            snake.move();
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN /*&& snake.getDirection() != DOWN*/) {
            snake.setDirection(DOWN);
            snake.move();
        }

    }

    public void gameOver() {
	System.out.println("GAME OVER");
	// TODO: Game over GUI sequence
    }
}