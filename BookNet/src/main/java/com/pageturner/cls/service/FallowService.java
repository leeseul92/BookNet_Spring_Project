package com.pageturner.cls.service;

/**
 * 	이 클래스는 팔로우와 관련된 서비스를 제공할 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 *
 */

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service
public class FallowService {
	@Autowired
	FallowDAO falDAO;
	@Autowired
	MyPageService mpSrvc;
	
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
	
	public String checkFal(MemberVO mVO, String sid) {
		int cnt = 0;
		String ckfal = null;
		FallowVO falVO = new FallowVO();
		
		falVO.setFallow_no(mVO.getMno());
		mVO.setId(sid);
		mVO = mpSrvc.getInfo(mVO);
		falVO.setFallower_no(mVO.getMno());
		cnt = falDAO.cntFal(falVO);
		ckfal = falDAO.ckFal(falVO);
		
		return ckfal;
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
	
	public void fallowingState(MemberVO mVO, String sid, String ckfal) {
		FallowVO falVO = new FallowVO();
		
		falVO.setFallow_no(mVO.getMno());
		mVO.setId(sid);
		mVO = mpSrvc.getInfo(mVO);
		falVO.setFallower_no(mVO.getMno());
		int cnt = falDAO.cntFal(falVO);
		if(cnt == 0) {
			falDAO.newFal(falVO);
		} else {
			if(ckfal.equals("N")) {
				falVO.setRevck("YES");
				falVO.setIscheck("Y");
			} else {
				falVO.setRevck("NO");
				falVO.setIscheck("N");
			}
			falDAO.falStateChange(falVO);
		}
	}
}