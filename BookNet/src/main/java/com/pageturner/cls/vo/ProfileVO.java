package com.pageturner.cls.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("fVO")
public class ProfileVO {
	private int pf_pt_no, mno;
	private String id, ori_name, save_name, pf_date, pf_time;
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "ProfileVO [pf_pt_no=" + pf_pt_no + ", mno=" + mno + ", ori_name=" + ori_name + ", save_name="
				+ save_name + ", pf_date=" + pf_date + ", pf_time=" + pf_time + ", file="
				+ file + "]";
	}
}
