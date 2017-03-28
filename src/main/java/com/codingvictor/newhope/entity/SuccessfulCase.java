package com.codingvictor.newhope.entity;

public class SuccessfulCase {
	private String id;
	private String author;
    private String publishedDate;
	private String modifiedDate;
    private String heading;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	@Override
	public String toString() {
		return "SuccessfulCase [id=" + id + ", author=" + author + ", publishedDate=" + publishedDate
				+ ", modifiedDate=" + modifiedDate + ", heading=" + heading + "]";
	}

}