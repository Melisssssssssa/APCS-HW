import java.util.*;
import java.io.*;
public class quicksort{
    private int[] a,b;
    Random rnd = new Random();
    public Qsort(){
	this(20);
    }
    public quicksort(int n){
	Random r = new Random();
	a = new int[n];
	for (int i = 0; i < a.length; i++) {
	    a[i] = r.nextInt(100);
	}
    }

    public String toString(){
	return Arrays.toString(a);
    }

    public int partition(int[] a, int l, int r) {
	int tmp;
	//int pivotIndex = l+rnd.nextInt(r-l);
	int pivotIndex=l;
	int pivot = a[pivotIndex];
	tmp = a[r];
	a[r] = a[pivotIndex];
	a[pivotIndex]=tmp;
				
	int wall=l;
	int pcount=1;



	for (int i=l;i<r;i++) {
	    if (a[i]<pivot) {
		tmp = a[i];
		a[i]=a[wall];
		a[wall]=tmp;
		wall++;
	    }
	    if (a[i]==pivot)
		pcount++;
	}
	// now copy over all the pivots
	int rwall=wall;
	tmp = a[rwall];
	a[wall]=a[r];
	a[r]=tmp;
	rwall++;
	for (int i=rwall+1;i<=r;i++) {
	    if (a[i]==pivot) {
		tmp = a[rwall];
		a[rwall]=a[i];
		a[i]=tmp;
		rwall++;
	    }
	}
	return (wall+rwall)/2;
    }
		
    public int sort(int k){
	b = Arrays.copyOf(a,a.length);
	return qsort(b,0,b.length-1);
    }

    public void qsort(int[] a, int l, int h){
	int pi;
	int pval;
	pi = partition(a,l,h);
	pval = a[pi];
	if (pi-1>1)
	    qsort(a, l, pi-1);
	if (h-pi>1)
	    qsort(a, pi+1, h);
    }
		
    public static void main(String[] args) {
	quicksort q = new quicksort();
	System.out.println(q);
	for (int i=0;i<5;i++) {
	    System.out.print(q.sort(i)+" ");
	}
	System.out.println();
	Arrays.sort(q.a);
				
	System.out.println(q);

    }
}
