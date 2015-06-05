import java.lang.IndexOutOfBoundsException;

public class Queue<E> {

    private Node<E> start; //Dummy Node
    private Node<E> end;

    public Queue() {
	start = null;
	end = null;
    }

    public String toString() {
	String s = "HEAD <-- ";
	Node<E> temp = start;
	while (temp != null) {
	    s += temp.getData() + " <-- ";
	    temp = temp.getNext();
	}
	return s + "TAIL";
    }

    public void enqueue(E data, int x, int y, Node<E> prev) {
	if (start == null) {
	    start = new Node<E>(data, x, y);
	    end = start;
	} else {
	    Node<E> temp = new Node<E>(data, x, y);
	    temp.setPrev(prev);
	    end.setNext(temp);
	    end = temp;
	}
    }

    public Node<E> dequeue() {
	Node<E> temp = start;
	start = start.getNext();
	return temp;
    }

    public boolean empty() {
	return start == null;
    }

    public Node<E> head() {
	return start;
    }
}
