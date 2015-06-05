import java.util.*;
import java.io.*;

public class LLit<E> implements Iterator<E>{
    private Node<E> l;
    private Node<E> last;
    
    public LLit(Node<E> n){
	l = n;
    }
    public boolean hasNext(){
	return l!=null;
    }
    public E next(){
	//move to the next node and return the value in the node before the move
	E s = l.getData(); last = l;
	l = l.getNext();
	return s;
    }
    public void remove(){
	last.setNext(l.getNext());
	l = l.getNext();
    }
}
