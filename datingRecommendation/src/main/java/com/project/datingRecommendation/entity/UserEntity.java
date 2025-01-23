package com.project.datingRecommendation.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
@Table(name="dating_recommendation")
@NamedQuery(name = "findAll", query = "Select et from UserEntity et")
public class UserEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @NotNull
	    @Size(min = 3, max = 30, message = "Name must be between 3-30 characters")
	    @Column(name = "name")
	    private String name;

	    @NotNull
	    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
	    @Column(name = "gender")
	    private String gender;

	    @NotNull
	    @Column(name = "age")
	    private int age;

	    @ElementCollection
	    @CollectionTable(name = "user_interests", joinColumns = @JoinColumn(name = "user_id"))
	    @Column(name = "interest")
	    private List<String> interests;
}
