package com.pam.newsprojet.model;

public class WpTermItem{
	private String taxonomy;
	private String href;
	private boolean embeddable;

	public String getTaxonomy(){
		return taxonomy;
	}

	public String getHref(){
		return href;
	}

	public boolean isEmbeddable(){
		return embeddable;
	}
}
