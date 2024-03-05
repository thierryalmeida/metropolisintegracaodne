package com.tralmeida.edza.metropolisintegracaodne.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeUtil {
	
	public static long getCurrentTimeInMillis() {
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
		long timeInMillis = zdt.toEpochSecond() * 1000;
		
		return timeInMillis;
	}
}
