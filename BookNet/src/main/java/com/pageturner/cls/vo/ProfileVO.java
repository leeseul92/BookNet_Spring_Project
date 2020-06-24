package com.pageturner.cls.vo;

import org.apache.ibatis.type.Alias;

@Alias("fVO")
public class ProfileVO {
	private int pf_pt_no, mno;
	private String ori_name, save_name, save_loc, pf_date, pf_time;
	public int getPf_pt_no() {
		return pf_pt_no;
	}
	public void setPf_pt_no(int pf_pt_no) {
		this.pf_pt_no = pf_pt_no;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
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
	public String getPf_date() {
		return pf_date;
	}
	public void setPf_date(String pf_date) {
		this.pf_date = pf_date;
	}
	public String getPf_time() {
		return pf_time;
	}
	public void setPf_time(String pf_time) {
		this.pf_time = pf_time;
	}
}
