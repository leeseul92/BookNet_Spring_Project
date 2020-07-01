package com.pageturner.cls.util;

/**
 * 이 클래스는 도서 api의 종류에 따른 코드를 만들어, 원하는 주소값을 정의한 클래스입니다.
 * @author leeseulkim
 * @since 25th Jun 2020
 * @version v.1.0
 *
 */

public class SelectAPI {
	private final String KEY = "756476FCE177C662B901F60050D436CDFFDF8BCC7C44966D95B67471225CF8EF"; //인터파크 API를 위한 KEY 값
	public final int SEARCH = 1001;
	public final int RECOMM = 1002;
	public final int BESTSELL = 1003;
	
	
	public String selectUrl(int code) {
		String api = null;
		String query = null;
		String base;
		switch(code) {
		case SEARCH:
			api = "http://book.interpark.com/api/search.api";
			query = "query";
			break;
		case RECOMM:
			api = "http://book.interpark.com/api/recommend.api";
			query = "categoryId";
			break;
		case BESTSELL:
			api = "http://book.interpark.com/api/bestSeller.api";
			query = "categoryId";
			break;
		}
		
		base = api + "?key=" + KEY + "&" + query + "=";
		return base;
	}

}
