package com.pageturner.cls.service;
/**
 * 이 클래스는 검색 결과를 처리할 클래스입니다.
 * @author 서동혁
 * @since 2020-06-25
 * @version v.1.0
 *
 */

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageturner.cls.dao.SearchDAO;
import com.pageturner.cls.vo.*;

@Service
public class SearchService {
	
	@Autowired
	SearchDAO sDAO;
	// DAO 받아오기
	public List<SearchVO> searchKey(String keyword){
		System.out.println("###  SearchService : DAO");
			List<SearchVO> key = sDAO.searchAll(keyword);
			System.out.println("##### Service key.size : " + key.size());
		return key;
	}
	
}
