package com.pam.newsprojet.model;

import java.util.Date;
import java.util.List;
public class PostItem {
	private Date date;
	private String template;
	private String modifiedGmt;
	private Links links;
	private int author;
	private String link;
	private String format;
	private String type;
	private Title title;
	private String commentStatus;
	private Content content;
	private int featuredMedia;
	private List<Integer> tags;
	private String pingStatus;
	private List<Object> meta;
	private boolean sticky;
	private Guid guid;
	private String modified;
	private int id;
	private List<Integer> categories;
	private Excerpt excerpt;
	private String dateGmt;
	private String slug;
	private String status;

	public Date getDate(){
		return date;
	}

	public String getTemplate(){
		return template;
	}

	public String getModifiedGmt(){
		return modifiedGmt;
	}

	public Links getLinks(){
		return links;
	}

	public int getAuthor(){
		return author;
	}

	public String getLink(){
		return link;
	}

	public String getFormat(){
		return format;
	}

	public String getType(){
		return type;
	}

	public Title getTitle(){
		return title;
	}

	public String getCommentStatus(){
		return commentStatus;
	}

	public Content getContent(){
		return content;
	}

	public int getFeaturedMedia(){
		return featuredMedia;
	}

	public List<Integer> getTags(){
		return tags;
	}

	public String getPingStatus(){
		return pingStatus;
	}

	public List<Object> getMeta(){
		return meta;
	}

	public boolean isSticky(){
		return sticky;
	}

	public Guid getGuid(){
		return guid;
	}

	public String getModified(){
		return modified;
	}

	public int getId(){
		return id;
	}

	public List<Integer> getCategories(){
		return categories;
	}

	public Excerpt getExcerpt(){
		return excerpt;
	}

	public String getDateGmt(){
		return dateGmt;
	}

	public String getSlug(){
		return slug;
	}

	public String getStatus(){
		return status;
	}
}