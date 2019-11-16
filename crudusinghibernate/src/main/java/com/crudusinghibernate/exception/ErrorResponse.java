package com.crudusinghibernate.exception;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
public class ErrorResponse implements Serializable {

	private Integer status;
	
	private String message;

	public ErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
		
	}
	
}
