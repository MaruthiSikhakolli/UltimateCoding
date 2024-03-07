package java;

public class ReturnClass {
	 int mul; // To store multiplication
	    double div; // To store division
	    int add; // To store addition
	    
	    ReturnClass(int m, double d, int a)
	    {
	        mul = m;
	        div = d;
	        add = a;
	    }
}

class Test {
    public static ReturnClass getMultDivAdd(int a, int b){
        return new ReturnClass(a * b, (double)a / b, (a + b));
    }
  
    public static void main(String[] args)
    {
    	ReturnClass ans = getMultDivAdd(10, 20);
        System.out.println("Multiplication = " + ans.mul);
        System.out.println("Division = " + ans.div);
        System.out.println("Addition = " + ans.add);
    }
}