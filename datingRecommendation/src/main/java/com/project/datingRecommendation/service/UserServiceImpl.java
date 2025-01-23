package com.project.datingRecommendation.service;

import com.project.datingRecommendation.dto.UserDto;
import com.project.datingRecommendation.entity.UserEntity;
import com.project.datingRecommendation.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public boolean validateAndSave(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setName(dto.getName());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());
        entity.setInterests(Arrays.asList(dto.getInterests().split(",")));
        return repo.save(entity);
    }

   

    @Override
    public List<UserDto> getRecommendations(Long userId, int limit) {
        UserEntity user = repo.findById(userId);
        if (user == null) {
            System.err.println("User with ID " + userId + " not found.");
            return Collections.emptyList();
        }

        List<UserEntity> allUsers = repo.findAll();
        if (allUsers == null || allUsers.isEmpty()) {
            System.err.println("No users found in the database.");
            return Collections.emptyList(); 
        }

        return allUsers.stream()
                .filter(u -> !u.getId().equals(userId)) // Exclude current user
                .filter(u -> u.getGender() != null && !u.getGender().equals(user.getGender())) 
                .sorted(Comparator.comparingInt((UserEntity u) -> Math.abs(u.getAge() - user.getAge())) 
                        .thenComparingInt(u -> -commonInterests(user, u))) 
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private int commonInterests(UserEntity u1, UserEntity u2) {
        if (u1.getInterests() == null || u2.getInterests() == null) {
            return 0; 
            }
        return (int) u1.getInterests().stream().filter(u2.getInterests()::contains).count();
    }

    private UserDto convertToDto(UserEntity entity) {
        return new UserDto(
            entity.getName(),
            entity.getGender(),
            entity.getAge(),
            String.join(",", entity.getInterests())
        );
    }
}
