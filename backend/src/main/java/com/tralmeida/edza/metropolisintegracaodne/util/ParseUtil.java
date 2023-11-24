package com.tralmeida.edza.metropolisintegracaodne.util;

public class ParseUtil {
	
	public static Long parseStringToLong(String str) {
		try {
			return Long.parseLong(str);
		} catch(Exception e) {
			return null;
		}
	}

}
