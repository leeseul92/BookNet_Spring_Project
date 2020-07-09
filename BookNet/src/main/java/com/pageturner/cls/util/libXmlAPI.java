package com.pageturner.cls.util;
/**
 * 서울 도서관 API, 데이터베이스 저장할 클래스이다.
 * @author 서동혁
 * @since 2020-07-03
 * @version v.0.1
 */
import javax.servlet.http.*;
import javax.xml.parsers.*;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.servlet.*;
import org.w3c.dom.*;

@Component
@Aspect
public class libXmlAPI {
	String KEY = "427a68556f3530323334526456556d"; // 서울도서관 API를 위한 KEY 값
	String base = null;
	String api = null;
	String query = null;
	
	int startPage = 1;
	int endPage = 1;
	
	@Before("execution(* com.pageturner.cls.controller.search.Search.libMap(..))")
	public void libAPI(JoinPoint join) {
		Object[] obj = join.getArgs();
		HttpServletRequest req = (HttpServletRequest) obj[0];
		HttpSession session = req.getSession();
		String view = "";
		// 아이디 가져오기
		String sid = (String) session.getAttribute("SID");
		// 아아디세션 만료되었는지 확인하기
		//파싱할 url 지정(api 키 포함)
		api = "http://openapi.seoul.go.kr:8088/";
		query = "/xml/SeoulPublicLibraryInfo/";
			try {
				while(true) {
					
					base = api + KEY + query +startPage+"/"+endPage+"/";
					
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = (Document)dBuilder.parse(base);
//					System.out.println(base);
					// xml의 최상위 값을 꺼내온다
					doc.getDocumentElement().normalize();
					// 첫번째 tag값을 가져온다
//					System.out.println("Doc element: " + doc.getDocumentElement().getNodeName());
					
					// 파싱할 정보가 있는 tag에 접근
					// 파싱할 tag
					NodeList nList = doc.getElementsByTagName("row");
					//파싱할 리스트 수
//					System.out.println("파싱할 리스트의 수 : " + nList.getLength());
					
					//리스트에 담긴 데이터 출력하기
					int temp=0;
					//반복문 사용
					for (temp = 0; temp < nList.getLength(); temp++) {
						
						Node nNode = nList.item(temp);
						
						if(nNode.getNodeType() == Node.ELEMENT_NODE) {
							
							Element eElement = (Element) nNode;
							
							System.out.println("#################");
							System.out.println("도서관 명 : " + getTagValue("LBRRY_NAME",eElement));
							String lname = getTagValue("LBRRY_NAME",eElement);
							System.out.println("전화번 호 : " + getTagValue("TEL_NO",eElement));
							System.out.println("휴     일 : " + getTagValue("FDRM_CLOSE_DATE",eElement));
							System.out.println("경     도 : " + getTagValue("XCNTS",eElement));
							System.out.println("위     도 : " + getTagValue("YDNTS",eElement));
//							if(lname.equals("강남구립못골도서관")) {
//								System.out.println(" 등장!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
//								break;
//							}
						} //if
					} //for
					startPage += 1;
					endPage += 1;
					System.out.println("Page number : " + startPage+"~"+endPage);
					
					// 뽑아올 마지막 페이지
					if(nList.getLength() == 0) {
						System.out.println("없댜");
						startPage = 1;
						endPage = 1;
						break;
						// 추가로 실행하면 계속해서 0을 찾음. - 서버가 새로고침 되기 전까지.
					}
				}//while
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	//tag값 가져오기 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if(nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}
	// 로그인이 안돼어있을 때
	@Before("execution(* com.pageturner.cls.util.libXmlAPI.libAPI(..))")
	public void nonlog(JoinPoint join) {
		String view = "member/login";
		Object[] obj = join.getArgs();
		HttpServletRequest req = (HttpServletRequest) obj[0];
		HttpSession session = req.getSession();
		String sid = (String) session.getAttribute("SID");
		// 로그인 유무 확인하기
		if (sid == null) {
			// 로그인이 안 된 상태
			System.out.println("로그인이 안되어있넹?");
			((ModelAndView) obj[1]).setViewName(view);
			((ModelAndView) obj[1]).addObject("isLogin", false);
		}
	}
}