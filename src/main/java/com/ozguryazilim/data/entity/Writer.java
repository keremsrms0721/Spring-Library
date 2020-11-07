package com.ozguryazilim.data.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Writer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long writerId;
	private String writerName;
	private String writerDescription;
	private String writerSurname;
	@OneToMany(mappedBy = "writer",cascade = CascadeType.ALL)
	private List<Book> list;

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
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

}
