package com.pageturner.cls.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 	이 클래스는 책과 관련된 작업을 수행할 서비스 클래스이다.
 * @author	박기윤
 * @since	2020.07.02
 * @version	v.1.0
 * 
 */
import org.springframework.stereotype.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service
public class BookService {
	@Autowired
	BookDAO bookDAO;
	
	public void addBookData(BookVO bVO) {
		int ckPb = 0;
		int ckBk = 0;
		
		ckPb = bookDAO.checkPublish(bVO);
		if(ckPb == 0) {
			bookDAO.addPublish(bVO);
		}
		
		ckBk = bookDAO.checkBook(bVO);
		if(ckBk == 0) {
			bookDAO.addBook(bVO);
		}
	}
	
	public void name() {
		RecommendVO rcmdVO = new RecommendVO();
		bookDAO.addPeriod(rcmdVO);
	}
	
	public void addRecommend(RecommendVO rcmdVO) {
//		bookDAO.addPeriod();
		bookDAO.addRcmdBook(rcmdVO);
	}
}