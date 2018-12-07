package com.skdamoda.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.skdamoda.model.Message;
import com.skdamoda.model.WebCrawlerResponse;

@RestController
@ControllerAdvice("com.skdamoda.controller")
public class WebCrawlerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(WebCrawlerException.class)
	public final WebCrawlerResponse handleWebCrawlerException(WebCrawlerException ex) {
		Message message = new Message(ex.getMessage(),ex.getCode());
		WebCrawlerResponse response=new WebCrawlerResponse();
		List<Message> messageList = new ArrayList<Message>();
		messageList.add(message);
		response.setMessages(messageList);
		return response;
	}
}
