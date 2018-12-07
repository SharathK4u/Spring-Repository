package com.skdamoda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skdamoda.exception.WebCrawlerException;
import com.skdamoda.model.WebCrawlerRequest;
import com.skdamoda.model.WebCrawlerResponse;
import com.skdamoda.service.WebCrawlerService;

@RestController
public class WebCrawlerController {
	
	@Autowired
	private WebCrawlerService service;
	
	@RequestMapping(value="/crawl",method=RequestMethod.POST)
	public WebCrawlerResponse crawl(@RequestBody WebCrawlerRequest request) throws WebCrawlerException {
		WebCrawlerResponse response = service.parse(request.getBaseUrl(), request.getDepth());
		return response;
	}

}
