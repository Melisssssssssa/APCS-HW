public class LLists {
    private Node l=null;

    public void add(String s){
	Node tmp = new Node(s);
	tmp.setNext(l);
	l = tmp;
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

        public int find(String s){
	Node temp = l;
	int i = 0;
	while (temp != null){
	    if (temp.getData().equals(s)){
		return i;
	    }
	    temp = temp.getNext();
	    i++;
	}
	return -1;
    }


    public void add(int i, String s){
	if (i==0){
	    add(s);
	}
	else {
	    Node temp = l;
	    for (int x = 0; x < i - 1; x++){
		temp = temp.getNext();
	    }
	    Node n = new Node(s);
	    n.setNext(temp.getNext());
	    temp.setNext(n);
	}
    }


    public static void main(String[] args) {
	LLists ret = new LLists();
	ll.add("Fri");
	ll.add("Wed");
	System.out.println(ret.find(0));
    }

    
		
}
