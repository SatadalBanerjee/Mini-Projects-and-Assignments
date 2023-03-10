package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer bookId;
	@NotBlank
	private String name;
	@NotBlank
	private String author;
	@Min(value = 100)
	private String price;	
}
