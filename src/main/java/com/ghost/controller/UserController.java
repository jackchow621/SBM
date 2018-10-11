package com.ghost.controller;

import com.ghost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/regiester")
	public String regiester(Map<String, Object> model){
		userService.saveUser(null);
		model.put("msg", "jack success");
		return "regiester";
	}
}
