package com.pageturner.cls.vo;

/**
 * 회원정보 vo
 * @author 이명환
 * @since 2020.05.25
 * 
 */
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class MemberVO {
	private int mno;
	private String id, pw, name, nickname, birthdate, gen, mail, tel, interest, 
					describe, isshow, sdate, yy, mm, dd, intershow, birthshow, genshow, isinflu,
					ori_name, save_name, save_loc;
	private Date mdate;
	private Time mtime;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		this.birthdate = form1.format(mdate) + " " + form2.format(mtime);
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getYy() {
		return yy;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public Time getMtime() {
		return mtime;
	}
	public void setMtime(Time mtime) {
		this.mtime = mtime;
	}
	public String getIntershow() {
		return intershow;
	}
	public void setIntershow(String intershow) {
		this.intershow = intershow;
	}
	public String getBirthshow() {
		return birthshow;
	}
	public void setBirthshow(String birthshow) {
		this.birthshow = birthshow;
	}
	public String getGenshow() {
		return genshow;
	}
	public void setGenshow(String genshow) {
		this.genshow = genshow;
	}
	public String getIsinflu() {
		return isinflu;
	}
	public void setIsinflu(String isinflu) {
		this.isinflu = isinflu;
	}
	public String getOri_name() {
		return ori_name;
	}
	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}
	public String getSave_name() {
		return save_name;
	}
	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}
	public String getSave_loc() {
		return save_loc;
	}
	public void setSave_loc(String save_loc) {
		this.save_loc = save_loc;
	}
}
