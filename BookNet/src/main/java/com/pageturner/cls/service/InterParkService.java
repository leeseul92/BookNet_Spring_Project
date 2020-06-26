package com.pageturner.cls.service;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *  
 * @author leeseulkim
 * @since 25th Jun 2020
 *
 */

import org.springframework.stereotype.*;

import com.pageturner.cls.util.*;

@Service
public class InterParkService implements InterParkAPI {
	@Autowired
	SelectAPI selApiUtil;
	
	@Autowired
	WebConnection webConn;

	String address = null;
	String json = null;
	
	//게시글 작성시 도서검색 요청이 들어온 경우 
	public String interparkAPI(int categoryId, String keyword) {
		// TODO Auto-generated method stub
		String base = selApiUtil.selectAPI(SelectAPI.SEARCH);
		System.out.println("********");
		System.out.println(base);
		
		try {
			String str = URLEncoder.encode(keyword, "UTF-8");
			address = base + str + "&output=json&categoryId=" + categoryId;
			
			json = webConn.webConnection(address);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}

	@Override
	public void interparkAPI() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		InterParkService iapi = new InterParkService();
		iapi.interparkAPI(100, "코로나");
		System.out.println(iapi.json);
	}
}
