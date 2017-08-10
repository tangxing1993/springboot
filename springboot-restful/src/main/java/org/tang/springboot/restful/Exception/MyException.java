package org.tang.springboot.restful.Exception;
/**
 * @desc 自定义的异常类
 * @date 2017年8月10日
 * @author tx
 */
public class MyException extends Exception {

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}
}
