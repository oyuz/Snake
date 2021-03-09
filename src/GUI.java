import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame implements KeyListener {

    private static final long serialVersionUID = 1L;
    
    private static final int UP = 1;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int LEFT = 4;
    
    private GamePanel gamePanel;
    
    JLabel label;

    public GUI() {
        super("Snake");
        gamePanel = new GamePanel();
        gamePanel.setBackground(Color.black);
        add(gamePanel);
        addKeyListener(this);
        setSize(600, 600);
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Right key pressed");
            gamePanel.move(RIGHT);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Left key pressed");
            gamePanel.move(LEFT);
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Up key pressed");
            gamePanel.move(UP);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Down key pressed");
            gamePanel.move(DOWN);
        }

    }

    public static void main(String[] args) {
        new GUI();
    }
}