
package com.practice.springbootbasics.aopimpl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class EmployeeServiceAspect {
	
	
	@Before(value = "execution(* com.practice.springbootbasics.service.EmployeeService.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("This code executed before here...-->" + joinPoint.getSignature());
	}

}
