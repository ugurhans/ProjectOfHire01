package com.example.demo.core.results;

public class ErrorResult extends Result {

	public ErrorResult(boolean succes, String message) {
		super(false, message);
	}

	public ErrorResult(String message) {
		super(false, message);
	}
}
