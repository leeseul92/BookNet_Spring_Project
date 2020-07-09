package com.pageturner.cls.vo;
/**
 *	이 클래스는 팔로우, 팔로워와 관련된 정보를 저장하는 VO이다.
 * @author	박기윤
 * @since	2020.06.24
 *
 */
import org.apache.ibatis.type.*;

@Alias("falVO")
public class FallowVO {
	private int fallow_no, fallower_no;
	private String id, sname, sloc, faldate, revck, ischeck;

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
	public String getIscheck() {
		return ischeck;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public String getRevck() {
		return revck;
	}
	public void setRevck(String revck) {
		this.revck = revck;
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
	@Override
	public String toString() {
		return "FallowVO [fallow_no=" + fallow_no + ", fallower_no=" + fallower_no + ", id=" + id + ", sname=" + sname
				+ ", sloc=" + sloc + ", faldate=" + faldate + ", revck=" + revck + ", ischeck=" + ischeck + "]";
	}
}
