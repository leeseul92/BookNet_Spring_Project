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
	
	// 회원정보 조회
	public List<MemberVO> selUser(String id) {
		return sqlSession.selectList("mSQL.selUser", id);
	}
	
	// 장르 조회
	public List<PostsVO> genre() {
		return sqlSession.selectList("mSQL.genre");
	}
	
	// 정보수정(비번)
	public int editPW(MemberVO mVO) {
		return sqlSession.update("mSQL.editPW", mVO);
	}
	
	// 정보수정(회원정보)
	public int editUser(MemberVO mVO) {
		return sqlSession.update("mSQL.editUser", mVO);
	}
	
	// 정보수정(프사)
	public int editProfile(ProfileVO fVO) {
		return sqlSession.insert("mSQL.insertProfile", fVO);
	}
	
	// 정보수정(프사)
	public int updateProfile(ProfileVO fVO) {
		return sqlSession.insert("mSQL.updateProfile", fVO);
	}
	
	// 회원탈퇴
	public int delUser(MemberVO mVO) {
		return sqlSession.update("mSQL.delUser", mVO);
	}
	
	// 아디비번찾기(아이디)
	public String findID(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.findID", mVO);
	}
	
	// 아디비번찾기(비번)
	public String findPW(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.findPW", mVO);
	}
	
	//아이디 중복 확인
   public int idcheck(String id) {
      return sqlSession.selectOne("mSQL.idck",id);
   }
   
   //회원가입
   public int join(MemberVO mVO) {
      return sqlSession.insert("mSQL.join",mVO);
   } 
   
   public String mailck(MemberVO mVO) {
	   return sqlSession.selectOne("mSQL.mailck", mVO);
   }

}
