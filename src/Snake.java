import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.util.Pair;

public class Snake implements Observable {

    private static final int UP = 1;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int LEFT = 4;
    
    private int direction;
    private Pair<Integer, Integer> pos;
    private ArrayList<Pair<Integer, Integer>> body;
    
    
    public Snake() {
	pos = new Pair<>(20, 20);
    }
    
    
    public int getDirection() {
	return direction;
    }
    
    public void changeDirection(int direction) {
	Pair<Integer, Integer> newPos;
	switch (direction) {
		case UP:
		     newPos = new Pair<>(pos.getKey(), pos.getValue() - 1);
		     body.add(newPos);
		    break;
		case DOWN:
		    newPos = new Pair<>(pos.getKey(), pos.getValue() + 1);
		    body.add(newPos);
		    break;
		case RIGHT:
		    newPos = new Pair<>(pos.getKey() + 1, pos.getValue());
		    body.add(newPos);
		    break;
		case LEFT:
		    newPos = new Pair<>(pos.getKey() - 1, pos.getValue());
		    body.add(newPos);
		    break;
	}
	this.direction = direction;
    }
    
    public Pair<Integer, Integer> getPos() {
	return pos;
    }
    
    public ArrayList<Pair<Integer, Integer>> getBody() {
	return body;
    }


    @Override
    public void addListener(InvalidationListener arg0) {
	// TODO Auto-generated method stub
	
    }


    @Override
    public void removeListener(InvalidationListener arg0) {
	// TODO Auto-generated method stub
	
    }
}
