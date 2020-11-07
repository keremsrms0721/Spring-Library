package com.ozguryazilim.business.dto;

public class BookDto {

	private long bookId;
	private String bookName;
	private String seriesName;
	private long isbn;
	private String description;

	private long publisherId;
	private String publisherName;
	private String publisherDescription;

	private long writerId;
	private String writerName;
	private String writerSurname;
	private String writerDescription;

	public String getWriterSurname() {
		return writerSurname;
	}

	public void setWriterSurname(String writerSurname) {
		this.writerSurname = writerSurname;
	}

	public String getWriterDescription() {
		return writerDescription;
	}

	public void setWriterDescription(String writerDescription) {
		this.writerDescription = writerDescription;
	}

	public String getPublisherDescription() {
		return publisherDescription;
	}

	public void setPublisherDescription(String publisherDescription) {
		this.publisherDescription = publisherDescription;
	}

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

	public long getWriterId() {
		return writerId;
	}

	public void setWriterId(long writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
