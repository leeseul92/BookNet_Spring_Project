package com.pageturner.cls.vo;
/**
 * 	이 클래스는 추천도서의 기간과 정보를 저장할 VO 클래스이다.
 * @author	박기윤
 * @since	2020.07.03
 * @version	v.1.0
 * 
 */

import java.util.*;
import org.apache.ibatis.type.*;

@Alias("rcmdVO")
public class RecommendVO {
	private int recomdate_no, recom_no, bno, cat_id;
	private String classify, recomdate_start, recomdate_end;
	private HashMap map = new HashMap();
	public HashMap getMap() {
		return map;
	}
	public void setMap(HashMap map) {
		this.map = map;
		this.recomdate_no = Integer.parseInt((String)map.get("RECOMDATE_NO"));
		this.recomdate_start = (String)map.get("RECOMDATE_START");
		this.recomdate_end = (String)map.get("RECOMDATE_END");
	}
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
	@Override
	public String toString() {
		return "RecommendVO [recomdate_no=" + recomdate_no + ", recom_no=" + recom_no + ", bno=" + bno + ", cat_id="
				+ cat_id + ", classify=" + classify + ", recomdate_start=" + recomdate_start + ", recomdate_end="
				+ recomdate_end + ", map=" + map + "]";
	}
}
