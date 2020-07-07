package com.pageturner.cls.scd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ScdCon {
	@Autowired
	ScdService scdSrvc;

	@RequestMapping("/scd.cls")
	public void scdTest() {
		scdSrvc.test_bestseller();
	}
}
