package com.pageturner.cls.util;
/**
 * 	이 클래스는 알람리스트를 시간순으로 정렬할 유틸 클래스이다.
 * @author	박기윤
 * @since	2020.06.29
 * @version	v.1.0
 */

import java.util.*;
import java.text.*;
import com.pageturner.cls.vo.*;

public class SortAlarmList implements Comparator<AlarmVO> {

	@Override
	public int compare(AlarmVO o1, AlarmVO o2) {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date day1 = null;
		Date day2 = null;
		try {
			day1 = form.parse(o1.getExtime());
			day2 = form.parse(o2.getExtime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day2.compareTo(day1);
	}

}
