package com.training.exceptions;

public class NoNegativeNumberException extends Exception {
private String message;

	public String getMessage() {
	return message;
}

	public NoNegativeNumberException(String message) {
		this.message = message;
	}
	
	public String toString()
	{
		return "NoNegativeNumberException has occured|"+message;
	}
	

}
