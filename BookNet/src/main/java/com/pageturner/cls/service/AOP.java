package com.pageturner.cls.service;

/**
 * 컨트롤러 실행 시 로그인 상태 체크해주는 AOP
 * 
 * @author	이명환
 * @since	20.06.25
 */
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
@Aspect
public class AOP {
	
	@Before("execution(* com.pageturner.cls.controller.*.*.*(..))"
			)
	public void loginCK(JoinPoint join) {
		System.out.println("loginCK");
		Object[] obj = join.getArgs();
		HttpServletRequest req = (HttpServletRequest) obj[0];

		String view = "member/findID";
		String sid = (String) req.getSession().getAttribute("SID");
		if (sid == null) {
			((ModelAndView) obj[1]).addObject("isLogin", false);
		} else {
			((ModelAndView) obj[1]).addObject("isLogin", true);
		}
	}

}
