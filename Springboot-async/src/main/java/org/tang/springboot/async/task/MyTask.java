package org.tang.springboot.async.task;

import java.util.Random;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   自定义任务
 */
@Component
public class MyTask {

	public static Random random  = new Random();  //创建随机对象
	
	private static final Logger logger = LoggerFactory.getLogger(MyTask.class);
	
	/**
	 * 任务1
	 * @throws Exception
	 */
	@Async
	public Future<String> doTaskOne()throws Exception{
		logger.info("开始执行任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		logger.info("任务一执行成功，耗时:{}s",(end-start)/1000);
		return new AsyncResult<String>("任务一完成");
	}
	/**
	 * 任务2
	 * @throws Exception
	 */
	@Async
	public Future<String> doTaskTwo()throws Exception{
		logger.info("开始执行任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		logger.info("任务二执行成功，耗时:{}s",(end-start)/1000);
		return new AsyncResult<String>("任务二完成");
	}
	/**
	 * 任务3
	 * @throws Exception
	 */
	@Async
	public Future<String> doTaskThree()throws Exception{
		logger.info("开始执行任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		logger.info("任务三执行成功，耗时:{}s",(end-start)/1000);
		return new AsyncResult<String>("任务三完成");
	}
	
}
