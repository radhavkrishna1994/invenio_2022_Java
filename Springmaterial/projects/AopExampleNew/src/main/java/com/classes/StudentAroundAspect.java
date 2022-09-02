package com.classes;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class StudentAroundAspect {
	@Around("execution(* com.classes.Student.get*())")
	public Object studentAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("Before invoking get*() method--Around");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed(); // executes getName()
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking getName() method. Return value="+value);
		return value;
	}
}

