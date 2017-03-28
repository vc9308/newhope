package com.codingvictor.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Internationalization {
    public static Map<String, String> getLangueInfo(HttpServletRequest request) {
    	String lang = "zh";
    	String country = "CN";
    	
    	Map<String, String> langInfo = new HashMap<String, String>();
    	
    	Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if ("lang".equals(cookie.getName())) {
					lang = cookie.getValue();
				}
				if ("country".equals(cookie.getName())) {
					country = cookie.getValue();
				}
			}
		}
		
		langInfo.put("lang", lang);
		langInfo.put("country", country);
		
		return langInfo;
    }
}
