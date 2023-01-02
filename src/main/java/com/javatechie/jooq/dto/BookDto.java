package com.javatechie.jooq.dto;

public class BookDto {
	Integer Id;
	String title;
	String author;
	Integer row;
	Integer totalRows;
	Integer total_page;
	Integer current_page;
	Integer last_page;

	public BookDto(Integer id, String title, String author, Integer row, Integer totalRows, Integer total_page,
			Integer current_page, Integer last_page) {
		super();
		Id = id;
		this.title = title;
		this.author = author;
		this.row = row;
		this.totalRows = totalRows;
		this.total_page = total_page;
		this.current_page = current_page;
		this.last_page = last_page;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotal_page() {
		return total_page;
	}

	public void setTotal_page(Integer total_page) {
		this.total_page = total_page;
	}

	public Integer getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(Integer current_page) {
		this.current_page = current_page;
	}

	public Integer getLast_page() {
		return last_page;
	}

	public void setLast_page(Integer last_page) {
		this.last_page = last_page;
	}

}
