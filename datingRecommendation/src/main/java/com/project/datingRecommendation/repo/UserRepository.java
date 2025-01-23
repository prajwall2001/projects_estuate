package com.project.datingRecommendation.repo;

import com.project.datingRecommendation.entity.UserEntity;

import java.util.List;

public interface UserRepository {
	boolean save(UserEntity entity);

	UserEntity findById(Long id);

	List<UserEntity> findAll();

}
