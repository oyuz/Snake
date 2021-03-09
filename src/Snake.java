import java.util.ArrayList;
import java.util.Observable;

import javafx.util.Pair;

public class Snake extends Observable {

    private static final int UP = 1;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int LEFT = 4;
    private static final int UNITSIZE = 20;
    
    private int direction;
    private Pair<Integer, Integer> pos;
    private ArrayList<Pair<Integer, Integer>> body;
    
    
    public Snake() {
	pos = new Pair<>(20, 20);
	direction = DOWN;
	body = new ArrayList<Pair<Integer, Integer>>();
	body.add(pos);
    }
    
    
    public int getDirection() {
	return direction;
    }
    
    public void changeDirection(int direction) {
	Pair<Integer, Integer> newPos;
	switch (direction) {
		case UP:
		     newPos = new Pair<>(pos.getKey(), pos.getValue() - UNITSIZE);
		     body.add(newPos);
		     pos = newPos;
		    break;
		case DOWN:
		    newPos = new Pair<>(pos.getKey(), pos.getValue() + UNITSIZE);
		    body.add(newPos);
		    pos = newPos;
		    break;
		case RIGHT:
		    newPos = new Pair<>(pos.getKey() + UNITSIZE, pos.getValue());
		    body.add(newPos);
		    pos = newPos;
		    break;
		case LEFT:
		    newPos = new Pair<>(pos.getKey() - UNITSIZE, pos.getValue());
		    body.add(newPos);
		    pos = newPos;
		    break;
	}
	this.direction = direction;
	setChanged();
	notifyObservers();
    }
    
    public Pair<Integer, Integer> getPos() {
	return pos;
    }
    
    public ArrayList<Pair<Integer, Integer>> getBody() {
	return body;
    }
}
