package com.pageturner.cls.AOP;

/**
 * 컨트롤러 실행 시 로그인 상태 체크해주는 AOP
 * 함수들 매개변수는 (req, mv, ...)로
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
import org.springframework.web.servlet.view.RedirectView;

@Component
@Aspect
public class LoginAOP {
	
	@Before("execution(* com.pageturner.cls.controller.mypage.MyPage.showMyPage(..)) ||"
			+ "execution(* com.pageturner.cls.controller.mypage.Alarm.showAlarmList(..))")
	public void loginCK(JoinPoint join) {
		System.out.println("loginCK");
		Object[] obj = join.getArgs();
		HttpServletRequest req = (HttpServletRequest) obj[0];

		String sid = (String) req.getSession().getAttribute("SID");
		if (sid == null) { // 로그인 안되있는 경우
			((ModelAndView) obj[1]).addObject("isLogin", false);
			((ModelAndView) obj[1]).setView(new RedirectView("/cls/member/login.cls"));
		} else { // 로그인 되있는 경우
			((ModelAndView) obj[1]).addObject("isLogin", true);
		}
	}

}
