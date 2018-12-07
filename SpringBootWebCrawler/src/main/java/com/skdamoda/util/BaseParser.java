package com.skdamoda.util;

import java.util.List;

import com.skdamoda.exception.WebCrawlerException;
import com.skdamoda.model.UrlDetails;;

public interface BaseParser {
	public List<UrlDetails> parse(String url,int level)  throws WebCrawlerException;

}
