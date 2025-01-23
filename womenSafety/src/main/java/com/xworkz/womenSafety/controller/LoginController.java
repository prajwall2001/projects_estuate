package com.xworkz.womenSafety.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.womenSafety.dto.WomenSafetyDto;
import com.xworkz.womenSafety.entity.WomenSafetyEntity;
import com.xworkz.womenSafety.service.WomenSafetyService;

@Component
@RequestMapping("/")
public class LoginController {
	public LoginController() {
		System.out.println("Invoking LoginController....");
	}

	@Autowired
	private WomenSafetyService service;

	@PostMapping("/login")
	public String findByEmailAndPassword(@RequestParam String email, String password, Model model,
			HttpSession session) {
		service.findAllUsers();
		String userEmail = email;
		session.setAttribute("loggedInEmail", email);
		boolean find = service.findByEmailAndPassword(email, password);

		if (find) {
			System.out.println("Login success..");
			return "success";
		} else {
			System.out.println("Login failed...");
		}
		return "login";
	}

	@PostMapping("/viewAll")
	public String viewAll(Model model) {
		List<WomenSafetyEntity> allUsers = service.findAllUsers();
		model.addAttribute("users", allUsers);
		return "success";

	}
	@PostMapping("/search")
	public String searchByName(@RequestParam String name,Model model) {
			List<WomenSafetyEntity> entities=service.findByName(name);
		    model.addAttribute("users", entities);
			return "success";
		
	}
	
	@GetMapping("/updateInfo")
    public String update(@RequestParam String email,Model model,HttpSession session) {
		session.getAttribute("email");
		if(email!=null) {
			WomenSafetyEntity entity=service.findByEmail(email);
			model.addAttribute("entity", entity);
		}
		service.findAllUsers();
		return "update";
	}
	
	@PostMapping("/update")
	public String updateMethod(WomenSafetyDto dto,String email,Model model,HttpSession session) {
		System.out.println("==========================================================");
		String userEmail = email;
		session.setAttribute("loggedInEmail", email);
  boolean update=service.updateByEmail(dto,dto.getEmail());
  if(dto!=null&dto.getEmail()!=null) {
	  if(update) {
		WomenSafetyEntity entity = service.findByEmail(dto.getEmail());
		model.addAttribute("entity", entity);
		model.addAttribute("message", "updated successfully");
		return "update";
	  }
  }
  WomenSafetyEntity entity = service.findByEmail(dto.getEmail());
  model.addAttribute("entity", entity);
	model.addAttribute("message", "updated successfully");
	return "success";
		
		
	}
	
	
	/*
	 * @PostMapping("/updateInfo") public String 
	 * updateInfo(@ModelAttribute("entity") @Valid WomenSafetyEntity entity, Model
	 * model) { boolean updated=service.update(entity); if (updated) {
	 * model.addAttribute("entity", updated); model.addAttribute("msg",
	 * "Information updated successfully"); return "success"; } else {
	 * model.addAttribute("msg", "Failed to update information"); return "update"; }
	 * }
	 */
}
