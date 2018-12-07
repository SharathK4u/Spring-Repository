package com.skdamoda.service;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.skdamoda.exception.WebCrawlerException;
import com.skdamoda.model.UrlDetails;
import com.skdamoda.util.HTMLParser;
import com.skdamoda.model.WebCrawlerResponse;;

@RunWith(MockitoJUnitRunner.class)
public class WebCrawlerServiceTest {
	
	@InjectMocks
	WebCrawlerService webCrawlerService;
	
	@Mock
	HTMLParser htmlParser;
	
	@Test
	public void parseWithValidUrl() throws WebCrawlerException{
		String url="http://wiprodigital.com";
		int level=1;
		UrlDetails urlDetails = new UrlDetails("http://MockResponse",2);
		List<UrlDetails> urlDetailsList = new ArrayList<UrlDetails>();
		urlDetailsList.add(urlDetails);
		Mockito.when(htmlParser.parse(Mockito.anyString(),Mockito.anyInt())).thenReturn(urlDetailsList);
		WebCrawlerResponse response=webCrawlerService.parse(url,level);
		assertNotEquals(0, response.getUrlDetails().getChildUrlDetails().size());
	}
	
	@Test(expected=WebCrawlerException.class)
	public void parseWithInvalidUrl() throws WebCrawlerException{
		Mockito.when(htmlParser.parse(Mockito.anyString(),Mockito.anyInt())).thenThrow(new WebCrawlerException("PARSER_ERROR"));
		webCrawlerService.parse("http://test123", 1);
	}
}
