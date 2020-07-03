package com.pageturner.cls.vo;

/**
 * 좋아요 vo
 * @author	이명환
 * @since	2020.07.03
 *
 */

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import org.apache.ibatis.type.Alias;

@Alias("lVO")
public class LikeVO {
	private int lk_no, pno, mno;
	private String ischeck, liketime;
	Date lDate;
	Time lTime;
	public int getLk_no() {
		return lk_no;
	}
	public void setLk_no(int lk_no) {
		this.lk_no = lk_no;
	}
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
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public String getLiketime() {
		return liketime;
	}
	public void setLiketime() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.liketime = form1.format(lDate) + " " + form2.format(lTime);
	}
	public void setLiketime(String liketime) {
		this.liketime = liketime;
	}
	public Date getlDate() {
		return lDate;
	}
	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}
	public Time getlTime() {
		return lTime;
	}
	public void setlTime(Time lTime) {
		this.lTime = lTime;
	}
	
	@Override
	public String toString() {
		return "LikeVO [lk_no=" + lk_no + ", pno=" + pno + ", mno=" + mno + ", ischeck=" + ischeck + ", liketime="
				+ liketime + ", lDate=" + lDate + ", lTime=" + lTime + "]";
	}
}
