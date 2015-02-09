public class Recursion {

    public int fact(int n){
	if ( n == 0){
	    return 1;
	}else if ( n == 1 ){
	    return 1;
	}else {
	    return n * fact ( n - 1 );
	}
    }

    public int fib( int n ) {
	if ( n == 0 ) {
	    return 1;
	} else if ( n == 1 ) {
	    return 1;
	} else {
	    return fib( n - 1 ) + fib( n - 2 );
	}
    }

public int len(String s){
	if (s.equals("")){
	    return 0;
	}
	else{
	    return 1 + len(s.substring(1));
	}
    }

    public int count(String s, char c){
	if (s.equals("")){
	    return 0;
	}
	else if (s.charAt(0) == c){ 
	    return 1 + count(s.substring(1), c);
	}
	else {
	    return count(s.substring(1), c);
	}
    }

}
