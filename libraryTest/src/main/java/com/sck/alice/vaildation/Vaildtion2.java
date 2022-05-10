package com.sck.alice.vaildation;

import java.util.Map;

import org.apache.el.util.Validation;

public class Vaildtion2 {

	
	private  String key;
	private  String value;
	
	
	public Vaildtion2 notNull(String key,Map<String,Object> map) throws Exception{
		
		if(map.get(key) == null) {
			throw new IllegalArgumentException( key + " is can not be null" );
		}
		
		return of(key,map.get(key).toString());
	}
//		this.key = key;
//		this.value = map.get(key).toString();
	
	
	public Vaildtion2 of(String key , String value) throws Exception{
		Vaildtion2 instance = new Vaildtion2();
		instance.key= key;
		instance.value= value;
		return instance;
		
	}
}
