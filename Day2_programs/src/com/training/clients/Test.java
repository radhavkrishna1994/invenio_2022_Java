package com.training.clients;

class A
{
	public void m1() { } // 1
	public void m1(int x) { } //2
	
}

class B extends A
{
	//public int m1() {return 1; } //3
	public void m1(int x) { } //4
	public int m1(double d) { return 2;} //5
}

/*  OL    -- 1 ,2 and 5 
 *   OR --- 2,4 
 *   
 */


public class Test {
	
	private static int x;
	private int y;
	
	public static void main(String[] args) {
		
		System.out.println(x);
		
		Test test1 = new Test();
		System.out.println(test1.y);
		
		System.out.println(test1.x);
	}

}
