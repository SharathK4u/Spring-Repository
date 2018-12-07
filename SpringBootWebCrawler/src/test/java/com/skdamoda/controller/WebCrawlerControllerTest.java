package com.skdamoda.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skdamoda.model.UrlDetails;
import com.skdamoda.model.WebCrawlerRequest;
import com.skdamoda.model.WebCrawlerResponse;
import com.skdamoda.service.WebCrawlerService;

@RunWith(SpringRunner.class)
@WebMvcTest(WebCrawlerController.class)
public class WebCrawlerControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	WebCrawlerService webCrawlerService;

	@Test
	public void parseWithValidUrl() throws JsonProcessingException, Exception{
		String url="http://wiprodigital.com";
		int level=1;
		WebCrawlerRequest request = new WebCrawlerRequest();
		request.setBaseUrl(url);
		request.setDepth(level);
		WebCrawlerResponse mockRresponse = new WebCrawlerResponse();
		mockRresponse.setUrlDetails(new UrlDetails("http://MockResponse",2));
		Mockito.when(webCrawlerService.parse(Mockito.anyString(), Mockito.anyInt())).thenReturn(mockRresponse);
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/crawl").contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(mockRresponse))).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	public static String asJsonString(final WebCrawlerResponse response) throws JsonProcessingException {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(response);
	        return jsonContent;
	}  
}
