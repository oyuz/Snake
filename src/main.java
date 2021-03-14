
public class main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Snake snake = new Snake(20, 20, 4);
	GUI gui = new GUI(snake);
	Engine engine = new Engine(gui, snake);
	snake.addObserver(engine);
    }

}
