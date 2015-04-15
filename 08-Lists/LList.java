public class LList {
    private Node l=null;
    private Node dummy = new Node ("");
    private int length=0;

    public void add(int n){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
	length++;
    }

    public String toString(){
	String s = "";
	Node tmp;
	for (tmp = l; tmp != null; tmp=tmp.getNext()){
	    s = s + tmp + " --> ";
	}
	s = s + "null";
	return s;
    }

     public String get(int i){
	Node temp = dummy;
	for (int c = 0; c<i; c++){
	    temp = temp.getNext();
	}
	return temp.getData();
    }

    public void add(int i, int b){
	if (i==0){
	    add(b);
	}
	else {
	    Node temp = l;
	    for (int x = 0; x < i - 1; x++){
		temp = temp.getNext();
	    }
	    Node n = new Node(b);
	    n.setNext(temp.getNext());
	    temp.setNext(n);
	    length++;
	}
    }

    public String remove(int i){
        boolean ret =false;
	Node temp = dummy;
	for (int x = 0; x < i; x++ ){
	    temp = temp.getNext();
	    ret = true;
	}
	Node tmp = temp.getNext();
	temp.setNext(tmp.getNext());
	length--;
	return temp.getData();
	return ret;
    }



    public static void main(String[] args) {
	LListDummy A = new LListDummy();
        LinkedList<Integer> B = new LinkedList<Integer>();
	ArrayList<Integer> nums C = new ArrayList<Integer>();
	Random r = new Random();
	for (int i = 0; i < 100; i++) {
	    int x = r.nextInt();
	    A.add(x);
	    l.add(x);
	    C.add(x);
	}

	start = System.currentTimeMillis();
	int Aa = A.sum();
	System.out.println("My LinkedList: " + Aa);
	System.out. println((System.currentTimeMillis() - start));
	int Bb = 0;
        start = System.currentTimeMillis();
	for (int i = 0; i < l.size(); i++) {
	    Bb += l.get(i);
	}


	System.out.println("Comp LinkedList: " + Bb);
	System.out.println((System.currentTimeMillis() - start));
	int ret = 0;

        start = System.currentTimeMillis();
        for (int i = 0; i < C.size(); i++) {
	   ret += C.get(i);
	}
	System.out.println("ArrayList: " + ret);
	System.out. println((System.currentTimeMillis() - start));
    }

  
    
		
}
