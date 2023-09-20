package com.movieChart.api;

import java.util.HashMap;

public class MakeParameter {
	 public String makeParameter(HashMap<String, String> paramMap) {
	        StringBuilder sb = new StringBuilder();
	 
	        paramMap.entrySet().forEach(( entry )->{
	            if( sb.length() > 0 ) {
	                sb.append('&');
	            }
	            sb.append(entry.getKey()).append('=').append(entry.getValue());
	        });
	 
	        return sb.toString();
	    }
}
