package com.pageturner.cls.vo;

import org.apache.ibatis.type.Alias;

@Alias("rcmdVO")
public class RecommandVO {
	private int recomdate_no, recom_no, bno;
	private String classify, recomdate_start, recomdate_end;
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
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
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
}
