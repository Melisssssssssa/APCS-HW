import java.io.*;
import java.util.*;
//pop returns top item in stack and removes it
//push adds item to top of stack
//empty returns true or false
//peek returns but doesn't remove top

public class LLit<E> implements Iterator<E>{
    private Node<E> t;
    public LLit(Node<E> n){
	t=n;
    }

    public boolean hasNext(){
	return t!=null;
    }

    public E next(){
	E retval = t.getData();
	t=t.getNext();
	return retval;
    }

    public void remove() {
	if t.hasNext(){
		t.setNext(t.getNext().getNext());
	    }
    }
}
