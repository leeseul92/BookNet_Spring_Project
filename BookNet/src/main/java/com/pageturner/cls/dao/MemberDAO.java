package com.pageturner.cls.dao;
/**
 * 이 클래스는 회원과 관련된 요청에 대한 sql 을 처리해주기 위한 클래스입니다.
 * @author leeseulkim
 * @since 6th Jun 2020
 *
 */

import com.pageturner.cls.vo.*;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAO {
	@Autowired //DI 자동의존주입 
	SqlSessionTemplate sqlSession;
	
	//로그인 질의명령 전담처리함수
	public int getLogin(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.Login", mVO);
	}
	
	// 정보수정(비번)
	public int editPW(MemberVO mVO) {
		return sqlSession.update("mSQL.editPW", mVO);
	}
	
	// 정보수정
	public int editUser(MemberVO mVO) {
		return sqlSession.update("mSQL.editUser", mVO);
	}
	
	// 회원탈퇴
	public int delUser(MemberVO mVO) {
		return sqlSession.update("mSQL.delUser", mVO);
	}

}
