package com.ozguryazilim.business.dto;

import java.util.List;

import com.ozguryazilim.data.entity.Book;

public class WriterDto {
	private long writerId;
	private String writerName;
	private String writerDescription;
	private String writerSurname;
	private List<Book> list;

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

	public String getWriterDescription() {
		return writerDescription;
	}

	public void setWriterDescription(String writerDescription) {
		this.writerDescription = writerDescription;
	}

	public String getWriterSurname() {
		return writerSurname;
	}

	public void setWriterSurname(String writerSurname) {
		this.writerSurname = writerSurname;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

}
