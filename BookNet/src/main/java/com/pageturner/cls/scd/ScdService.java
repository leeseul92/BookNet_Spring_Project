package com.pageturner.cls.scd;

/**
 * 	이 클래스는 추천도서 및 베스트셀러와 관련된 서비스 클래스이다.
 * @author	박기윤
 * @since	2020.07.07
 * @version	v.1.0
 * 
 */

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.service.*;
import com.pageturner.cls.util.*;
import com.pageturner.cls.vo.*;

@Service
public class ScdService {
	@Autowired
	BookDAO bookDAO;
	@Autowired
	ScdDAO scdDAO;
	@Autowired
	SelectAPI selApi;
	@Autowired
	BookService bSrvc;
	@Autowired
	InterParkService interparkSrvc;
	
	@DependsOn
	public void scd_best_AND_rcmd() {
		ScdVO scdVO = new ScdVO();
		List<Integer> gList = bookDAO.getGenreList();
		
		scdVO = scdDAO.addPeriod(scdVO);
		
		for (int cat_id : gList) {
			ArrayList<BookVO> bList = interparkSrvc.interparkAPI(selApi.BESTSELL, cat_id);
			scdVO.setClassify('B');
			scdVO.setCat_id(cat_id);
			
			for (int i = 0; i < bList.size(); i++) {
				BookVO bVO = new BookVO();
				bVO = bList.get(i);
				bSrvc.addBookData(bVO);
				
				scdVO.setBno(scdDAO.getBno(bVO));
				scdDAO.addRcmdBook(scdVO);
			}

			ArrayList<BookVO> rList = interparkSrvc.interparkAPI(selApi.RECOMM, cat_id);
			scdVO.setClassify('R');
			
			for (int i = 0; i < rList.size(); i++) {
				BookVO bVO = new BookVO();
				bVO = rList.get(i);
				bSrvc.addBookData(bVO);
				
				scdVO.setBno(scdDAO.getBno(bVO));
				scdDAO.addRcmdBook(scdVO);
			}
		}
	}
	
	public ArrayList<BookVO> bestOrRcmd(ScdVO scdVO){
		ArrayList<BookVO> list = (ArrayList<BookVO>)scdDAO.bestOrRcmdList(scdVO);
		return list;
	}
}
