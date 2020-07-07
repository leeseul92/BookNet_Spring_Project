package com.pageturner.cls.scd;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.*;
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
	public void test_bestseller() {
		ScdVO scdVO = new ScdVO();
		List<Integer> gList = bookDAO.getGenreList();
		
		scdVO = scdDAO.addPeriod(scdVO);
		
		for (int cat_id : gList) {
			ArrayList<BookVO> bList = interparkSrvc.interparkAPI(selApi.BESTSELL, cat_id);
			
			for (int i = 0; i < bList.size(); i++) {
				BookVO bVO = new BookVO();
				bVO = bList.get(i);
				bSrvc.addBookData(bVO);
				
				scdVO.setBno(scdDAO.getBno(bVO));
				scdVO.setCat_id(cat_id);
				scdVO.setClassify('B');
				scdDAO.addRcmdBook(scdVO);
			}
		}
	}
}
