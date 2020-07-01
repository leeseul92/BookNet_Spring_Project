package com.pageturner.cls.service;
/**
 * 	이 클래스는 알림리스트를 통합하여 컨트롤러에 제공하는 서비스 클래스이다.
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
import com.pageturner.cls.util.*;
import com.pageturner.cls.vo.*;

@Service
public class AlarmService {
	@Autowired
	AlarmDAO alDAO;
	@Autowired
	CountDays cntDays;
	@Autowired
	SortAlarmList alarmSorter;
	
	public ArrayList<AlarmVO> getAlarmList(MemberVO mVO) throws Exception{
		ArrayList<AlarmVO> list = new ArrayList<AlarmVO>();
		Date today = new Date();
		String cdate = null;
		Date ddate = null;
		String dday = null;
		
		cntDays.setToday(today);
		
		ArrayList<AlarmVO> likeList = (ArrayList<AlarmVO>)alDAO.likeList(mVO);
		ArrayList<AlarmVO> falList = (ArrayList<AlarmVO>)alDAO.falList(mVO);
		ArrayList<AlarmVO> comntList = (ArrayList<AlarmVO>)alDAO.comntList(mVO);
		
		for (int i = 0; i < likeList.size(); i++) {
			AlarmVO vo = likeList.get(i);
			
			vo.setType("L");
			cdate = vo.getExtime();
			ddate = cntDays.parseDate(cdate);
			dday = cntDays.countDdays(ddate);
			vo.setDday(dday);
			
			list.add(vo);
		}
		
		for (int i = 0; i < falList.size(); i++) {
			AlarmVO vo = falList.get(i);
			
			vo.setType("F");
			cdate = vo.getExtime();
			ddate = cntDays.parseDate(cdate);
			dday = cntDays.countDdays(ddate);
			vo.setDday(dday);
			
			list.add(vo);
		}
		
		for (int i = 0; i < comntList.size(); i++) {
			AlarmVO vo = comntList.get(i);
			
			vo.setType("C");
			cdate = vo.getExtime();
			ddate = cntDays.parseDate(cdate);
			dday = cntDays.countDdays(ddate);
			vo.setDday(dday);
			
			list.add(vo);
		}
		
		list.sort(alarmSorter);
		
		return list;
	}
}