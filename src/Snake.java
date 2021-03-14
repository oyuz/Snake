import java.util.ArrayList;
import java.util.Observable;
import javafx.util.Pair;

/** 
 * @author oyuz
 */

public class Snake extends Observable {

    private static final int UP = 1;
    private static final int RIGHT = 2;
    private static final int DOWN = 3;
    private static final int LEFT = 4;
    private static final int UNITSIZE = 20;
    
    private int direction;
    private Pair<Integer, Integer> head;
    private Pair<Integer, Integer> tail;
    private ArrayList<Pair<Integer, Integer>> body;
    
    
    public Snake(int startX, int startY, int direction) {
	head = new Pair<>(startX, startY);
	tail = new Pair<>(startX, startY);
	this.direction = direction;
	body = new ArrayList<Pair<Integer, Integer>>();
	body.add(head);
    }
    
    
    public int getDirection() {
	return direction;
    }
    
    public void setDirection(int direction) {
	this.direction = direction;
    }
    
    public void move() {
	
	// Add new head
	Pair<Integer, Integer> newHead = new Pair<>(0, 0);
	switch (direction) {
	case UP:
	    newHead = new Pair<>(head.getKey(), head.getValue() - UNITSIZE);
	    break;
	case DOWN:
	    newHead = new Pair<>(head.getKey(), head.getValue() + UNITSIZE);
	    break;
	case RIGHT:
	    newHead = new Pair<>(head.getKey() + UNITSIZE, head.getValue());
	    break;
	case LEFT:
	    newHead = new Pair<>(head.getKey() - UNITSIZE, head.getValue());
	    break;
	}
	body.add(newHead);
	head = newHead;
	
	// Delete the tail
	body.remove(0);
	
	// Update listeners
	setChanged();
	notifyObservers(head);
    }
    
    /* When player has eaten new snaccc */
    public void grow() {
	
    }
    
    public Pair<Integer, Integer> getHead() {
	return head;
    }
    
    public Pair<Integer, Integer> getTail() {
	return tail;
    }
    
    public ArrayList<Pair<Integer, Integer>> getBody() {
	return body;
    }
}
