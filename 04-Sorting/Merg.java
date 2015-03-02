import java.util.*;
import java.io.*;

public class Merg {
    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	ArrayList<Integer> r= new ArrayList<Integer>();
	while (a.size()+b.size()>0) {
	    if (a.size()==0) {
		r.addAll(b);
		b.clear();
	    } else if (b.size()==0) {
		r.addAll(a);
		a.clear();
	    } else if (a.get(0)>b.get(0)) {
		r.add(b.remove(0));
	    } else {
		r.add(a.remove(0));
	    }
	}
	return r;
    }

    public ArrayList<Integer> mergesort(ArrayList<Integer> sortee) {
	ArrayList<Integer> one=new ArrayList<Integer>();
	ArrayList<Integer> two=new ArrayList<Integer>();
	if (sortee.size()==1) {
	    return sortee;
	} else {
	    int mid=(sortee.size())/2;
	    for (int i=0;i<mid;i++) {
		one.add(sortee.get(i));
	    }
	    for (int j=mid;j<sortee.size();j++) {
		two.add(sortee.get(j));
	    }
	    ArrayList<Integer> r1=mergesort(one);
	    ArrayList<Integer> r2=mergesort(two);
	    return merge(r1,r2);
	}
    }
    
    public static void main(String[] args) {
	Merg m=new Merg();
	Random rand=new Random();
	ArrayList<Integer> a=new ArrayList<Integer>();
	ArrayList<Integer> b=new ArrayList<Integer>();
	ArrayList<Integer> c=new ArrayList<Integer>(
						    Arrays.asList(1,5,2,7,5,2,8,4,3,3,6,2,3,456));
	for (int i=0;i<13;i++) {
	    a.add(i);
	}
	for (int s=9;s<23;s++) {
	    b.add(s);
	}
	System.out.println("Merge: "+m.merge(a,b));
	System.out.println("MergeSort: "+m.mergesort(c));
    }
}
