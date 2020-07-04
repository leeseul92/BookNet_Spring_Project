package com.pageturner.cls.service;

/**
 * 	이 클래스는 스케줄러에서 구동할 작업을 기술한
 * 	서비스 클래스이다.
 * @author	박기윤
 * @since	2020.07.04
 * @version	v.1.0
 */

import org.springframework.stereotype.*;
import java.util.*;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service
public class SchedulerService {
	@Autowired
	BookDAO bDAO;
	@Autowired
	BookService bSrvc;
	@Autowired
	InterParkService interparkSrvc;
	
	@PostConstruct
	public void bestseller() {
		RecommendVO rcmdVO = bSrvc.addPeriod();
		List<Integer> gList = bDAO.getGenreList();
		
		for (int cat_id : gList) {
			ArrayList<BookVO> bList = interparkSrvc.interparkAPI(cat_id);
			
			for (int i = 0; i < bList.size(); i++) {
				BookVO bVO = bList.get(i);
				bVO.setCat_id(cat_id);
				bVO.setClassify("B");
				bSrvc.addBookData(bVO);
			}
			
			bSrvc.addRcmd_AND_Bestsell(bList, rcmdVO);
		}
	}
}