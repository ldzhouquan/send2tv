package com.send2tv.weather;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WeatherInfoMannager {

	private static final ScheduledExecutorService executor = Executors
			.newScheduledThreadPool(1);

	private volatile String weatherInfo;
	
	private volatile long timestamp;

	public void init() {
		executor.scheduleAtFixedRate(new WeatherInfoCrawler(this), 0, 3, TimeUnit.HOURS);
	}
	
	public void shutdownCrawler(){
		executor.shutdown();
	}
	
	public String getWeatherInfo() {
		return weatherInfo;
	}

	public void setWeatherInfo(String weatherInfo) {
		this.weatherInfo = weatherInfo;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
