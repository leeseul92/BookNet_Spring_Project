package com.pageturner.cls.service;

/**
 * 	이 클래스는 팔로우와 관련된 서비스를 제공할 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import java.util.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service
public class FallowService {
	@Autowired
	FallowDAO falDAO;
	@Autowired
	MyPageDAO mpDAO;
	
	public int cntFallow(MemberVO mVO) {
		int cnt = 0;
		FallowVO falVO = new FallowVO();
		
		falVO.setFallower_no(mVO.getMno());
		cnt = falDAO.cntFal(falVO);
		
		return cnt;
	}
	
	public int cntFallower(MemberVO mVO) {
		int cnt = 0;
		FallowVO falVO = new FallowVO();
		
		falVO.setFallow_no(mVO.getMno());
		cnt = falDAO.cntFal(falVO);
		
		return cnt;
	}
	
	public int checkFal(MemberVO mVO, HttpServletRequest req) {
		int cnt = 0;
		FallowVO falVO = new FallowVO();
		
		falVO.setFallow_no(mVO.getMno());
		mVO.setId((String)req.getSession().getAttribute("SID"));
		falVO.setFallower_no(mpDAO.getMno(mVO));
		cnt = falDAO.cntFal(falVO);
		
		return cnt;
	}
	
	public ArrayList<FallowVO> fallowList(MemberVO mVO){
		ArrayList<FallowVO> list = new ArrayList<FallowVO>();
		FallowVO falVO = new FallowVO();
		
		falVO.setFallower_no(mVO.getMno());
		list = (ArrayList<FallowVO>)falDAO.falList(falVO);
		
		return list;
	}
	
	public ArrayList<FallowVO> fallowerList(MemberVO mVO){
		ArrayList<FallowVO> list = new ArrayList<FallowVO>();
		FallowVO falVO = new FallowVO();
		
		falVO.setFallow_no(mVO.getMno());
		list = (ArrayList<FallowVO>)falDAO.falList(falVO);
		
		return list;
	}
	
	public void fallowingState(MemberVO mVO, HttpServletRequest req) {
		int cnt = checkFal(mVO, req);
		FallowVO falVO = new FallowVO();
		
		falVO.setFallow_no(mVO.getMno());
		mVO.setId((String)req.getSession().getAttribute("SID"));
		falVO.setFallower_no(mpDAO.getMno(mVO));
		
		if(cnt == 0) {
			falDAO.newFal(falVO);
		} else {
			falVO.setIscheck(falDAO.checkFal(falVO));
			falDAO.falStateChange(falVO);
		}
	}
}