package com.pam.newsproget.model;

import java.util.List;

public class Links{
	private List<CuriesItem> curies;
	private List<RepliesItem> replies;
	private List<VersionHistoryItem> versionHistory;
	private List<AuthorItem> author;
	private List<WpTermItem> wpTerm;
	private List<AboutItem> about;
	private List<SelfItem> self;
	private List<PredecessorVersionItem> predecessorVersion;
	private List<WpFeaturedmediaItem> wpFeaturedmedia;
	private List<CollectionItem> collection;
	private List<WpAttachmentItem> wpAttachment;

	public List<CuriesItem> getCuries(){
		return curies;
	}

	public List<RepliesItem> getReplies(){
		return replies;
	}

	public List<VersionHistoryItem> getVersionHistory(){
		return versionHistory;
	}

	public List<AuthorItem> getAuthor(){
		return author;
	}

	public List<WpTermItem> getWpTerm(){
		return wpTerm;
	}

	public List<AboutItem> getAbout(){
		return about;
	}

	public List<SelfItem> getSelf(){
		return self;
	}

	public List<PredecessorVersionItem> getPredecessorVersion(){
		return predecessorVersion;
	}

	public List<WpFeaturedmediaItem> getWpFeaturedmedia(){
		return wpFeaturedmedia;
	}

	public List<CollectionItem> getCollection(){
		return collection;
	}

	public List<WpAttachmentItem> getWpAttachment(){
		return wpAttachment;
	}
}