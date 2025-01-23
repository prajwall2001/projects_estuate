package com.xworkz.womenSafety.repo;

import java.util.List;

import com.xworkz.womenSafety.entity.WomenSafetyEntity;

public interface WomenSafetyRepo {

	public boolean save(WomenSafetyEntity entity);

	boolean findByEmailAndPassword(String email,String password);
	
	List<WomenSafetyEntity> findAll();
	
	List<WomenSafetyEntity> findByName(String name);


	WomenSafetyEntity findByEmail(String email);
	
	 boolean update(WomenSafetyEntity entity,int id);
	 

}
