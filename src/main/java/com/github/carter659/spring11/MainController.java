package com.github.carter659.spring11;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 博客出处：http://www.cnblogs.com/GoodHelper/
 * 
 * @author 刘冬
 *
 */
@Controller
public class MainController {

	private static final String STR_SESSION_KEY = "name";

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/setSession")
	public @ResponseBody Map<String, Object> setSession(String value, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		request.getSession().setAttribute(STR_SESSION_KEY, value);
		map.put("msg", "ok");
		return map;
	}

	@PostMapping("/getSession")
	public @ResponseBody Map<String, Object> getSession(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		Object value = session.getAttribute(STR_SESSION_KEY);
		map.put("value", value);
		map.put("id", session.getId());
		map.put("port", request.getLocalPort());
		map.put("msg", "ok");
		return map;
	}

}
