package com.skdamoda.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skdamoda.exception.WebCrawlerException;
import com.skdamoda.model.Message;
import com.skdamoda.model.UrlDetails;
import com.skdamoda.model.WebCrawlerResponse;
import com.skdamoda.util.BaseParser;

@Service
public class WebCrawlerService {
	@Autowired
	@Qualifier("htmlParser")
	private BaseParser htmlParser;
	
	private UrlDetails urlDetailsRoot;
	private WebCrawlerResponse response;
	public WebCrawlerResponse parse(String url,int depth) throws WebCrawlerException {
		Queue<UrlDetails> urlQueue = new LinkedList<UrlDetails>();
		urlDetailsRoot = new UrlDetails(url,1);
		urlQueue.add(urlDetailsRoot);
		while(!urlQueue.isEmpty()) {
			UrlDetails urlDetails = urlQueue.poll();
			if(urlDetails.getLevel()>depth)
				break;
			List<UrlDetails> urlDetailsList= htmlParser.parse(urlDetails.getUrl(), urlDetails.getLevel()+1);
			urlDetails.addChildUrlDetailsList(urlDetailsList);
			for(UrlDetails urlDt : urlDetailsList) {
				if(!urlQueue.contains(urlDt)) {
					urlQueue.add(urlDt);
				}
			}
		}
		response = new WebCrawlerResponse();
		Message message = new Message("SUCCESS","Crawled Successfully.");
		List<Message> messages = new ArrayList<Message>();
		messages.add(message);
		response.setUrlDetails(urlDetailsRoot);
		response.setMessages(messages);
		return response;
	}
	
}
