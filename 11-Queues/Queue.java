public class Queue<E> {
    private Node<E> first; 
    private Node<E> last; 

    public Queue() {
	first = new Node<E>();
	last = first;
    }

    public void enqueue(E data) {
	Node<E> n = new Node<E>(data);
	last.setNext(n);
	last = n;
    }

    public E dequeue() {
	Node<E> tmp = first.getNext();
	first.setNext(first.getNext().getNext());
	return tmp.getData();
    }

    public String toString() {
	String s = "";
	Node<E> yay = first;
	while(yay!=last) {
	    s = s + yay.getData() + ", ";
	    yay = yay.getNext();
	}
	s = s + last.getData();
	return s;
    }

    public static void main(String[] args) {
	Queue<Integer> q = new Queue<Integer>();
	for(int i=0; i<10; i++) {
	    q.enqueue(i);
	}
	System.out.println(q);
	for(int i=0;i<3;i++) {
	    q.dequeue();
	}
	System.out.println(q);
	q.enqueue(34);
	System.out.println(q);
	
    }

}
