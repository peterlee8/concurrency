package com.imooc.concurrency.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class PageData extends HashMap implements Map{
	
	private static final long serialVersionUID = 1L;
	
	Map map = null;
	HttpServletRequest request;
	
	public PageData(HttpServletRequest request){
		changeData(request, false, false);
	}
	
	public PageData(HttpServletRequest request, boolean isUpper){
		changeData(request, isUpper, false);
	}
	
	public PageData(HttpServletRequest request, boolean isUpper, boolean isTranscode){
		changeData(request, isUpper, isTranscode);
	}


	
	/**
	 * 获取request里面的参数
	 * @param request 
	 * @param isUpper 是否需要将参数名转换成大写
	 * @param isAjaxRequest 是否为ajax请求（ajax请求默认使用ISO-8859-1编码，需要转换成UTF-8）
	 */
	private void changeData(HttpServletRequest request, boolean isUpper, boolean isTranscode){
		this.request = request;
		Map properties = request.getParameterMap();
		Map returnMap = new HashMap(); 
		Iterator entries = properties.entrySet().iterator(); 
		Entry entry;
		String name = "";  
		String value = "";  
		try {
			while (entries.hasNext()) {
				value = "";
				entry = (Entry) entries.next();
				name = (String) entry.getKey(); 
				Object valueObj = entry.getValue(); 
				if(null == valueObj){ 
					value = ""; 
				}else if(valueObj instanceof String[]){ 
					String[] values = (String[])valueObj;
					for(int i=0;i<values.length;i++){ 
						 value += values[i] + ",";
					}
					value = value.substring(0, value.length()-1); 
				}else{
					value = valueObj.toString(); 
				}
				if(isTranscode && notEmpty(value)){
					value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
				}
				if(isUpper){
					returnMap.put(name.toUpperCase(), value); 
				}else {
					returnMap.put(name, value); 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map = returnMap;
	}

	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	private boolean notEmpty(String s){
		return s!=null && !"".equals(s) && !"null".equals(s);
	}
	
	public PageData() {
		map = new HashMap();
	}
	
	@Override
	public Object get(Object key) {
		Object obj = null;
		if(map.get(key) instanceof Object[]) {
			obj = (Object[])map.get(key);
//			obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0]);
		} else {
			obj = map.get(key);
		}
		return obj;
	}
	
	public String getString(Object key) {
		return (String)get(key);
	}
	
	public Date getDate(Object key) {
		return (Date)get(key);
	}
	
	public Integer getInt(Object key) {
		return Integer.valueOf(String.valueOf(get(key)));
	}
	
	public Long getLong(Object key) {
		return Long.valueOf(String.valueOf(get(key)));
	}
	
	public Double getDouble(Object key) {
		return Double.valueOf(String.valueOf(get(key)));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}
	
	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return map.containsValue(value);
	}

	public Set entrySet() {
		// TODO Auto-generated method stub
		return map.entrySet();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return map.isEmpty();
	}

	public Set keySet() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

	@SuppressWarnings("unchecked")
	public void putAll(Map t) {
		// TODO Auto-generated method stub
		map.putAll(t);
	}

	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}

	public Collection values() {
		// TODO Auto-generated method stub
		return map.values();
	}
	
}
