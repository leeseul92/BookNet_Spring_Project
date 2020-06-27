package com.pageturner.cls.service;


/**
 * 이 클래스는 MyPage 컨트롤러에 들어온 요청에 대한 dao 처리를 해주기 위한 서비스 클래스입니다.
 * @author leeseulkim
 * @since 27th Jun 2020
 * @version v.1.0
 *
 */

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service
public class MyPageService {
	@Autowired
	MyPageDAO mpDAO;
	
	//세션에 입력된 값을 통해 mno를 얻는 서비스처리 함수
	public int getMno(String id) {
		return mpDAO.getMno(id);
	}
	
	//마이페이지에 보여줄 회원정보 서비스처리 함수 
	public MemberVO getMembInfo(MemberVO mVO) {
		System.out.println("****service단에서의 mVO.getId : " + mVO.getId());
		System.out.println("****service단에서의 mVO.getMno : " + mVO.getMno());
		return mpDAO.membInfo(mVO);
	}
}
