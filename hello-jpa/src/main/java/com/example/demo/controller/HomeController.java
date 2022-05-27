package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.ThanhVienEntity;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/dangkylop", method = RequestMethod.POST)
	public String processFormData(ThanhVienEntity thanhvien) {
		return "dangkylop";
	}
}
