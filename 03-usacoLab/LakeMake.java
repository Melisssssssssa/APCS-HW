import java.io.*;
import java.util.*;

public class LakeMake {

    private Random random = new Random();
    private int[][] board;
    private int maxX;
    private int maxY;

    public LakeMake() {
	this(4,6);
    }

    public LakeMake(int row, int col) {
	this.maxX=col;
	this.maxY=row;
	board = new int[row][col];
	for (int r=0; r < row; r++) {
	    for (int c=0; c < col; c++) {
		board[r][c] = random.nextInt(30) + 10;
	    }
	}
    }

    public String toString() {
	String s = "";
        for (int r=0; r < maxY; r++) {
	    for (int c=0; c < maxX; c++) {
		s += board[r][c] + " ";
	    }
	    s += "\n";
	}
	return s;
    }

    public void stomp(int y, int x, int num) {
	int max = board[y][x];
	y--;
	x--;
	for (int row = y; row < y+3; row++) {
	    for (int col = x; col < x+3; col++) {
		if (board[row][col] > max) {
		    max = board[row][col];
		}
	    }
	}
	for (int r = y; r < y+3; r++) {
	    for (int c = x; c < x+3; c++) {
	        int s = board[r][c] - max;
		board[r][c] -= num + s;
	    }
	}
    }

    public int findDepth(int k) {
	int depth = 0;
	for (int r = 0; r < maxY; r++) {
	    for (int c = 0; c < maxX; c++) {
		if (k - board[r][c] > 0) {
		    depth += k - board[r][c];
		}
	    }
	}
	return depth;
    }

    public int volume() {
	int i = findDepth(22) * 72 * 72;
	return i;
    }

    public static void main(String[] args) {
	LakeMake k = new LakeMake();
	System.out.println(k);
	k.stomp(1,1,4);
	System.out.println(k);
    }
}
