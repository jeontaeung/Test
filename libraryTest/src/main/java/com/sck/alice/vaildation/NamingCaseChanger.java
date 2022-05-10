package com.sck.alice.vaildation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NamingCaseChanger{

	
    public  static Map<String,Object> toCamelCase(Map<String, Object> map) throws Exception{
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator<String> keys = map.keySet().iterator();
        
        while( keys.hasNext() ){ 		
        	
	        String key = keys.next();
	        String changedKey = changeToCamelCase(key);
	        returnMap.put(changedKey, map.get(key).toString());
        }
        return returnMap;
    }
    
    public static  Map<String,Object> toUnderBarCase(Map<String, Object> map) throws Exception{
        Map<String, Object> returnMap = new HashMap<String, Object>();

        Iterator<String> keys = map.keySet().iterator();
        
        while( keys.hasNext() ){ 		
	        String key = keys.next();
	        String changedKey = changeToUnderBarCase(key);
	        returnMap.put(changedKey, map.get(key).toString());
        }
        return returnMap;
    }
    
    
    private static String changeToUnderBarCase(String key) {
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
    
    private static String changeToCamelCase( String key) {
    	String[] splited = key.split("_");
		String camelCase = splited[0];
		for(int i = 1; i<splited.length; i++) {
			camelCase += upperCaseFirst(splited[i]);
		}
		return camelCase;
    }
	private  static String upperCaseFirst(String word) {
        char[] arr = word.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        return new String(arr);
     }
}
