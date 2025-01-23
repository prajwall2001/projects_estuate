package com.xworkz.womenSafety.service;

import java.util.List;

import com.xworkz.womenSafety.dto.WomenSafetyDto;
import com.xworkz.womenSafety.entity.WomenSafetyEntity;

public interface WomenSafetyService {
	public boolean validateAndSave(WomenSafetyDto dto);

	boolean findByEmailAndPassword(String email, String password);

	public List<WomenSafetyEntity> findAllUsers();
	
	List<WomenSafetyEntity> findByName(String name);
	
	boolean update(WomenSafetyEntity entity);
	
	boolean updateByEmail(WomenSafetyDto dto,String email);
	
	WomenSafetyEntity findByEmail(String email);

}
