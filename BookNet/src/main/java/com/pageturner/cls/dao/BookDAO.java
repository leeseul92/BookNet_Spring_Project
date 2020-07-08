package com.pageturner.cls.dao;


/**
 * 	이 클래스는 api로부터 받아온 도서정보를
 * 	데이터베이스에 존재여부 확인 및 추가하는 기능을
 * 	담고 있는 DAO 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import java.util.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import com.pageturner.cls.vo.*;

public class BookDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int checkPublish(BookVO bVO) {
		return sqlSession.selectOne("bookSQL.pbCk", bVO);
	}
	
	public int checkBook(BookVO bVO	) {
		return sqlSession.selectOne("bookSQL.bookCk", bVO);
	}
	
	public void addPublish(BookVO bVO) {
		sqlSession.insert("bookSQL.addPb", bVO);
	}
	
	public void addBook(BookVO bVO) {
		sqlSession.insert("bookSQL.addBook", bVO);
	}
	
	public List<Integer> getGenreList() {
		return sqlSession.selectList("bookSQL.selGenreList");
	}
}