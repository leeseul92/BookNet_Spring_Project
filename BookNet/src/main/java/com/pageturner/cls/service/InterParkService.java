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
	@Autowired
	SelectAPI selApi;
	
	@Autowired
	WebConnection webConn;
	
	@Autowired
	ParsingBookInfo parsing;

	String address = null;
	String json = null;
	String jStr = null;
	ArrayList<BookVO> list;
	
	//게시글 작성시 도서검색 요청이 들어온 경우 
	@Override
	public void interparkAPI(int categoryId, String keyword) {
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
		
	}
	
	//베스트셀러 
	public ArrayList<BookVO> interparkAPI(int categoryId) {
		String base = selApi.selectUrl(selApi.BESTSELL);//이때 base는 categoryId= 로 마무리 되어 있음.
		
		try {
			address = base + categoryId + "&output=json&maxResults=5";
			
			json = webConn.webConnection(address);
			
//			this.list = parsing.parsingBookInfo(json);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
