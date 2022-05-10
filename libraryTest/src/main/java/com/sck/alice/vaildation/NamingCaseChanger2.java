package com.sck.alice.vaildation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NamingCaseChanger2{

	private Map<String, Object> map;
	
	
	public static NamingCaseChanger2 from(Map<String, Object> map) throws Exception{
		return new NamingCaseChanger2(map);
	}
	
	public NamingCaseChanger2(Map<String, Object> map) throws Exception{
		this.map = map;
	}
	
	
    public  Map<String,Object> toCamelCase() throws Exception{
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Iterator<String> keys = this.map.keySet().iterator();
        
        while( keys.hasNext() ){ 		
        	
	        String key = keys.next();
	        String changedKey = changeToCamelCase(key);
	        returnMap.put(changedKey, this.map.get(key).toString());
        }
        return returnMap;
    }
    
    public  Map<String,Object> toUnderBarCase() throws Exception{
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Iterator<String> keys = this.map.keySet().iterator();
        
        while( keys.hasNext() ){ 		
	        String key = keys.next();
	        String changedKey = changeToUnderBarCase(key);
	        returnMap.put(changedKey, this.map.get(key).toString());
        }
        return returnMap;
    }
    
    
    private String changeToUnderBarCase(String key) {
    	char[] arr = key.toCharArray();
    	String underBarCase = "";
   		for( char word : arr) {
    		if(Character.isUpperCase(word)) {
    			underBarCase += "_";
    			underBarCase += Character.toLowerCase(word);
    		}else {
    			underBarCase += word;
    		}
    	}
    	return underBarCase;
	}
    
    private String changeToCamelCase( String key) {
    	String[] splited = key.split("_");
    	String camelCase = splited[0];
    	for(int i = 1; i<splited.length; i++) {
    		camelCase += upperCaseFirst(splited[i]);
    	}
    	return camelCase;
    }
	private  String upperCaseFirst(String word) {
        char[] arr = word.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
     }
}
