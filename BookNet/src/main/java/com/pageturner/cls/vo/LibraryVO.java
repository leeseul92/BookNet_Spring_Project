package com.pageturner.cls.vo;

import org.apache.ibatis.type.Alias;

/**
 * 도서관 검색 API에 대한 VO.
 * @author 서동혁
 * @since 2020-06-30
 */
@Alias("libVO")
public class LibraryVO {
	private String lbrry_name, gu_code, code_value, adres, tel_no, fxnum, hmpg_url, op_time, fdrm_close_date, lbrry_se_name, charger_email, lbrry_intrcn, mber_sbscrbroqisit, longdcc, tfcmn,floor_dc ;
	// 도서관 일렬번호, 위도, 경도, 설립연도
	private Double lbrry_seq_no, xcnts, ydnts,fond_year;
	
	
	public Double getLbrry_seq_no() {
		return lbrry_seq_no;
	}
	public void setLbrry_seq_no(Double lbrry_seq_no) {
		this.lbrry_seq_no = lbrry_seq_no;
	}
	public String getLbrry_name() {
		return lbrry_name;
	}
	public void setLbrry_name(String lbrry_name) {
		this.lbrry_name = lbrry_name;
	}
	public String getGu_code() {
		return gu_code;
	}
	public void setGu_code(String gu_code) {
		this.gu_code = gu_code;
	}
	public String getCode_value() {
		return code_value;
	}
	public void setCode_value(String code_value) {
		this.code_value = code_value;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	public String getFxnum() {
		return fxnum;
	}
	public void setFxnum(String fxnum) {
		this.fxnum = fxnum;
	}
	public String getHmpg_url() {
		return hmpg_url;
	}
	public void setHmpg_url(String hmpg_url) {
		this.hmpg_url = hmpg_url;
	}
	public String getOp_time() {
		return op_time;
	}
	public void setOp_time(String op_time) {
		this.op_time = op_time;
	}
	public String getFdrm_close_date() {
		return fdrm_close_date;
	}
	public void setFdrm_close_date(String fdrm_close_date) {
		this.fdrm_close_date = fdrm_close_date;
	}
	public String getLbrry_se_name() {
		return lbrry_se_name;
	}
	public void setLbrry_se_name(String lbrry_se_name) {
		this.lbrry_se_name = lbrry_se_name;
	}
	public String getCharger_email() {
		return charger_email;
	}
	public void setCharger_email(String charger_email) {
		this.charger_email = charger_email;
	}
	public String getLbrry_intrcn() {
		return lbrry_intrcn;
	}
	public void setLbrry_intrcn(String lbrry_intrcn) {
		this.lbrry_intrcn = lbrry_intrcn;
	}
	public String getMber_sbscrbroqisit() {
		return mber_sbscrbroqisit;
	}
	public void setMber_sbscrbroqisit(String mber_sbscrbroqisit) {
		this.mber_sbscrbroqisit = mber_sbscrbroqisit;
	}
	public String getLongdcc() {
		return longdcc;
	}
	public void setLongdcc(String longdcc) {
		this.longdcc = longdcc;
	}
	public String getTfcmn() {
		return tfcmn;
	}
	public void setTfcmn(String tfcmn) {
		this.tfcmn = tfcmn;
	}
	public String getFloor_dc() {
		return floor_dc;
	}
	public void setFloor_dc(String floor_dc) {
		this.floor_dc = floor_dc;
	}
	public Double getXcnts() {
		return xcnts;
	}
	public void setXcnts(Double xcnts) {
		this.xcnts = xcnts;
	}
	public Double getYdnts() {
		return ydnts;
	}
	public void setYdnts(Double ydnts) {
		this.ydnts = ydnts;
	}
	public Double getFond_year() {
		return fond_year;
	}
	public void setFond_year(Double fond_year) {
		this.fond_year = fond_year;
	}
	@Override
	public String toString() {
		return "LibraryVO [lbrry_name=" + lbrry_name + ", gu_code=" + gu_code + ", code_value=" + code_value
				+ ", adres=" + adres + ", tel_no=" + tel_no + ", fxnum=" + fxnum + ", hmpg_url=" + hmpg_url
				+ ", op_time=" + op_time + ", fdrm_close_date=" + fdrm_close_date + ", lbrry_se_name=" + lbrry_se_name
				+ ", charger_email=" + charger_email + ", lbrry_intrcn=" + lbrry_intrcn + ", mber_sbscrbroqisit="
				+ mber_sbscrbroqisit + ", longdcc=" + longdcc + ", tfcmn=" + tfcmn + ", floor_dc=" + floor_dc
				+ ", lbrry_seq_no=" + lbrry_seq_no + ", xcnts=" + xcnts + ", ydnts=" + ydnts + ", fond_year="
				+ fond_year + "]";
	}
}
