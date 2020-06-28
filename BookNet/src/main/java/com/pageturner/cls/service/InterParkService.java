package com.pageturner.cls.service;

/**
 *  
 * @author leeseulkim
 * @since 25th Jun 2020
 *
 */
import java.net.URLEncoder;
import java.util.*;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.JsonArray;
import com.pageturner.cls.util.*;
import com.pageturner.cls.vo.*;

@Service
public class InterParkService implements InterParkAPI {
	SelectAPI selApi;
	WebConnection webConn;
	ParsingBookInfo parsing;

	String address = null;
	String json = null;
	ArrayList<BookVO> list;
	
	public InterParkService() {
		selApi = new SelectAPI();
		webConn = new WebConnection();
		parsing = new ParsingBookInfo();
		
	}//Default Constructor
	
	//게시글 작성시 도서검색 요청이 들어온 경우 
	@Override
	public String interparkAPI(int code, int categoryId, String keyword) {
		// TODO Auto-generated method stub
		String base = selApi.selectUrl(code);
		System.out.println(base);
		
		try {
			//api에서부터 가져온 도서정보를 gson으로 받기 
			String str = URLEncoder.encode(keyword, "UTF-8");
			address = base + str + "&output=json&categoryId=" + categoryId;

			json = webConn.webConnection(address);
			
			//웹에서 받아온 도서정보를 파싱시켜줄 클래스 호출
			this.list = parsing.parsingBookInfo(json);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//검색된 결과를 db에 저장시켜줄 처리전담 dao 호출 
		
		return json;
	}
	
	//데이터 파싱이 완료되었는지 확인용 main
	public static void main(String[] args) {
		InterParkService iapi = new InterParkService();
		iapi.interparkAPI(SelectAPI.SEARCH, 100, "코로나");
		for(BookVO bVO : iapi.list) {
			System.out.println(bVO.toString());
		}
	}
}
