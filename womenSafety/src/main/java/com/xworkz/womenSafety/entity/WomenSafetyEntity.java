package com.xworkz.womenSafety.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name="ws_register")
@NamedQuery(name = "findByEmailAndPassword", query = "Select et from WomenSafetyEntity et where et.email=:email and et.password=:password")
@NamedQuery(name = "findAll", query = "Select et from WomenSafetyEntity et")
@NamedQuery(name = "findByName", query = "Select et from WomenSafetyEntity et where et.name=:name")
@NamedQuery(name = "findByEmail", query = "Select et from WomenSafetyEntity et where et.email=:email")


public class WomenSafetyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "w_id")
	private int id;
	@NotNull
	@Size(min = 3, max = 30, message = "Name must be between 3-30 characters")
	@Column(name = "name")
	private String name;
	@Email
	@Column(name = "email")
	private String email;
	@NotBlank(message = "Password is required")
	@Size(min = 8, message = "Password must be at least 8 characters long")
	@Column(name = "password")
	private String password;
	@NotNull
	@Column(name = "aadhar_number")
	private long aadharNumber;
	@NotBlank(message = "Date of birth is required")
	@Column(name = "date_of_birth")
	private String dateOfBirth;
	@NotNull
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
	@Column(name = "gender")
	private String gender;
	@NotNull
	@Column(name = "phone_number")
	private String phoneNumber;
	@NotNull
	@Column(name = "alt_phone_number")
	private String alternatePhoneNumber;
	@NotNull
	@Size(min = 2, max = 10, message = "Blood Group must be between 2-10 characters")
	@Column(name = "blood_group")
	private String bloodGroup;
	@NotNull
	@Size(min = 3, max = 30, message = "Address must be between 3-30 characters")
	@Column(name = "address")
	private String address;
	@Size(min = 3, max = 30, message = "State must be between 3-30 characters")
	@Column(name = "state")
	private String state;
	@Size(min = 3, max = 30, message = "Country must be between 3-30 characters")
	@Column(name = "country")
	private String country;
}
