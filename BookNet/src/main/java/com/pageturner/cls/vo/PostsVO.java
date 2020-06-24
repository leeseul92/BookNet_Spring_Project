package com.pageturner.cls.vo;
/**
 * 이 클래스는 게시물과 관련한 변수들의 vo 클래스입니다.
 * @author leeseulkim
 * @since 13th Jun 2020
 * @see
 * 		MainVO
 *
 */

import java.sql.Date;
import java.sql.Time;

import org.apache.ibatis.type.Alias;

@Alias("pVO")
public class PostsVO {
	private int pno, linkno, mno, eno, bno, cno, genre, cnt;
	private String id, profile, postcont, pdate, largeimg, smallimg,
				emotion, cbody, comnt, cdate, gname, sid, ischeck;
//	private Date postdate;
//	private Time posttime;
	private MainVO mainVO;
	
	public MainVO getMainVO() {
		return mainVO;
	}
	public void setMainVO(MainVO mainVO) {
		this.mainVO = mainVO;
	}
	public String getIscheck() {
		return ischeck;
	}
	public String getSmallimg() {
		return smallimg;
	}
	public void setSmallimg(String smallimg) {
		this.smallimg = smallimg;
	}
	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getGenre() {
		return genre;
	}
	public void setGenre(int genre) {
		this.genre = genre;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getComnt() {
		return comnt;
	}
	public void setComnt(String comnt) {
		this.comnt = comnt;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getLinkno() {
		return linkno;
	}
	public void setLinkno(int linkno) {
		this.linkno = linkno;
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
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
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
	public String getPostcont() {
		return postcont;
	}
	public void setPostcont() {
		this.postcont = postcont.replaceAll("\r\n", "<br>");
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
	public String getLargeimg() {
		return largeimg;
	}
	public void setLargeimg(String largeimg) {
		this.largeimg = largeimg;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public String getCbody() {
		return cbody;
	}
	public void setCbody(String cbody) {
		this.cbody = cbody;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	@Override
	public String toString() {
		return "PostsVO [pno=" + pno + ", linkno=" + linkno + ", mno=" + mno + ", eno=" + eno + ", bno=" + bno
				+ ", cno=" + cno + ", genre=" + genre + ", cnt=" + cnt + ", id=" + id + ", profile=" + profile
				+ ", postcont=" + postcont + ", pdate=" + pdate + ", largeimg=" + largeimg + ", smallimg=" + smallimg
				+ ", emotion=" + emotion + ", cbody=" + cbody + ", comnt=" + comnt + ", cdate=" + cdate + ", gname="
				+ gname + ", sid=" + sid + ", ischeck=" + ischeck + ", mainVO=" + mainVO + "]";
	}
}
