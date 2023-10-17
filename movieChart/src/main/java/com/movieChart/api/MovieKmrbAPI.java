package com.movieChart.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movieChart.domain.BoxOfficeDTO;
import com.movieChart.domain.MovieDTO;

public class MovieKmrbAPI {
	private static final Logger logger = LoggerFactory.getLogger(BoxOfficeAPI.class);
	QueryStringMaker queryStringMaker=new QueryStringMaker();
	private final String KEY="UKW531W841XTM209RM1L";
	private final String REQUEST_URL = "http://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_json2.jsp";
	
	
	 public String requestAPI(MovieDTO mdto ) throws Exception {
		 	
		 
	        // 변수 설정
	        //   - 요청(Request) 인터페이스 Map
	        //   - 어제자 다양성 한국영화 10개 조회
	        HashMap<String, Object> paramMap = new HashMap<>();
	        paramMap.put("ServiceKey"          , KEY);                        
	        paramMap.put("listCount"     , mdto.getListCount());  
	        paramMap.put("startCount"  , mdto.getStartCount());                           
	        paramMap.put("query" , URLEncoder.encode(mdto.getQuery(), "UTF-8"));                             
	        paramMap.put("detail"  , mdto.getDetail());
	        paramMap.put("sort", mdto.getSort());
	        paramMap.put("collection", "kmdb_new2");
	 
	        try {
	            // Request URL 연결 객체 생성
	            URL requestURL = new URL(REQUEST_URL+"?"+queryStringMaker.makeQueryString(paramMap));
	            HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
	            logger.debug(requestURL.toString());
	            // GET 방식으로 요청
	            conn.setRequestMethod("GET");
	            conn.setDoInput(true);
	 
	            // 응답(Response) 구조 작성
	            //   - Stream -> JSONObject
	            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	            String readline = null;
	            StringBuffer response = new StringBuffer();
	            while ((readline = br.readLine()) != null) {
	                response.append(readline);
	            }
	 
	            return response.toString();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "api 서버 오류";
	        }
	    }
}
