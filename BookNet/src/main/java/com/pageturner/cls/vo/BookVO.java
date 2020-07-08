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
	private String bname, smallimg, largeimg, gname, publish,
					writer, trans, classify, isbn;
	private int genre, publish_no, bno, cat_id;
	public String getBname() {
		return bname;
	}
	public void setBname(String title) {
		this.bname = title;
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
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publisher) {
		this.publish = publisher;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String author) {
		this.writer = author;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String translator) {
		this.trans = translator;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int categoryId) {
		this.genre = categoryId;
	}
	public int getPublish_no() {
		return publish_no;
	}
	public void setPublish_no(int publish_no) {
		this.publish_no = publish_no;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	@Override
	public String toString() {
		return "BookVO [title=" + bname + ", smallimg=" + smallimg + ", largeimg=" + largeimg + ", gname=" + gname
				+ ", publisher=" + publish + ", author=" + writer + ", translator=" + trans + ", classify="
				+ classify + ", isbn=" + isbn + ", categoryId=" + genre + ", publish_no=" + publish_no + ", bno="
				+ bno + ", cat_id=" + cat_id + "]";
	}
}