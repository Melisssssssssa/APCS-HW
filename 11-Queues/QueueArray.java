import java.util.*;
import java.io.*;

public class QueueArray {
    private int[] array;
    private int last; //Index of last added item

    public QueueArray() {
	array = new int[100];
	last = -1;
    }

    public void newArray(int type) {
	int[] tmp;
	if(type == 0) {
	    tmp = new int[array.length + 100];
	    for(int i=0;i<array.length;i++) {
		tmp[i] = array[i];
	    }
	} else {
	    tmp = Arrays.copyOfRange(array, 0, array.length);
	}
	array = tmp;
    }
    
    public void enqueue(int data) {
	try {
	    array[last+1] = data;
	    last++;
	}
	catch (Exception e) {
	    newArray(0);
	    enqueue(data);
	}
    }

    public int dequeue() {
        int answer = array[0];
	newArray(1);
	return answer;
    }
}
