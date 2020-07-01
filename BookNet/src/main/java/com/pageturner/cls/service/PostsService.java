package com.pageturner.cls.service;

/**
 * 이 클래스는 게시글과 관련된 요청에 대한 dao 처리를 해주기 위한 서비스클래스입니다.
 * @author leeseulkim
 * @since 19th Jun 2020
 * @version v.1.0
 *
 */

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageturner.cls.dao.PostsDAO;
import com.pageturner.cls.vo.PostsVO;

@Service
public class PostsService {
	@Autowired
	PostsDAO pDAO;
	
	//게시글 상세보기 내 댓글 리스트
	public List<PostsVO> showCmtList(PostsVO pVO){
		return pDAO.showCmtList(pVO);
	}
	
	//댓글 작성 처리
	public PostsVO wrtCmt(PostsVO pVO) {
		int cnt = pDAO.wrtCmt(pVO); //insert 되었는지 확인용 (1 또는 0)
		pVO.setCnt(cnt);
		System.out.println("작성된 댓글번호 : " + pVO.getCno()); //selectKey로부터 값이 제대로 입력되었는지 확인 
		return pVO;
	}
	
	//댓글 삭제 처리 
	public int delCmt(int cno) {
		int rst = pDAO.delCmt(cno);
		return rst;
	}
	
	//게시글 작성시 도서장르선택부분 처리
	public List<PostsVO> genresList() {
		List<PostsVO> list = pDAO.listGenres();
		return list;
	}
	
	//게시글 작성시 도서검색 처리
 	public List<PostsVO> searchBook(PostsVO pVO) {
		return pDAO.searchBook(pVO);
	}
 	
 	//게시글 등록 처리
 	public int addPost(PostsVO pVO) {
 		//해시태그부분 가져오기 
 		String hash = pVO.getHash();
 		
 		//게시글등록처리해주는 질의명령 dao 호출 
 		int rst = pDAO.addPost(pVO);
 		//selectKey로 pno가 맵핑되었는지 확인 
 		System.out.println(pVO.getPno());
 		
 		if(rst == 1) {
 			if(hash.length() != 0) {
 				//문자열 분리해줄 함수 호출 
 				ArrayList<String> hList = splitHash(hash);
 				//해시태그가 존재하면 db 저장시켜주는 함수 호출 >> 단, 태그 갯수만큼
 				for(int i = 0; i < hList.size(); i++) {
 					pVO.setHash(hList.get(i));
 					addHash(pVO);
 				}
 			}
 		}
 		
 		return rst;
 	}
 	
 	//문자열 잘라줄 함수 호출
 	public ArrayList<String> splitHash(String hash) {
 		ArrayList<String> list = new ArrayList<String>();
 		
 		StringTokenizer str = new StringTokenizer(hash, "#");
 		
 		while(str.hasMoreElements()) {
 			list.add(str.nextToken());
 		}
 		return list;
 	}
 	
 	//게시글 db에 저장 후 해시태그도 저장해주기
 	public int addHash(PostsVO pVO) {
 		return pDAO.addHash(pVO);
 	}
 	
 	//게시글 삭제해주는 서비스함수
 	public int delPost(int pno) {
 		return pDAO.delPost(pno);
 	}
}
