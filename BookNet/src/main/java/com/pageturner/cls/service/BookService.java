package com.pageturner.cls.service;

/**
 * 	이 클래스는 책과 관련된 작업을 수행할 서비스 클래스이다.
 * @author	박기윤
 * @since	2020.07.02
 * @version	v.1.0
 * 
 */

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service("bSrvc")
public class BookService {
	@Autowired
	BookDAO bookDAO;
	@Autowired
	InterParkService interparkSrvc;
	
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
}