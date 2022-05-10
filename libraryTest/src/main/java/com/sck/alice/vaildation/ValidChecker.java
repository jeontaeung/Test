package com.sck.alice.vaildation;

import java.util.Map;


public class ValidChecker {

	
	Map<String,Object> map;
	
	public ValidChecker(Map<String, Object> body) throws Exception{
		map = body;
	}
	
	public void notNull(String key) throws Exception{
			
		if(isNull(key)) {
			throw new IllegalArgumentException( key + " is can not be null" );
		}
	}
	
	public void notEmpty(String key) throws Exception{
		
		if(isNull(key)) {
			throw new IllegalArgumentException( key + " is can not be empty but null" );
		}
		
		if(isEmpty(key)) {
			throw new IllegalArgumentException( key + " is can not be empty" );
		}
	}
	
	public boolean isNull(String key) throws Exception{
		if(map.get(key) == null) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(String key) throws Exception{
		if(map.get(key).toString().equals("")) {
			return true;
		}
		return false;
	}
	
	public void ifNull(String key, Object obj) throws Exception{
		
		if(isNull(key)) {
			map.put(key,obj);
		}
	}
	
	public void ifEmpty(String key, Object obj) throws Exception{
		if(isNull(key)) {
			map.put(key,obj);
			return;
		}
		if(isEmpty(key)) {
			map.put(key,obj);
		}
	}
	
	public Map<String, Object> getMap(){
		return map;
	}
	
//	public void illegalArg(String key,String msg) throws Exception{
//		throw new IllegalArgumentException( key + " " + msg );
//	}
}
