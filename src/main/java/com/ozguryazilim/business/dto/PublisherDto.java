package com.ozguryazilim.business.dto;

import java.util.List;

import com.ozguryazilim.data.entity.Book;

public class PublisherDto {
	private long publisherId;
	private String publisherName;
	private String publisherDescription;
	private List<Book> list;

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherDescription() {
		return publisherDescription;
	}

	public void setPublisherDescription(String publisherDescription) {
		this.publisherDescription = publisherDescription;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

}
