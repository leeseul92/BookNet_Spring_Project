package com.pageturner.cls.scd;

/**
 * 	이 클래스는 스케줄러로 어떠한 작업을 주기적으로 실행할
 * 	컨트롤러 클래스이다.
 * @author	박기윤
 * @since	2020.07.07
 * @version	v.1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ScdController {
	@Autowired
	ScdService scdSrvc;

	public void bestSeller() {
		scdSrvc.scd_best_AND_rcmd();
	}
}