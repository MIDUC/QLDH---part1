package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.DiemEntity;
import com.example.demo.repository.DiemRePository;

@Controller
@RequestMapping("/diem")
public class DiemController {
	private final DiemRePository repo;
	private DiemController(DiemRePository repo) {
		this.repo = repo;
	}
	public String showDiem(Model model) {
		model.addAttribute("values", repo.getAllDiemEntities());
		return "diem";
	}
	@GetMapping("/search")
	public String search(@Param("keyword") String keyword, Model model) {
		List<DiemEntity> ttv = repo.getAllDiemEntities();
		List<DiemEntity> result = new ArrayList<DiemEntity>();
		for(DiemEntity tv : ttv) {
			if(tv.getMa_thanh_vien().getMa_sinh_vien().getTen().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(tv);
			}
		}
		model.addAttribute("values", result);
		return "diem";
	}
	@GetMapping
	public String showDesignForm(Model model) {
		List<DiemEntity> result = repo.getAllDiemEntities();
		model.addAttribute("values", result);
		return "diem";
	}

	
}