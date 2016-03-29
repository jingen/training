package com.training;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CollectionRemoval {

	public static void main(String[] args){
		Map<String, String> tMap = new HashMap<String, String>();
		tMap.put("1", "a");
		tMap.put("2", "b");
		Collection<String> cstr = tMap.values();
		
		for(String str: cstr){
			if(str.equals("a")){
				cstr.remove(str);
			};
		}
		
		for (Map.Entry<String, String> entry: tMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
