package com.classes;

public class Student {

	private String name = "sam";
	private int age = 23;

	public String getName() {
		System.out.println("Name:"+name);
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		System.out.println("Age:"+age);
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * public void test() { //{try{ throw new
	 * NullPointerException("Exception thrown..."); }catch(NullPointerException e) {
	 * System.out.println("Exception handled.."); } }
	 */

	/*
	 * public int test1(int x, int y) { try { int z = x / y; } catch (Exception e) {
	 * System.out.println("divide by zero.."); } finally {
	 * System.out.println("End of module..."); return 1; } // return 1; }
	 */

}
