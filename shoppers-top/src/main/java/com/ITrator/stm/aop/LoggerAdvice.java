package com.ITrator.stm.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggerAdvice {

	Logger _logger = LoggerFactory.getLogger(LoggerAdvice.class); 
	
	@Pointcut(value="execution(* com.lti.fsp.*.*.*(..))")
	public void loggingPointCut() {
		
	}
	
	@Pointcut(value="execution(* com.lti.fsp.*.*.*.*(..))")
	public void deepLoggingPointCut() {
		
	}
	
	@Around("loggingPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("In side Advice");
		StopWatch stopWatch = new StopWatch();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().getName();
		Object[] array = pjp.getArgs();
		stopWatch.start();
		_logger.info("Class Name " + className + ", Method Name " + methodName + ", Arugments " + mapper.writeValueAsString(array));
			Object ret = pjp.proceed();
		_logger.info("Class Name " + className + ", Method Name " + methodName + ", Response " + mapper.writeValueAsString(ret) + ", Total Time Execution " + stopWatch.getTotalTimeMillis());
		stopWatch.stop();
		return ret;
	}
}
