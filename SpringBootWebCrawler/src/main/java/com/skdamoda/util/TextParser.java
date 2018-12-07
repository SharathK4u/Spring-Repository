package com.skdamoda.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.skdamoda.model.UrlDetails;

/**
 * The Text Parser implements the BaseParser and parse the url to retrieve
 * all the urls embedded in the HTML page.
 * This should give a faster performance. But needs to consider all the corner cases.
 */
@Component("textParser")
public class TextParser implements BaseParser {

	@Override
	public List<UrlDetails> parse(String url, int level){
		List<UrlDetails> urlDetailsList = new ArrayList<UrlDetails>();
		try {
			URL uri = new URL(url);
			URLConnection connection = uri.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			urlDetailsList=reader.lines().filter(s->s.contains("<a")).map(line->trim(line,level,uri)).collect(Collectors.toList());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlDetailsList;
	}
	
	public UrlDetails trim(String line,int level,URL url) {
		line = line.substring(line.indexOf("href")+6, line.length());
		line=line.substring(0,line.indexOf('"'));
		String baseUrl = url.getProtocol()+"://"+url.getAuthority();
    	if(line.startsWith("/")) {
    		line=baseUrl+line;
    	}
		return new UrlDetails(line, level);
	}
	
	public static void main(String [] args) {
		TextParser parser = new TextParser();
		parser.parse("http://wiprodigital.com", 1);
	}

}
