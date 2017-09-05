package org.tang.springboot.async.test;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.tang.springboot.async.task.MyTask;

/**
 * @author 唐兴
 * @date   2017年9月5日
 * @desc   测试异步调用
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAsync {
	
	private Logger logger  = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MyTask myTask;
	
	@Test
	public void testMyTask() throws Exception {
		long start = System.currentTimeMillis();
		Future<String> One = myTask.doTaskOne();
		Future<String> Two = myTask.doTaskTwo();
		Future<String> Three = myTask.doTaskThree();
		while(true) {
			if(One.isDone()&&Two.isDone()&&Three.isDone()) {
				break;
			}
			Thread.sleep(1000);
		}
		long stop = System.currentTimeMillis();
		logger.info("任务执行成功，耗时{}s",(stop-start)/1000);
	}
	
}
