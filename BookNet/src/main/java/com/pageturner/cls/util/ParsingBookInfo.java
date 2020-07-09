package com.pageturner.cls.util;

/**
 * 이 클래스는 api로부터 받아온 도서정보를 파싱하여 vo에 담아줄 util 클래스입니다.
 * @author leeseulkim
 * @since 27th Jun 2020
 * @version v.1.0
 *
 */

import java.util.*;

import com.google.gson.*;
import com.pageturner.cls.vo.*;

public class ParsingBookInfo {
	
	public JsonParser jPar;
	public JsonObject jObj;
	public JsonArray jArr;
	public String jStr;

	public ArrayList<BookVO> parsingBookInfo(String json) throws Exception {
//	public String parsingBookInfo(String json) throws Exception {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		jPar = new JsonParser();
		jObj = (JsonObject)jPar.parse(json);
//		jStr = jObj.get("item").getAsString();
		jArr = jObj.get("item").getAsJsonArray();
//		System.out.println(jObj);
		System.out.println("item 사이즈 : " + jArr.size());
		
		for(int i = 0; i < jArr.size(); i++) {
			BookVO bVO = new BookVO();
//			PostsVO pVO = new PostsVO();
			JsonObject obj = (JsonObject) jArr.get(i);
			
			bVO.setSmallimg(obj.get("coverSmallUrl").getAsString());
			bVO.setLargeimg(obj.get("coverLargeUrl").getAsString());
			bVO.setGname(obj.get("categoryName").getAsString());
			bVO.setPublish(obj.get("publisher").getAsString());
			bVO.setTrans(obj.get("translator").getAsString());
			bVO.setClassify(obj.get("link").getAsString());
			bVO.setGenre(obj.get("categoryId").getAsInt());
			bVO.setCat_id(jObj.get("searchCategoryId").getAsInt());
			
			try {
				bVO.setBname(obj.get("title").getAsString());
				bVO.setIsbn(obj.get("isbn").getAsString());
				bVO.setWriter(obj.get("author").getAsString());
				list.add(bVO);
			} catch (NullPointerException e) {
				continue;
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(bVO.toString());
		}
		
		return list;
	}
}
