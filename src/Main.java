/** 
 * @author oyuz
 */

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Snake snake = new Snake(20, 20, 4);
	GamePanel gamePanel = new GamePanel(snake);
	GUI gui = new GUI(snake, gamePanel);
	Engine engine = new Engine(gui, snake, gamePanel);
	snake.addObserver(engine);
    }

}
