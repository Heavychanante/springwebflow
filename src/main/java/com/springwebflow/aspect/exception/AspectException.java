package com.springwebflow.aspect.exception;

public class AspectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AspectException() {
		super();
	}

	public AspectException(Exception e) {
		super(e);
	}
}
