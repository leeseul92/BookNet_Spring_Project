package com.pageturner.cls.vo;

/**
 * 이 클래스는 메인화면과 관련된 변수들의 vo 클래스입니다.
 * @author leeseulkim
 * @since 10th Jun 2020
 * 
 */
import java.sql.Date;
import java.sql.Time;

import org.apache.ibatis.type.Alias;

@Alias("mainVO")
public class MainVO {
	private int pno, mno, eno, bno, cnt;
	private String id, profile, bname, writer, trans, largeimg, 
					gname, postcont, pdate, ptime, hash, publish, ischeck, emotion;
	private Date postdate;
	private Time posttime;
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String getLargeimg() {
		return largeimg;
	}
	public void setLargeimg(String largeimg) {
		this.largeimg = largeimg;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getPostcont() {
		return postcont;
	}
	public void setPostcont(String postcont) {
		this.postcont = postcont;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public Time getPosttime() {
		return posttime;
	}
	public void setPosttime(Time posttime) {
		this.posttime = posttime;
	}
	
	
}
