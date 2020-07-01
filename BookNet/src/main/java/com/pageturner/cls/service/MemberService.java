package com.pageturner.cls.service;

/**
 * 이 클래스는 Member 컨트롤러에 들어온 요청에 대한 dao 처리를 해주기 위한 서비스클래스입니다.
 * @author leeseulkim
 * @since 17th Jun 2020
 * @version v.1.0
 *
 */

import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Service
public class MemberService {
	@Autowired
	MemberDAO mDAO;
	
}


/*
	//로그인처리요청 
	public String loginService(MemberVO mVO) {
		//dao 호출
		int cnt = mDAO.loginProc(mVO);
		
		//컨트롤러의 세션에 등록될 아이디
		String sid = "";
		
		if(cnt == 1) {
			//db에 id,pw 가 일치하는 회원이 있음.
			sid = mVO.getId();
		}
		
		return sid;
	}
	*/
