package com.project.datingRecommendation.dto;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private Long id;
	private String name;
	private String gender;
	private int age;
	private String interests;

	public UserDto(String name, String gender, int age, String interests) {
		this.id=id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.interests = interests;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public List<String> getInterestsList() {
		return interests != null ? Arrays.asList(interests.split(",")) : Arrays.asList();
	}

	@Override
	public String toString() {
		return "UserDto{" + "name='" + name + '\'' + ", gender='" + gender + '\'' + ", age=" + age + ", interests='"
				+ interests + '\'' + '}';
	}
}
