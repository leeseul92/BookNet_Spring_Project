package com.pageturner.cls.controller.mypage;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pageturner.cls.service.*;

@Controller
public class TestController {
	@Autowired
	BookService bSrvc;
	
	@RequestMapping("/mypage/test.cls")
	public void name() {
		bSrvc.name();
	}
}
