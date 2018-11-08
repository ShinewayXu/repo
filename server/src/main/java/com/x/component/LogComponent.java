package com.x.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.x.tools.IDWorker;

@Aspect
@Component
public class LogComponent implements ApplicationContextAware {

	private static Logger logger = LoggerFactory.getLogger("LogComp");

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {

	}
	
	@Pointcut("execution(public * com.x.web..*Controller*.*(..))")
	private void controllerMethod() {
	}
	
	@Around("controllerMethod()")
	public Object doControllerMothodInvoke(ProceedingJoinPoint pjp) throws Throwable {
		long t1 = System.currentTimeMillis();
		long threadName = IDWorker.get();
		Thread.currentThread().setName(""+threadName);
		String signature = pjp.getSignature().toString();
		int method_dot_idx = signature.lastIndexOf('.');
        int class_dot_idx = signature.lastIndexOf('.', method_dot_idx - 1);
        String className = signature.substring(class_dot_idx +1, signature.length());
        logger.info("enter：{}", className);
		Object obj = pjp.proceed();
		logger.info("exist：耗时:{}，{}", (System.currentTimeMillis() - t1), className);
		return obj;
	}


}
