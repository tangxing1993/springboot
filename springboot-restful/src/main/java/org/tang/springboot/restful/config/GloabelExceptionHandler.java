package org.tang.springboot.restful.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tang.springboot.restful.Exception.MyException;
import org.tang.springboot.restful.entity.ErrorInfo;

/**
 * @desc 创建全局的异常处理类 
 * @date 2017年8月10日
 * @author tx
 */
@ControllerAdvice //注解全局异常通知
public class GloabelExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW="error"; 
	
	/**
	 * 异常统一处理配置
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
    @ExceptionHandler(value=Exception.class)
	public ModelAndView defaultExceptionHandler(HttpServletRequest req,Exception e)throws Exception{
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		return mav;
	}
    
    @ExceptionHandler(value=MyException.class)
    @ResponseBody
    public ErrorInfo<String> defaultMyExceptionHandler(HttpServletRequest req,MyException e){
    	ErrorInfo<String> info = new ErrorInfo<>();
    	info.setCode(ErrorInfo.ERROR);
    	info.setMessage(e.getMessage());
    	info.setUrl(req.getRequestURL().toString());
    	info.setData("some data");
    	return info;
    }
	
}
