package com.send2tv.weather;

import java.io.IOException;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * WeatherInfoCrawler
 * 
 * @author <a href="mailto:ldzhouquan@gmail.com">zhouquan</a>
 * @version 1.0
 * @since 2013-9-22
 */
public class WeatherInfoCrawler implements Runnable {

	private static final Log log = LogFactory.getLog(WeatherInfoCrawler.class);

	/**
	 * 天气预报API网关
	 */
	public static final String WEATHER_API_URL = "http://m.weather.com.cn/data/";

	/**
	 * 天气预报地址码
	 */
	public static final String WEATHER_CODE = "101250801";

	/**
	 * 真实请求的URL
	 */
	private String weatherInfoUrl = WEATHER_API_URL + WEATHER_CODE + ".html";

	/**
	 * weatherInfoMannager
	 */
	private WeatherInfoMannager weatherInfoMannager;

	/**
	 * 失败重试次数，默认为5次
	 */
	private int retryCount = 5;

	/**
	 * Constructor
	 * 
	 * @param retryCount 失败重试次数
	 */
	public WeatherInfoCrawler(int retryCount, WeatherInfoMannager weatherInfoMannager) {
		super();
		this.retryCount = retryCount;
		this.weatherInfoMannager = weatherInfoMannager;
	}

	public WeatherInfoCrawler(WeatherInfoMannager weatherInfoMannager) {
		super();
		this.weatherInfoMannager = weatherInfoMannager;
	}

	@Override
	public void run() {
		crawl(retryCount);
	}

	/**
	 * 抓取天气信息，失败自动重试。
	 * 
	 * @param retryCount 失败重试次数
	 */
	private void crawl(int retryCount) {
		if (log.isWarnEnabled()) {
			log.warn("Begin to crawl weather info,remain retry count : " + retryCount);
		}
		// 检查剩余重试次数
		if (retryCount <= 0) {
			return;
		}
		try {
			// 1. Jsoup抓取天气信息
			Document document = Jsoup.connect(weatherInfoUrl).get();
			String weatherInfo = document.text();
			// 2. 检查返回内容
			if (weatherInfo != null && !weatherInfo.equals("")) {
				JSONObject.fromObject(weatherInfo);
				weatherInfoMannager.setWeatherInfo(weatherInfo);
				weatherInfoMannager.setTimestamp(System.nanoTime());
			}
		} catch (IOException e) {
			log.error("Http connect error:", e);
			log.error("try to crawl again...");
			crawl(--retryCount);
		} catch (Exception e) {
			log.error("Json convert error:", e);
			log.error("try to crawl again...");
			crawl(--retryCount);
		}
	}

	public void setWeatherInfoMannager(WeatherInfoMannager weatherInfoMannager) {
		this.weatherInfoMannager = weatherInfoMannager;
	}

}
