package com.skdamoda.model;

import java.util.ArrayList;
import java.util.List;

public class UrlDetails implements Comparable<UrlDetails>{
	
	private String url;
	private int level;
	private List<UrlDetails> childUrlDetails = new ArrayList<UrlDetails>();
	
	public UrlDetails() {
		super();
	}
	
	public UrlDetails(String url, int level){
		this.url=url;
		this.level=level;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public List<UrlDetails> getChildUrlDetails() {
		return childUrlDetails;
	}
	public void addChildUrlDetails(UrlDetails urlDetails) {
		childUrlDetails.add(urlDetails);
	}
	public void addChildUrlDetailsList(List<UrlDetails> urlDetailsList) {
		childUrlDetails.addAll(urlDetailsList);
	}

	@Override
	public int compareTo(UrlDetails urlDetails) {
		return this.url.compareTo(urlDetails.getUrl());
	}
	
	@Override
	public String toString() {
		return "url : "+this.url+" | level : "+level;
	}
}
