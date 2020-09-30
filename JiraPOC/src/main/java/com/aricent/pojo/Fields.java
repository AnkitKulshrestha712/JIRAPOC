package com.aricent.pojo;

public class Fields {

	private Comment comment;
	private Project project;
	private String summary;
	private String description;
	private Issuetype issuetype;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public Issuetype getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(Issuetype issuetype) {
		this.issuetype = issuetype;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
	
}
