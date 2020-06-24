package com.pageturner.cls.util;

/**
 * 이 클래스는 파일 업로드에 필요한 기능을 처리해주기 위한 utility 클래스입니다. 
 * @author leeseulkim
 * @since 17th Jun 2020
 * @version v.1.0
 *
 */
import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	
	//중복된 파일이름이 있을 경우, 이름을 바꿔주는 함수
	public static String rename(String path, String oldName) {
		//규칙 : 동일한 파일이름이 있으면, _(숫자) 의 형태로 이름을 변경시키자.
		int count = 0; //(숫자) 부분에 붙을 번호를 기억할 변수 
		String tmpName = oldName; //현재이름을 별도록 기억시켜놓을 변수 
		
		File file = new File(path, oldName);
		
		while(file.exists()) {
			count++; //중복된 이름에 붙여줄 번호를 증가시킨다.
			
			//입력된 파일의 이름을 . 기준으로 이름과 확장자를 분리시키자.
			int len = tmpName.lastIndexOf('.');
			String tmp1 = tmpName.substring(0, len); //파일이름 부분
			String tmp2 = tmpName.substring(len); //확장자부분 
			
			//이제 분리된 이름에 규칙을 붙여 다시 합쳐준다.
			oldName = tmp1 + "_" + count + tmp2;
			
			//만들어준 파일명도 중복되는 경우가 존재하는지 확인시켜주어야한다. (==> 재귀함수)
			file = new File(path, oldName);
		}
		
		return oldName;
	}
	
	public String[] getSaveName(HttpSession session, MultipartFile[] file, String folder) {
		String[] savename = new String[file.length];
		String path = session.getServletContext().getRealPath("resources") + "/" + folder;
		
		for(int i = 0; i < file.length; i++) {
			String oriname = file[i].getOriginalFilename();
			if(oriname != null || oriname.length() != 0) {
				savename[i] = rename(path, oriname);
			}
			
			//파일 저장
			try {
				File refile = new File(path, savename[i]);
				file[i].transferTo(refile);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return savename;
	}
}
