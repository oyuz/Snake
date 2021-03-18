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
    private boolean extend; // boolean used for snake growth
    private boolean lockMove;
    private int[] headTail;
    
    public Snake(int startX, int startY, int direction) {
	head = new Pair<>(startX, startY);
	tail = new Pair<>(startX, startY);
	this.direction = direction;
	body = new ArrayList<Pair<Integer, Integer>>();
	body.add(head);
	extend = false;
	headTail = new int[4];
    }
    
    
    public int getDirection() {
	return direction;
    }
    
    public void setDirection(int direction) {
	if (lockMove == false) {
	    this.direction = direction;
	    lockMove = true;
	}
	
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
	
	// Send head and old tail to engine
	headTail[0] = head.getKey()/20;
	headTail[1] = head.getValue()/20;
	headTail[2] = tail.getKey()/20; 
	headTail[3] = tail.getValue()/20;
	
	if (extend == false) {
	    // delete the old tail and update (common case)
	    body.remove(0);
	    tail = body.get(0);
	} else {
	    // keep the old tail, reset boolean (when food has been eaten)
	    extend = false;
	}
	
	lockMove = false;
	
	// Update listeners
	setChanged();
	notifyObservers(headTail);
    }
    
    /* When player has eaten new snack */
    public void grow() {
	extend = true;
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
