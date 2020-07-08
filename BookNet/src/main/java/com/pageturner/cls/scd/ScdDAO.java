package com.pageturner.cls.scd;

/**
 * 	이 클래스는 추천도서 및 베스트셀러와 관련된 데이터베이스 작업을
 * 	수행할 DAO 클래스이다.
 * @author	박기윤
 * @since	2020.07.07
 * @version	v.1.0
 * 
 */

import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.pageturner.cls.vo.*;

public class ScdDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public ScdVO addPeriod(ScdVO scdVO) {
		sqlSession.insert("scdSQL.addPeriod", scdVO);
		return scdVO;
	}
	
	public void addRcmdBook(ScdVO scdVO) {
		sqlSession.insert("scdSQL.addRcmdBook", scdVO);
	}
	
	public int getBno(BookVO bVO) {
		return sqlSession.selectOne("scdSQL.getBno", bVO);
	}
	
	public List bestOrRcmdList(ScdVO scdVO) {
		return sqlSession.selectList("scdSQL.getBestOrRcmdList", scdVO);
	}
}
