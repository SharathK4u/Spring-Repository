package com.skdamoda.controller;

import static org.junit.Assert.assertNotEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.skdamoda.WebCrawlerApplication;
import com.skdamoda.model.WebCrawlerRequest;
import com.skdamoda.model.WebCrawlerResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=WebCrawlerApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebCrawlerControllerIT {

	TestRestTemplate restTemplate=new TestRestTemplate();
	
	@LocalServerPort
	private int port;
	
	@Test
	public void parseWithValidUrl() throws RestClientException, URISyntaxException {
		String url = "http://wiprodigital.com";
		int level = 1;
		WebCrawlerRequest request = new WebCrawlerRequest();
		request.setBaseUrl(url);
		request.setDepth(level);
		WebCrawlerResponse response = 
				restTemplate.postForObject(createURLWithPort("/crawl"), request, WebCrawlerResponse.class);
		assertNotEquals(0, response.getUrlDetails().getChildUrlDetails().size());
	}
	
	@Test
	public void parseWithInvalidUrl() throws RestClientException, URISyntaxException {
		String url = "Test123";
		int level = 2;
		WebCrawlerRequest request = new WebCrawlerRequest();
		request.setBaseUrl(url);
		request.setDepth(level);
		WebCrawlerResponse response = 
				restTemplate.postForObject(createURLWithPort("/crawl"), request, WebCrawlerResponse.class);
		assertNotEquals(0, response.getMessages().size());
	}
	
	private URI createURLWithPort(String uri) throws URISyntaxException {
		return new URI("http://localhost:" + port + uri);
	}

}
