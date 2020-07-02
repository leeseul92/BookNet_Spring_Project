package com.pageturner.cls.util;

/**
 * 이 인터페이스는 제공되는 도서 api 서비스를 종류에 맞게 구현하기 위한 인터페이스입니다. 
 * @author leeseulkim
 * @since 25th Jun 2020
 * @version v.1.0
 *
 */

import java.util.*;

import com.pageturner.cls.vo.*;

public interface InterParkAPI {
	public void interparkAPI(int categoryId, String keyword);
}
