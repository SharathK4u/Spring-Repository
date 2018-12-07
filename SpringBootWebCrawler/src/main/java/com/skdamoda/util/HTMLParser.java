package com.skdamoda.util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.skdamoda.exception.WebCrawlerException;
import com.skdamoda.model.UrlDetails;

/**
 * The HTML Parser implements the BaseParser and parse the url to retrieve
 * all the urls embedded in the HTML page.
 * We are using JSoup HTML Parser for easily retrieving the details
 */
@Component("htmlParser")
public class HTMLParser implements BaseParser {
	
	public List<UrlDetails> parse(String url, int level) throws WebCrawlerException{
		List<UrlDetails> urlDetailsList = new ArrayList<UrlDetails>();
		Document doc;
        try {
            //Using Jsoup to parse the html
        	doc = Jsoup.connect(url).get();
        	//Getting all the links
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                // get the url and set it to the url list
            	String href = link.attr("href");
            	URL uri = new URL(url);
            	String baseUrl = uri.getProtocol()+"://"+uri.getAuthority();
            	if(href.startsWith("/") || href.startsWith("#")) {
            		href=baseUrl+href;
            	}
            	if(href.contains(baseUrl)) {
	            	UrlDetails urlDetails = new UrlDetails(href,level);
	            	urlDetailsList.add(urlDetails);
            	}
            }
        }catch(IllegalArgumentException e) {
        	//Ideally should log the issue and continue with crawling.
        	//Rethrowing it for demonstration purpose.
        	throw new WebCrawlerException("INVALID_URL",e.getMessage());
        }catch (IOException e) {
            throw new WebCrawlerException("PARSING_ERROR",e.getMessage());
        } 
        return urlDetailsList;
	}

}
