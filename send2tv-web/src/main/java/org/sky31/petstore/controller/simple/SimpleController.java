package org.sky31.petstore.controller.simple;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.send2tv.weather.WeatherInfoMannager;

@Controller
public class SimpleController {

	@Resource
	private WeatherInfoMannager weatherInfoMannager;

	@RequestMapping(value = "/simple")
	public @ResponseBody String simple() {
		return weatherInfoMannager.getWeatherInfo();
	}

	@RequestMapping(value = "/")
	public String index(ModelMap modelMap, HttpServletRequest request,
			HttpServletResponse response) {
		String header = request.getHeader("User-Agent");
		modelMap.put("msg", header);
		System.out.println(header);
		return "index";
	}

}
