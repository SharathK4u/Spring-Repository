package com.skdamoda.model;

import java.util.List;

public class WebCrawlerResponse {
	
	private UrlDetails urlDetails;
	private List<Message> messages;
	public UrlDetails getUrlDetails() {
		return urlDetails;
	}
	public void setUrlDetails(UrlDetails urlDetails) {
		this.urlDetails = urlDetails;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
