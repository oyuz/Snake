
public class main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Snake snake = new Snake();
	GUI gui = new GUI(snake);
	Engine engine = new Engine(gui);
	snake.addObserver(engine);
    }

}
