package com.training.clients;

class AA
{
	public void m1() {System.out.println("m1 AA");}
	public void m2() { System.out.println("m2 AA");}
}

class BB extends AA
{
	public void m1() {System.out.println("m1 BB");}
	public void m3() {System.out.println("m3 BB");}
}

public class Test2 {

	public static void main(String[] args) {

		AA ob1=new AA();
		ob1.m1();  // m1 AA

		BB ob2 = new BB();
		ob2.m1();    // m1 BB 

		AA ob3=new BB();
		ob3.m1();   //m1 BB


		((BB)ob3).m3(); //m3 BB
		
		Object o=new AA();
		
		((AA)o).m1();
		
		System.out.println(o.getClass().getName());
		
	}
}

