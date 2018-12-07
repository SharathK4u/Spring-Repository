package com.skdamoda.util;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.skdamoda.exception.WebCrawlerException;
import com.skdamoda.model.UrlDetails;

@RunWith(MockitoJUnitRunner.class)
public class HTMLParserTest {
	
	@InjectMocks
	HTMLParser htmlParser;
	
	@Test
	public void parseWithValidUrl() throws WebCrawlerException{
		List<UrlDetails> urlDetails=htmlParser.parse("http://wiprodigital.com", 1);
		assertNotEquals(0, urlDetails.size());
	}
	
	@Test(expected=WebCrawlerException.class)
	public void parseWithInvalidUrl1() throws WebCrawlerException{
		htmlParser.parse("http://test123", 1);
	}
	
	@Test(expected=WebCrawlerException.class)
	public void parseWithInvalidUrl2() throws WebCrawlerException{
		htmlParser.parse("test123", 1);
	}
	
}
