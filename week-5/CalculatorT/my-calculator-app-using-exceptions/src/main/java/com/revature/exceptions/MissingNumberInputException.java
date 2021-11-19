package com.revature.exceptions;

public class MissingNumberInputException extends RuntimeException { // unchecked exception

	public MissingNumberInputException() {
		super();
	}

	public MissingNumberInputException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MissingNumberInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingNumberInputException(String message) {
		super(message);
	}

	public MissingNumberInputException(Throwable cause) {
		super(cause);
	} 

}
