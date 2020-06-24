package com.pageturner.cls.vo;

/**
 * 이 클래스는 메인화면과 관련된 변수들의 vo 클래스입니다.
 * @author leeseulkim
 * @since 10th Jun 2020
 * @see
 * 		PostsVO
 * 
 */
import java.sql.Date;
import java.sql.Time;

import org.apache.ibatis.type.Alias;

@Alias("mainVO")
public class MainVO {
	private String bname, writer, trans, hash, publish;
//	private Date postdate;
//	private Time posttime;

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
	@Override
	public String toString() {
		return "MainVO [bname=" + bname + ", writer=" + writer + ", trans=" + trans + ", hash=" + hash + ", publish="
				+ publish + "]";
	}
	
}

