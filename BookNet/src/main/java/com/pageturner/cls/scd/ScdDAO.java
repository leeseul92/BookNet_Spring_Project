package com.pageturner.cls.scd;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
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
}
