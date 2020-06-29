package com.pageturner.cls.dao;
/**
 * 	이 클래스는 알람리스트를 데이터베이스에서 불러오는 DAO 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 * 
 */

import java.util.*;
import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;
import com.pageturner.cls.vo.*;

public class AlarmDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List falList(MemberVO mVO) {
		return sqlSession.selectList("almSQL.fal", mVO);
	}
	
	public List likeList(MemberVO mVO) {
		return sqlSession.selectList("almSQL.like", mVO);
	}
	
	public List comntList(MemberVO mVO) {
		return sqlSession.selectList("almSQL.comnt", mVO);
	}
}