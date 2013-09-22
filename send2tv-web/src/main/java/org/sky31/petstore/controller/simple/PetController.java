package org.sky31.petstore.controller.simple;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.sky31.petstore.domain.PetDO;
import org.sky31.petstore.manager.impl.PetManager;
import org.sky31.petstore.model.PetQueryModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PetController
 * 
 * @author <a href="mailto:fangwu.zq@taobao.com">fangwu.zq</a>
 * @version 1.0
 * @since 2012-6-7
 */
@Controller
@RequestMapping("/pet/*")
public class PetController {

	private static final Log logger = LogFactory.getLog(PetController.class);

	@Resource
	private PetManager petManager;

	@RequestMapping("/color/{id}")
	public @ResponseBody
	String color(@PathVariable Long id) {
		PetDO pet = petManager.get(id);
		return pet == null ? "Sorry,the pet is not exsit!" : petManager.get(id).getColor();
	}

	@RequestMapping("/name/{id}")
	public @ResponseBody
	String name(@PathVariable Long id) {
		PetDO pet = petManager.get(id);
		return pet == null ? "Sorry,the pet is not exsit!" : petManager.get(id).getName();
	}

	@RequestMapping("/count")
	public @ResponseBody
	String count() {
		return petManager.count(new PetQueryModel()).toString();
	}

	@RequestMapping("/update/{id}/{name}")
	public @ResponseBody
	String update(@PathVariable Long id, @PathVariable String name, HttpServletRequest request,
			HttpServletResponse response) {
		PetDO petDO = new PetDO();
		petDO.setId(id);
		petDO.setName(name);
		try {
			return String.valueOf(petManager.update(petDO));
		} catch (Exception e) {
			logger.error("Update pet error:" + e.getMessage());
			return "系统繁忙中，请稍后再试!";
		}
	}
}
