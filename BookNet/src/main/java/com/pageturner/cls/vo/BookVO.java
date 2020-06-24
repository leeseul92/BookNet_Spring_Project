package com.pageturner.cls.vo;

import org.apache.ibatis.type.Alias;

/**
 * 	이 클래스는 도서 정보를 저장할 VO 클래스이다.
 * @author	박기윤
 * @since	2020.05.25
 *
 */

@Alias("bVO")
public class BookVO {
	private String title, saleStatus, cvrsUrl, cvrlUrl, publisher, author, translator, link, isbn;
	private int categoryId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}
	public String getCvrsUrl() {
		return cvrsUrl;
	}
	public void setCvrsUrl(String cvrsUrl) {
		this.cvrsUrl = cvrsUrl;
	}
	public String getCvrlUrl() {
		return cvrlUrl;
	}
	public void setCvrlUrl(String cvrlUrl) {
		this.cvrlUrl = cvrlUrl;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
