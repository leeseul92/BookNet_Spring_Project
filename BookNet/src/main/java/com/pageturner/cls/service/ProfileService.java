package com.pageturner.cls.service;

/**
 * 이 클래스는 파일 업로드를 처리할 클래스입니다.
 * @author leeseulkim
 * @since 17th Jun 2020
 * @version v.1.0
 *
 */

import java.io.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pageturner.cls.vo.*;
import com.pageturner.cls.dao.*;
import com.pageturner.cls.util.*;
@Service
public class ProfileService {
	//필요한 클래스 자동주입받기 
	@Autowired
	MemberDAO mDAO;
	
	//단일 파일 업로드 처리함수
	public String uploadProc(HttpSession session, MultipartFile file) {
		String savename = "";
		String path = session.getServletContext().getRealPath("resources");
		path = path + "/profile";
		
		String oriname = file.getOriginalFilename();
		
		if(oriname != null || oriname.length() != 0) {
			savename = FileUtil.rename(path, oriname);
		}
		
		//파일을 실제 경로에 저장시킨다.
		try {
			File refile = new File(path, savename);
			file.transferTo(refile); //업로드 완성 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return savename;
	}
	
	//멀티파일 업로드 처리함수 ==> 업로드된 갯수만큼 rename 규칙확인해야한다.
	public String[] multiUpProc(HttpSession session, MultipartFile[] files) {
		/*
		 	이 함수가 파일을 업로드시키기 위해서는 컨트롤러에서 업로드할 파일의 정보를 받아와야한다.
		 	여러개의 파일이 업로드 될 것이기 때문에 반복해서 처리해야한다.
		 */
		String[] tmp = new String[files.length];
		
		for(int i = 0; i < tmp.length; i++) {
			tmp[i] = uploadProc(session, files[i]);
		}
		
		return tmp;
	}
	
	//파일 정보를 등록처리해 줄 함수 
	
	
}
