package com.pageturner.cls.util;

/**
 * 이 클래스는 api를 제공해주는 웹에 연결하여 json형태의 도서정보를 가지고 올 util 클래스입니다.
 * @author leeseulkim
 * @since 25th Jun 2020
 * @version v.1.0
 *
 */
import java.io.*;
import java.net.*;
import java.util.*;

import com.google.gson.*;
import com.pageturner.cls.vo.*;

public class WebConnection {
	public String webConnection(String address) throws Exception {
		String json = null;
		BufferedReader buff;
		URL url;
		HttpURLConnection conn;
		String protocol = "POST";
		
		url = new URL(address);
		conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod(protocol);
		buff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		json = buff.readLine(); //json 문서를 읽어온다.
		
		return json;
	}
	
}
