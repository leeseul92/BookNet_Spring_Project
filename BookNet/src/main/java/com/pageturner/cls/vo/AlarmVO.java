package com.pageturner.cls.vo;
/**
 *	이 클래스는 알람 내용을 저장할 VO 클래스이다.
 *	@author	박기윤
 *	@since	2020.06.24
 */
import org.apache.ibatis.type.*;

@Alias("alVO")
public class AlarmVO {
	private String type, extime, bname, id, save_name, save_loc, dday;
	private int pno;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getExtime() {
		return extime;
	}
	public void setExtime(String extime) {
		this.extime = extime;
	}
	public String getDday() {
		return dday;
	}
	public void setDday(String dday) {
		this.dday = dday;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
}