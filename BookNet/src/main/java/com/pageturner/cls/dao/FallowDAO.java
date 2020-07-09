package com.pageturner.cls.dao;
/**
 * 	이 클래스는 팔로우, 팔로워와 관련된 데이터베이스 작업을 수행할 DAO 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import java.util.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import com.pageturner.cls.vo.*;

public class FallowDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int cntFal(FallowVO falVO) {
		return sqlSession.selectOne("falSQL.cntFal", falVO);
	}
	
	public String ckFal(FallowVO falVO) {
		return sqlSession.selectOne("falSQL.ckFal", falVO);
	}
	
	public List falList(FallowVO falVO) {
		return sqlSession.selectList("falSQL.falList", falVO);
	}
	
	public void newFal(FallowVO falVO) {
		sqlSession.insert("falSQL.newFal", falVO);
	}
	
	public void falStateChange(FallowVO falVO) {
		sqlSession.update("falSQL.falStateChange", falVO);
	}
}