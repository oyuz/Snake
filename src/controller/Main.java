package controller;
import gui.GUI;
import gui.GamePanel;
import snake.Snake;

/** 
 * @author oyuz
 */

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Snake snake = new Snake(20, 20, 2);
	GamePanel gamePanel = new GamePanel(snake);
	GUI gui = new GUI(snake, gamePanel);
	Engine engine = new Engine(snake, gamePanel);
	snake.addObserver(engine);
    }

}
