package com.xworkz.womenSafety.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.womenSafety.dto.WomenSafetyDto;
import com.xworkz.womenSafety.entity.WomenSafetyEntity;
import com.xworkz.womenSafety.service.WomenSafetyService;

@Component
@RequestMapping("/")
public class RegisterController {
	public RegisterController() {
		System.out.println("Invoking RegisterController....");
	}

	@Autowired
	private WomenSafetyService service;

	
	@PostMapping("/save")
	public String saveMethod(WomenSafetyDto dto,Model model) {
		boolean save=service.validateAndSave(dto);
		
		if(save) {
			return "login";
		}else {
			System.out.println("Data does saved successfully");
		}
		return "register";
		
	}
	
	
	@PostMapping("/womenSafetyRegistration")
	public String save(@Valid WomenSafetyEntity entity, BindingResult errors, Model model) {
		System.out.println("Invoking save");
		System.out.println("Is WomenSafetyEntity is valid:" + errors.hasErrors());
		model.addAttribute("entity", entity);
		if (errors.hasErrors()) {
			List<ObjectError> objectErrors = errors.getAllErrors();
			objectErrors.forEach(e -> System.err.println(e.getObjectName() + ":meassage " + e.getDefaultMessage()));
			model.addAttribute("errors", objectErrors);
			return "register";
		} else {
			model.addAttribute("msg", "User information saved successfully");

		}
//		this.service.validateAndSave(entity);
		return "register";
	}

}
