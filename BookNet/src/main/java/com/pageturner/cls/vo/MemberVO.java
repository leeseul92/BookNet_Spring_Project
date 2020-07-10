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

import org.apache.ibatis.type.Alias;

@Alias("mVO")
public class MemberVO {
	private int mno;
	private String id, pw, name, birthdate, gen, mail, interest,
					describe, isshow, sdate, intershow, birthshow, genshow, isinflu,
					ori_name, save_name, save_loc;
	
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
	public String getBirthdate() {
		return birthdate;
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
	
	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", id=" + id + ", pw=" + pw + ", name=" + name + ", birthdate=" + birthdate
				+ ", gen=" + gen + ", mail=" + mail + ", interest=" + interest + ", describe=" + describe + ", isshow="
				+ isshow + ", sdate=" + sdate + ", intershow=" + intershow + ", birthshow=" + birthshow + ", genshow="
				+ genshow + ", isinflu=" + isinflu + ", ori_name=" + ori_name + ", save_name=" + save_name
				+ ", save_loc=" + save_loc + "]";
	}
}
