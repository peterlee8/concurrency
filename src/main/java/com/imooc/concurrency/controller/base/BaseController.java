package com.imooc.concurrency.controller.base;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.concurrency.util.PageData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;


@Slf4j
public class BaseController {
	

	private static final long serialVersionUID = 6357869213649815390L;
	
	/**
	 * 得到PageData
	 */
	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	
	/**
	 * 获取页面传递过来的所有参数，并将参数名转换成大写
	 * @return
	 */
	public PageData getPageDataToUpper(){
		return new PageData(this.getRequest(), true);
	}
	
	/**
	 * 获取页面传递过来的所有参数，并将参数转码
	 * @param isUpper 是否转换成大写
	 * @return
	 */
	public PageData getPageDataFormAjax(boolean isUpper){
		return new PageData(this.getRequest(), isUpper, true);
	}
	
	/**
	 * 得到ModelAndView
	 */
	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		response.addHeader("1","2");
		return request;
	}

}
