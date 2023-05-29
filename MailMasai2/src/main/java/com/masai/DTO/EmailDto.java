package com.masai.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto{

	private String email;
	private String body;
	private List<String> sendTo=new ArrayList<>();
}
