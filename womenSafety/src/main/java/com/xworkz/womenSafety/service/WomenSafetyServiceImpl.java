package com.xworkz.womenSafety.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.womenSafety.dto.WomenSafetyDto;
import com.xworkz.womenSafety.entity.WomenSafetyEntity;
import com.xworkz.womenSafety.repo.WomenSafetyRepo;

@Service
public class WomenSafetyServiceImpl implements WomenSafetyService {
	@Autowired
	private WomenSafetyRepo repo;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public boolean validateAndSave(WomenSafetyDto dto) {
		WomenSafetyEntity entity=new WomenSafetyEntity();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setAadharNumber(dto.getAadharNumber());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setAlternatePhoneNumber(dto.getAlternatePhoneNumber());
		entity.setAddress(dto.getAddress());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setGender(dto.getGender());
		entity.setBloodGroup(dto.getBloodGroup());
		entity.setPassword(encoder.encode(dto.getPassword()));
		entity.setState(dto.getState());
	    entity.setCountry(dto.getCountry());
		System.out.println("Invoking validateAndSave....");
		System.out.println("Entity passed:" + dto);
		this.repo.save(entity);
		return true;
	}

	@Override
	public boolean findByEmailAndPassword(String email, String password) {

		WomenSafetyEntity en = repo.findByEmail(email);
		if (en != null && en.getEmail() != null) {
			if (en.getEmail().equals(email) && encoder.matches(password, en.getPassword())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<WomenSafetyEntity> findAllUsers() {
		System.out.println("Invoking findAllUsers in WomenSafetyServiceImpl...");
		return repo.findAll();
	}

	@Override
	public List<WomenSafetyEntity> findByName(String name) {
		System.out.println("Invoking findAllUsers in WomenSafetyServiceImpl...");
		return repo.findByName(name);
	}
	
	@Override
	public boolean update(WomenSafetyEntity entity) {
		System.out.println("Invoking update..");
		
		return repo.update(entity, 0);
	}
	@Override
	public boolean updateByEmail(WomenSafetyDto dto, String email) {
		System.out.println("Invoking updateByEmail..");
	WomenSafetyEntity entity=repo.findByEmail(email);
	if(entity!=null&&entity.getEmail()!=null) {
		entity.setName(dto.getName());
		entity.setAadharNumber(dto.getAadharNumber());
		entity.setAddress(dto.getAddress());
		entity.setAlternatePhoneNumber(dto.getAlternatePhoneNumber());
		entity.setBloodGroup(dto.getBloodGroup());
		entity.setCountry(dto.getCountry());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setGender(dto.getGender());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setState(dto.getState());
	    boolean updated=repo.update(entity, entity.getId())	;
	    if (updated) {
			System.out.println("Updated successfully..."); 
			return true;
	        } else {
	            System.out.println("Failed to update information");
	       
	        }
	}
    return false;

	}
	@Override
	public WomenSafetyEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
	}
}
