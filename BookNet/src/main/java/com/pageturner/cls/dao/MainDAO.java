package com.pageturner.cls.dao;
/**
 * 이 클래스는 메인화면과 관련한 요청에 대한 sql을 처리해주기 위한 클래스입니다.
 * @author leeseulkim
 * @since 10th Jun 2020
 *
 */

import com.pageturner.cls.vo.*;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MainDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//로그인한 회원에게 보여질 메인 게시글 
	public List<MainVO> showMemMain(String id) {
		return sqlSession.selectList("mainSQL.MemMain", id);
	}
	
	//본문 우측부분에 들어갈 자주 작성된 도서 5선 
	public List<MainVO> oftenList(){
		return sqlSession.selectList("mainSQL.OftenBook");
	}
}
