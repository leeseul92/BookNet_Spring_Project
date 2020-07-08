package com.pageturner.cls.scd;

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