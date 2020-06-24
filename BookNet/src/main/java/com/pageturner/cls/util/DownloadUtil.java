package com.pageturner.cls.util;

/**
 * 이 클래스는 다운로드를 실제 실행할 특수 view 클래스입니다.
 * 해당 클래스가 view 되기 위해서는 상위클래스로 view 클래스를 이용(상속)해야합니다.
 * 이러한 상위클래스로 AbstractView 추상클래스를 사용합니다.
 * @author leeseulkim
 * @since 17th Jun 2020
 * @version v.1.0
 * 
 */

import java.util.Map;
import java.io.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadUtil extends AbstractView {

	// DownloadView를 위하여 이 클래스를 생성하게 되면, 파일 다운로드 방식으로 jsp파일에서 content 방식을 변경해야한다.
	public DownloadUtil() {
		setContentType("application/download; charset=UTF-8");
		//이것은 jsp 문서에 있는 ContentType="text/html; charset=UTF-8"과 동일한 역할을 한다.
		//즉, 응답문서(jsp 뷰)를 다운로드형식으로 만들어주겠다는 의미이다.
	}//Default Constructor
	
	//반드시 renderMergedOutputModel() 함수를 override 해주어야한다.
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		/*
		 	이 안에서 필요한 기능을 구현하면 되는데, 코딩 내용은 뷰의 역할에 따라 달라진다.
		 	
		 	다운로드처리를 하기 위해서는 스트림방식으로 처리해주면 된다.
		 	
		 	파라미터
		 		***
		 		Map model : 컨트롤러에서 보내는 Model을 받는 매개변수 
		 		
		 		주의]
		 			앞으로 해당 클래스를 뷰로 사용하는 경우, Map 형태를 사용하여 다운로드해줄 파일의 정보를 알려줘야한다.
		 			
		 	HttpServletRequest request, HttpServletResponse response
		 	==> 요청과 응답을 관리할 클래스를 받을 매개변수 
		 */
		
		//할일
		//1. 다운로드해줄 파일을 File을 객체로 만든다.
		//	약속] 컨트롤러에서 다운로드해줄 파일의 정보를 downloadFile 이라는 키값으로 File 형태로 만들어주기로 한다.
		File oriFile = (File) model.get("downloadFile");
		
		//2. 파일의 헤더부분을 다운로드형태로 변경한다.
		response.setContentType(getContentType());
		response.setContentLength((int)oriFile.length());
		response.setHeader("Content-Transfer-Encoding", "binary");
		//이렇게 해야지 zip 파일 등 텍스트파일이 아닌 경우라도 다운로드가 가능해진다.
		
		/*
		 	파일 다운로드 팝업창에 표시할 내용을 꾸며주는데, 파일의 이름을 출력하려고 한다.
		 	
		 	파일의 이름이 한글인 경우를 대비하여 인코딩을 해준다.
		 */
		String fileName = new String(oriFile.getName().getBytes("EUC-KR"), "ISO-8859-1");
		
		response.setHeader("Content-Disposition", "attachment;filname=\"" + fileName + "\";fileLength=\"" + ((int)oriFile.length()) + "\";");
		//파일 다운로드 방식을 기계어 방식으로 지정한다.
		
		//3. 스트림을 이용하여 파일을 클라이언트에게 전송한다. 이 과정은 한쪽에서 읽고, 다른쪽에서 전송하는 일반적인 파일 복사방식을 적용하면 된다.
		OutputStream out = response.getOutputStream(); //클라이언트에게 연결된 스트림을 생성
		FileInputStream fis = null; //다운로드해줄 파일과 연결괸 스트림을 생성 
		
		try {
			//파일이 존재하지 않으면 에러가 나기 때문에, 예외처리해준다.
			fis = new FileInputStream(oriFile);
			
			/*
			while(true) {
				byte[] buff = new byte[1024];
				int len = fis.read(buff);
				
				if(len < 0) {
					//읽은 데이터가 없는 경우 반복문 탈출 
					break;
				}
				
				//클라이언트가 저장시킬 수 있도록 읽은 데이터를 내보내기 
				out.write(buff, 0, len);
			}
			 ==> 스프링에서는 이 과정을 대신해줄 함수가 이미 만들어져 있다.
			 */
			
			FileCopyUtils.copy(fis, out);
			out.flush();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
			fis.close();
		}
		
	}

}
