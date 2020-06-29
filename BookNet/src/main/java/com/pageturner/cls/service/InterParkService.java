package com.pageturner.cls.service;

/**
 * 이 클래스는 도서검색, 베스트셀러, 추천도서 등 controller로부터 들어온 로직을 처리할 서비스클래스입니다.
 * @author leeseulkim
 * @since 25th Jun 2020
 *
 */
import java.net.URLEncoder;
import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;

import com.google.gson.*;
import com.pageturner.cls.util.*;
import com.pageturner.cls.vo.*;
import com.pageturner.cls.dao.*;

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
	public String interparkAPI(int categoryId, String keyword) {
		// TODO Auto-generated method stub
		String base = selApi.selectUrl(selApi.SEARCH);
		
		try {
			//api에서부터 가져온 도서정보를 gson으로 받기 
			String str = URLEncoder.encode(keyword, "UTF-8");
			address = base + str + "&output=json&maxResults=30&categoryId=" + categoryId;

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
		iapi.interparkAPI(100, "코로나");
//		for(BookVO bVO : iapi.list) {
//			System.out.println(bVO.toString());
//		}
		System.out.println(iapi.json);
	}
}
