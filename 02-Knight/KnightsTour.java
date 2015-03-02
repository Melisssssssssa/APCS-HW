import java.util.*;
import java.io.*;

public class KnightsTour {
    private int[][] board;
    private int maxX;
    private int maxY;
    private static int turn;
    private boolean solved;
    private static String[] turns;
    public KnightsTour() {
	maxX=9;
	maxY=9;
	solved=false;
	board=new int[maxX][maxY];
	turns=new String[25];
	for (int y=0;y<maxY;y++) {
	    for (int x=0;x<maxX;x++) {
		if (x<2 || y<2 || x>6 || y>6) {
		    board[x][y]=-1;
		} else {
		    board[x][y]=0;
		}
	    }
	}
    }

    public String toString() {
	String s="";
	for (int y=0;y<maxY;y++) {
	    for (int x=0;x<maxX;x++) {
		s=s+String.format("%3d",board[x][y]);
	    }
	    s+="\n";
	}
	return s;
    }

    private void joust(int x, int y) {
	if (board[x][y]!=0 || solved) {
	    return;
	}
	
	turn++;
	board[x][y]=turn;
	
	if (turn==25) {
	    System.out.println(this);
	    solved=true;
	}

	/*try {
	    Thread.sleep(5);
	} catch (Exception e) {}
	System.out.println(this);*/
	
	joust(x+2,y+1);
	joust(x+2,y-1);
	joust(x-2,y+1);
	joust(x-2,y-1);
	joust(x+1,y+2);
	joust(x+1,y-2);
	joust(x-1,y+2);
	joust(x-1,y-2);
	
	if (!solved) {
	   board[x][y]=0;
	   turn--;
	}
    }

    public static void main(String[] args) {
	KnightsTour kt=new KnightsTour();
	System.out.println(kt);
	kt.joust(2,2);
	//System.out.println(kt);
    }
}
