package com.training.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;



@Configuration
@Aspect
public class MyAspect {

	private Logger log = LoggerFactory.getLogger("MyAspect.class");
	
	@Before(value = "execution(* com.training.services.MyService.get*(..))") //PointCut Expn
	public void logBeforeAspect(JoinPoint joinPoint)
	{
		log.info("This is Before method..");
		String className=joinPoint.getTarget().getClass().toString();
		log.info("classname:"+className);
		log.info(""+joinPoint.getSignature());
	}

	@After(value = "execution(* com.training.services.MyService.setName(String))") //PointCut Expn
	public void logAfterAspect(JoinPoint joinPoint)
	{
		log.info("This is After method..");
		String className=joinPoint.getTarget().getClass().toString();
		log.info("classname:"+className);
		log.info(""+joinPoint.getSignature());
	}

	@Around(value = "execution(* com.training.services.MyService.get*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint)
	{
		log.info("This is around advice..");
		Object value=null;
			 try {
				value= joinPoint.proceed();
				
				System.out.println("inside the method"+value);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return value;
		
	}
}
