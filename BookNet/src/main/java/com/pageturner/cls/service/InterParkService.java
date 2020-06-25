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
	
	//게시글 작성시 도서검색 요청이 들어온 경우 
	public String interparkAPI(int categoryId, String keyword) {
		// TODO Auto-generated method stub
		String address = null;
		String base = selApiUtil.selectAPI(selApiUtil.SEARCH);
		
		try {
			String str = URLEncoder.encode(keyword, "UTF-8");
			address = base + str + "&output=json&categoryId=" + categoryId;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return address;
	}

	@Override
	public void interparkAPI() {
		// TODO Auto-generated method stub
		
	}
}
