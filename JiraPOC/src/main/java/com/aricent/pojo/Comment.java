package com.aricent.pojo;

import java.util.List;

public class Comment {

	private List<String> comments;
	private int maxResults;
	private int total;
	private int startAt;
	
	public List<String> getComments() {
		return comments;
	}
	
	public void setComments(List<String> comments) {
		this.comments = comments;
	}
	
	public int getMaxResults() {
		return maxResults;
	}
	
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getStartAt() {
		return startAt;
	}
	
	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}
}