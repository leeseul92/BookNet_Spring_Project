package com.pageturner.cls.vo;
/**
 * 	이 클래스는 도서 정보를 저장할 VO 클래스이다.
 * @author	박기윤
 * @since	2020.06.24
 *
 */
import org.apache.ibatis.type.*;

@Alias("bVO")
public class BookVO {
	private String title, smallimg, largeimg, gname, publisher,
					author, translator, link, isbn;
	private int categoryId, publish_no;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSmallimg() {
		return smallimg;
	}
	public void setSmallimg(String cvrsUrl) {
		this.smallimg = cvrsUrl;
	}
	public String getLargeimg() {
		return largeimg;
	}
	public void setLargeimg(String cvrlUrl) {
		this.largeimg = cvrlUrl;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
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
	public int getPublish_no() {
		return publish_no;
	}
	public void setPublish_no(int publish_no) {
		this.publish_no = publish_no;
	}
	
	
}
