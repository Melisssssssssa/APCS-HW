import java.io.*;
import java.util.*;

public class Maze 
{
    private char[][] board;
    private int maxX;
    private int maxY;
    private char wall=' ';
    private char exit='$';
    private char path='#';
    private char me='i';
    private char visited='.';
    private boolean solved=false;

    public Maze() 
    {
    maxX=40;
    maxY=20;
    board = new char[maxX][maxY];
    
    try {
      
      Scanner sc = new Scanner(new File("maze.dat"));
      int j=0;
      while (sc.hasNext())
        {
          String line = sc.nextLine();
          for (int i=0;i<maxX;i++)
            {
              board[i][j] = line.charAt(i);
            }
          j++;
        }
    }
    catch (Exception e)
      {
      }
    
    }

    public String toString()
    {
	String s = "[2J\n";
	for (int y=0;y<maxY;y++)
	    {
		for (int x=0;x<maxX;x++)
		    s = s +board[x][y];
		s=s+"\n";
	    }
	//s=s+"\n";
	return s;
    }


    public void solve(int x, int y) {

	try {
	    Thread.sleep(25);
	} catch (Exception e) {
	}
	if (board[x][y]==wall || board[x][y]==me || board[x][y]==visited || solved)
	    return;
	if (board[x][y]==exit) {
	    System.out.println(this); 
	    solved=true;
	}
	System.out.println(this);
	board[x][y]=me;
	solve(x+1,y);
	solve(x-1,y);
	solve(x,y-1);
	solve(x,y+1);
	if (!solved) {
	    board[x][y]=visited;
	}
    }
    public static void main(String[] args){
	Maze m = new Maze();
	System.out.println(m);
	System.out.println(m);
	m.solve(1,1);
    }
    
}
