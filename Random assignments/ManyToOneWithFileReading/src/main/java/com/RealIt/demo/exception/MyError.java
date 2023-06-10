package com.RealIt.demo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyError {

	private LocalDateTime time;
	private String msg;
	private String des;
}
