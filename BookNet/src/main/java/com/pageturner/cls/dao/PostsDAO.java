package com.pageturner.cls.dao;
/**
 * 이 클래스는 게시글과 관련한 요청에 대한 sql을 처리해주기 위한 클래스입니다.
 * @author leeseulkim
 * @since 13th Jun 2020
 *
 */
import com.pageturner.cls.vo.*;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class PostsDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//게시물 상세보기 내 댓글 리스트 처리 전담함수 
	public List<PostsVO> showCmtList(PostsVO pVO){
		return sqlSession.selectList("pSQL.CmtList", pVO);
	}
	
	//게시물 상세보기 내 댓글 작성 처리 전담함수
	public int wrtCmt(PostsVO pVO) {
		return sqlSession.insert("pSQL.WrtCmt", pVO);
	}
	
	//댓글 삭제처리 전담함수
	public int delCmt(int cno) {
		return sqlSession.update("pSQL.delCmt", cno);
	}
	
	//게시글 작성시 도서장르선택부분 목록 처리 전담함수
	public List<PostsVO> listGenres() {
		return sqlSession.selectList("pSQL.getGenres");
	}
	
	//게시글 작성시 도서 검색결과 작성 처리 전담함수 
	public List<PostsVO> searchBook(PostsVO pVO){
		System.out.println(pVO.getKeyword() + " " + pVO.getGenre());
		return sqlSession.selectList("pSQL.SearchBook", pVO);
	}
	
	//게시글 등록 처리 전담함수
	public int addPost(PostsVO pVO) {
		System.out.println(pVO.getPostcont() + " " + pVO.getDomain());
		return sqlSession.insert("pSQL.addPost", pVO);
	}
	
	//해시태그 등록 처리 전담함수
	public int addHash(PostsVO pVO) {
		return sqlSession.insert("pSQL.addHash", pVO);
	}
	
	//게시글 삭제 처리 전담함수
	public int delPost(int pno) {
		return sqlSession.update("pSQL.delPost", pno);
	}
	
	//해당게시글 해시태그 불러오기 
	public List<PostsVO> selHash(int pno) {
		return sqlSession.selectList("pSQL.selHashes", pno);
	}
	
	//해당게시글 해시태그 내용 수정 전담함수
	public void editHash(PostsVO pVO) {
		sqlSession.update("pSQL.editHash", pVO);
	}

	//해당게시글 해시태그 isshow 수정 전담함수
	public void isshowHash(PostsVO pVO) {
		sqlSession.update("pSQL.isshowHash", pVO);
	}
	
	//게시글 수정처리 전담함수
	public int editPost(PostsVO pVO) {
		return sqlSession.update("pSQL.editPost", pVO);
	}
}
