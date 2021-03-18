package gui;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

import snake.Snake;

/** 
 * @author oyuz
 */

public class GUI extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    
    private static final int UP = 1;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int LEFT = 4;
    
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
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
	int dir = snake.getDirection();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && dir != RIGHT && dir != LEFT) {
            snake.setDirection(RIGHT);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT && dir != LEFT && dir != RIGHT) {
            snake.setDirection(LEFT);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP && dir != UP && dir != DOWN) {
            snake.setDirection(UP);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN && dir != DOWN && dir != UP) {
            snake.setDirection(DOWN);
        }

    }
}
