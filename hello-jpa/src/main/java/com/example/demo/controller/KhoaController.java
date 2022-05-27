package com.example.demo.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.KhoaEntity;
import com.example.demo.repository.KhoaRepository;

@Controller
@RequestMapping("/khoa")
public class KhoaController {
	private final KhoaRepository repo;

	private KhoaController(KhoaRepository repo) {
		this.repo = repo;
	}

	@GetMapping
	public String showDesignForm(Model model) {
		List<KhoaEntity> result = repo.getAllKhoaEntities();
		model.addAttribute("values", result);
		return "khoa";
	}

	public String showKhoa(Model model) {
		model.addAttribute("values", repo.getAllKhoaEntities());
		return "khoa";
	}
}