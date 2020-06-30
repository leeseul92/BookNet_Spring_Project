package com.pageturner.cls.dao;
/**
 * 이 클래스는 마이페이지와 관련된 요청에 대한 데이터베이스 작업을 수행할 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import java.util.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pageturner.cls.vo.*;

@Repository
public class MyPageDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// id로 mno를 찾아줄 처리함수
	public int getMno(MemberVO mVO) {
		// 해당함수가 실행되면 조회된 mno가 MemberVO에 setting 될 것. 
		return sqlSession.selectOne("mpSQL.getMno", mVO);
	}
	// 회원 상세 정보를 조회하는 함수
	public MemberVO membInfo(MemberVO mVO) {
		return sqlSession.selectOne("mpSQL.getMembInfo", mVO);
	}
	
	// 회원이 작성한 게시글의 갯수를 조회하는 함수
	public int cntPost(MemberVO mVO) {
		return sqlSession.selectOne("mpSQL.cntPost", mVO);
	}
	
	// 회원과 관련된 게시글 목록을 조회하는 함수
	public List getPost(PostsVO pVO) {
		return sqlSession.selectList("mpSQL.getPost", pVO);
	}
}