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

import com.pageturner.cls.dao.*;
import com.pageturner.cls.vo.*;

@Service
public class PostsService {
	@Autowired
	PostsDAO pDAO;
	
	@Autowired
	LikeDAO lDAO;
	
	//게시글 상세보기 내 댓글 리스트
	public List<PostsVO> showCmtList(PostsVO pVO){
		List<PostsVO> list = pDAO.showCmtList(pVO);
		System.out.println("service에서 comnt : " + pVO.getComnt());
		
		for(int i = 0; i < list.size(); i++) {
			//mention 값 찾기 위해 공백으로 댓글내용 분리하기 
			StringTokenizer str = new StringTokenizer(list.get(i).getComnt(), " ");
			while(str.hasMoreElements()) {
				String tmp = str.nextToken();
				if(tmp.charAt(0) == '@') {
					pVO.setMention(tmp);
				}
			}
		}
		return list;
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
 	
 	//게시글 좋아요 처리해주는 서비스함수 
 	public String likeProc(PostsVO pVO) {
 		String ischeck = null;
 		//ischeck를 반환받아 Y / N 을 판별하여 그에 맞는 처리 해주기 
 		if(pVO.getIscheck().equals("Y")) {
 			//좋아요 취소해주기
 			lDAO.cancelLike(pVO);
 			ischeck = "N";
 		} else {
 			//정확히 NULL 값인지 N인지 확인해주어야함.
 			int cnt1 = lDAO.selLike(pVO); //로그인한 회원이 해당 게시글에 좋아요 처리 해준 적이 있는지 확인 
 			if(cnt1 == 0) {
 				//liketab 등록처리
 				lDAO.addLike(pVO);
 				ischeck = "Y";
 			} else {
 				//이미 liketab 등록처리는 되어있고, 현재 상태값만 확인해야함.
 				cnt1 = lDAO.selIscheck(pVO);
 				if(cnt1 == 1) {
 					//'Y' 인 경우이므로 좋아요 취소해줘야한다.
 					lDAO.cancelLike(pVO);
 					ischeck = "N";
 				} else {
 					lDAO.reLike(pVO);
 					ischeck = "Y";
 				}
 			}
 		}
 		
 		System.out.println(ischeck); 
 		
 		return ischeck;
 	}
 	
 	//게시글 수정처리
 	public int editPostProc(PostsVO pVO) {
 		//수정된 게시글에 작성된 해시태그 추출할 함수 호출
 		ArrayList<String> hash = splitHash(pVO.getHash());
 		System.out.println(hash.toString());
 		//원본 게시글에 작성된 해시태그 불러오기 
 		ArrayList<PostsVO> oriHash = (ArrayList<PostsVO>)pDAO.selHash(pVO.getPno());
 		System.out.println(oriHash.toString());

 		//원본 해시태그와 수정된 해시태그 구분하여 DB처리해주는 부분  
 		if(hash.size() == oriHash.size()) {
 			for(int i = 0; i < hash.size(); i++) {
 				if(!hash.get(i).equals(oriHash.get(i).getHash())) {
 					//해시태그가 동일하지 않으면 hname 변경시켜주기 
 					pVO.setHash(hash.get(i));
 					pVO.setHno(oriHash.get(i).getHno());
 					pDAO.editHash(pVO);
 				}
 			}
 		} else if(hash.size() > oriHash.size()) {
 			for(int i = 0; i < hash.size(); i++) {
 				if(i < oriHash.size()) {
 					if(!hash.get(i).equals(oriHash.get(i).getHash())) {
 						//해시태그가 동일하지 않으면 hname 변경시켜주기 
 						pVO.setHash(hash.get(i));
 						pVO.setHno(oriHash.get(i).getHno());
 						pDAO.editHash(pVO);
 					}
 				} else {
 					//수정된 나머지 태그는 추가해줘야함.
 					pVO.setHash(hash.get(i));
 					pDAO.addHash(pVO);
 				}
 			}
 		} else if(hash.size() < oriHash.size()) {
 			for(int i = 0; i < oriHash.size(); i++) {
 				if(i < hash.size()) {
 					if(!hash.get(i).equals(oriHash.get(i).getHash())) {
 						//해시태그가 동일하지 않으면 hname 변경시켜주기 
 						pVO.setHash(hash.get(i));
 						pVO.setHno(oriHash.get(i).getHno());
 						pDAO.editHash(pVO);
 					}
 				} else {
 					//삭제된 원본 태그는 수정되어야함.
 					pVO.setHno(oriHash.get(i).getHno());
 					pDAO.isshowHash(pVO);
 				}
 			}
 		}

 		//게시글 수정시킬 db 작업
 		int rst = pDAO.editPost(pVO);
 		return rst;
 	}
 	
}
