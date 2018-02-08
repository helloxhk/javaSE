package com.jdk8.date_api;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 时钟类
 * @author xhk
 */
public class ClockTest {

	public static void main(String[] args) {
		
		Clock clock = Clock.systemDefaultZone();
		/**
		 * 获取当前时间的毫秒值(System.currenTimeMillis值)
		 */
		long millis = clock.millis();
		System.out.println(millis);
		
		/**
		 * 通过时钟获得当前时间
		 * 	通过Date.from(instant) 转换为Date格式
		 */
		Instant instant = clock.instant();
		System.out.println(instant);
		Date from = Date.from(instant);
		System.out.println(from.toLocaleString());
		
		System.out.println(ZoneId.getAvailableZoneIds());
		ZoneId asia = ZoneId.of("Asia/Aden");
		System.out.println(asia);
		
		LocalDate now = LocalDate.now();
		System.out.println(now);
		LocalDate tomorrow = now.plus(1, ChronoUnit.DAYS);
		System.out.println(tomorrow);
		LocalDate yesterday = tomorrow.minusDays(2);
		System.out.println(yesterday.getDayOfWeek());
	}

}
