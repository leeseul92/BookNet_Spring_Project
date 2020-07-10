package com.pageturner.cls.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.pageturner.cls.vo.ProfileVO;

public class ProfileDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int insertProfile(ProfileVO fVO) {
		return sqlSession.insert("fSQL.insertProfile", fVO);
	}

}
