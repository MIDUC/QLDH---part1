package com.example.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.LopEntity;
import com.example.demo.repository.LopRePository;

@Controller
@RequestMapping("/lop")
public class LopController {
	private final LopRePository repo;

	private LopController(LopRePository repo) {
		this.repo = repo;
	}

	@GetMapping
	public String showDesignForm(Model model) {
		List<LopEntity> result = repo.getAllLopEntities();
		model.addAttribute("values", result);
		return "lop";
	}

	public String showLop(Model model) {
		model.addAttribute("values", repo.getAllLopEntities());
		return "lop";
	}
	
	
}
