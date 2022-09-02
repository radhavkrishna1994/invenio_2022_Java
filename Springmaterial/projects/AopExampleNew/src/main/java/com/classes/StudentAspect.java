package com.classes;
  
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



@Aspect
public class StudentAspect { 
	@Before("execution(public * get*())")
	public void getNameAdvice(){
		System.out.println("Executing Before Advice on get**()");//2
	}
	
	/*
	 * @Before("execution(public int getAge())") public void getNameAdvice1(){
	 * System.out.println("Executing Before Advice on getAge()");//2 }
	 */
	/*@Before("execution(* com.classes.*.get*())")
	public void getAllAdvice(){
		System.out.println("Service method getter called");//1
	}*/
	
	@After("execution(public * get*())")
	public void setNameAdvice(){
		System.out.println("Executing After Advice on get***()");//2
	}
	
	/*
	 * @AfterThrowing("execution(public void test())") public void getThrowAdvice()
	 * { System.out.println("Executing advice on throwing exception.."); }
	 * 
	 * @AfterReturning("execution(public * *())") public void getReturnAdvice() {
	 * System.out.println("Executing advice on Returning .."); }
	 * 
	 * @After("execution(public * *())") // Afterfinally public void afterAll() {
	 * System.out.println("After all"); }
	 */
}
