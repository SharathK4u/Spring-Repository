package com.skdamoda.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This custom exception wraps the generic error with custom code
 * So that it can be more useful in returning a uniform message.
 *
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WebCrawlerException extends Exception {

	private static final long serialVersionUID = 9206074056696286648L;
	
	private final String code;

	public WebCrawlerException(String code) {
		super();
		this.code = code;
	}
	
	public WebCrawlerException(String message, String code) {
		super(message);
		this.code = code;
	}
	
	public WebCrawlerException(Throwable cause, String code) {
		super(cause);
		this.code = code;
	}

	public WebCrawlerException(String message, Throwable cause, String code) {
		super(message, cause);
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}

}
