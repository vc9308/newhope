package com.codingvictor.newhope.entity;

public class Activity {
	private int id;
	private String author;
    private String publishedDate;
	private String modifiedDate;
    private String heading;
    private String content;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Activity [id=" + id + ", author=" + author + ", publishedDate=" + publishedDate + ", modifiedDate="
				+ modifiedDate + ", heading=" + heading + ", content=" + content + "]";
	}
    
}
