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
	private int pno, linkno, mno, eno, bno, cno, genre, hno, cnt;
	private String id, profile, postcont, pdate, largeimg, smallimg, bname, writer, trans, domain,
	 				hash, publish, emotion, cbody, comnt, cdate, gname, mention, sid, ischeck, likepost, keyword;
//	private Date postdate;
//	private Time posttime;
//	private MainVO mainVO;
	
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}
	public int getHno() {
		return hno;
	}
	public void setHno(int hno) {
		this.hno = hno;
	}
	public String getIscheck() {
		return ischeck;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getLikepost() {
		return likepost;
	}
	public void setLikepost(String likepost) {
		this.likepost = likepost;
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
				+ ", cno=" + cno + ", genre=" + genre + ", cnt=" + cnt + ", id=" + id + ", profile="
				+ profile + ", postcont=" + postcont + ", pdate=" + pdate + ", largeimg=" + largeimg + ", smallimg="
				+ smallimg + ", bname=" + bname + ", writer=" + writer + ", trans=" + trans + ", domain=" + domain
				+ ", hash=" + hash + ", publish=" + publish + ", emotion=" + emotion + ", cbody=" + cbody + ", comnt="
				+ comnt + ", cdate=" + cdate + ", gname=" + gname + ", sid=" + sid + ", ischeck=" + ischeck
				+ ", likepost=" + likepost + ", keyword=" + keyword + "]";
	}

}
