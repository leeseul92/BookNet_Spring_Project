package com.pageturner.cls.dao;

/**
 * 이 클래스는 마이페이지와 관련된 요청에 대한 db 작업용 클래스입니다.
 * @author leeseulkim
 * @since 27th Jun 2020
 *
 */

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.pageturner.cls.vo.*;

@Repository
public class MyPageDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//id로 mno를 찾아줄 처리함수
	public int getMno(String id) {
		//해당함수가 실행되면 조회된 mno가 MemberVO에 setting 될 것. 
		return sqlSession.selectOne("mpSQL.getMno", id);
	}
	//본인 마이페이지에 보여줄 회원정보 전담처리
	public MemberVO membInfo(MemberVO mVO) {
		return sqlSession.selectOne("mpSQL.getMembInfo", mVO);
	}
}
