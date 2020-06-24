package com.pageturner.cls.vo;
/**
 *	이 클래스는 팔로우, 팔로워와 관련된 정보를 저장하는 VO이다.
 * @author	박기윤
 * @since	2020.06.24
 *
 */

import java.sql.*;
import java.text.*;
import org.apache.ibatis.type.*;

@Alias("falVO")
public class FallowVO {
	private int fallow_no, fallower_no;
	private String id, sname, sloc, faldate, ischeck;
	private Date fDate;
	private Time fTime;

	public int getFallow_no() {
		return fallow_no;
	}
	public void setFallow_no(int fallow_no) {
		this.fallow_no = fallow_no;
	}
	public int getFallower_no() {
		return fallower_no;
	}
	public void setFallower_no(int fallower_no) {
		this.fallower_no = fallower_no;
	}
	public String getFaldate() {
		return faldate;
	}
	public void setFaldate(String faldate) {
		this.faldate = faldate;
	}
	public void setFaldate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm:ss");
		this.faldate = form1.format(fDate) + " " + form2.format(fTime);
	}
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public Date getfDate() {
		return fDate;
	}
	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}
	public Time getfTime() {
		return fTime;
	}
	public void setfTime(Time fTime) {
		this.fTime = fTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String nickname) {
		this.id = nickname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSloc() {
		return sloc;
	}
	public void setSloc(String sloc) {
		this.sloc = sloc;
	}
}
