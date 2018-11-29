package com.example.test.app.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage {

	String message;
	Object data;
	boolean success;

	public ResponseMessage(Object data) {
		this.data = data;
	}

	public ResponseMessage(String message) {
		this.message = message;
	}

	public ResponseMessage(boolean success) {
		this.success = success;
	}

}
