package com.project.datingRecommendation.service;

import com.project.datingRecommendation.dto.UserDto;

import java.util.List;

public interface UserService {
	boolean validateAndSave(UserDto dto);

	List<UserDto> getRecommendations(Long userId, int limit);
}
