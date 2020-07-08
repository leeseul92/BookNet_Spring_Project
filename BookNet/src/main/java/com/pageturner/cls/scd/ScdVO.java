package com.pageturner.cls.scd;

/**
 * 이 클래스는 추천도서 및 베스트셀러로 저장될 도서의 정보와 기간을
 * 저장하는 VO 클래스이다.
 * @author	박기윤
 * @since	2020.07.07
 * @version	v.1.0
 */

import org.apache.ibatis.type.*;

@Alias("scdVO")
public class ScdVO {
	private int recomdate_no,recom_no,bno,cat_id;
	private String recomdate_start, recomdate_end;
	private char classify;
	public int getRecomdate_no() {
		return recomdate_no;
	}
	public void setRecomdate_no(int recomdate_no) {
		this.recomdate_no = recomdate_no;
	}
	public int getRecom_no() {
		return recom_no;
	}
	public void setRecom_no(int recom_no) {
		this.recom_no = recom_no;
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
	public String getRecomdate_start() {
		return recomdate_start;
	}
	public void setRecomdate_start(String recomdate_start) {
		this.recomdate_start = recomdate_start;
	}
	public String getRecomdate_end() {
		return recomdate_end;
	}
	public void setRecomdate_end(String recomdate_end) {
		this.recomdate_end = recomdate_end;
	}
	public char getClassify() {
		return classify;
	}
	public void setClassify(char classify) {
		this.classify = classify;
	}
	@Override
	public String toString() {
		return "ScdVO [recomdate_no=" + recomdate_no + ", recom_no=" + recom_no + ", bno=" + bno + ", cat_id=" + cat_id
				+ ", recomdate_start=" + recomdate_start + ", recomdate_end=" + recomdate_end + ", classify=" + classify
				+ "]";
	}
}
