package org.tang.springboot.logging.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author 唐兴
 * @date   2017年8月31日
 * @desc   web层日志切面类
 */
@Aspect   //讲一个java类定义为切面类
@Component //对象交给spring
public class WebLogAspect {

	private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
	
	//在这里定义基本类型会有同步问题出现，使用threadLocal确保同步
	ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	
	@Pointcut("execution(public * org.tang.springboot.logging.controller.*.*(..))")  //定义一个切入点，也就是规则表达式
	public void webLog() {}
	
	/**
	 * 在切入方法之前执行
	 * @param joinPoint
	 * @throws Throwable
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint)throws Throwable {
		//获取请求链
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		Long sTime = System.currentTimeMillis();
		startTime.set(sTime);
		logger.debug("startTime:>>{}",sTime);
		logger.debug("url:>>{}",request.getRequestURL());
		logger.debug("RequestMethod:>>{}",request.getMethod());
		logger.debug("IP:>>{}",request.getRemoteAddr());
		logger.debug("Class_method:>>{}",joinPoint.getSignature().getDeclaringType()+"."+joinPoint.getSignature().getName());
		logger.debug("Args:>>{}",Arrays.toString(joinPoint.getArgs()));
	}
	
	/**
	 * 在切入方法返回之后执行
	 * @param ret
	 */
	@AfterReturning(returning="ret",pointcut="webLog()")
	public void AfterReturn(Object ret) {
		//处理完请求返回内容
		logger.debug("Response:>>{}",ret);
		logger.debug("consumeTime:>>{}",System.currentTimeMillis()-startTime.get());
	}
	
}
