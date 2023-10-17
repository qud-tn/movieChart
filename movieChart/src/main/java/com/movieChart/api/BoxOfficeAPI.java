package com.movieChart.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieChart.controller.CommonController;
import com.movieChart.domain.BoxOfficeDTO;



public class BoxOfficeAPI {
	private static final Logger logger = LoggerFactory.getLogger(BoxOfficeAPI.class);
	QueryStringMaker queryStringMaker=new QueryStringMaker();
	private final String KEY="e6ca6989be100694be874a2031dc55ee";
	private final String REQUEST_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
	
	
	 public String requestAPI(BoxOfficeDTO bdto ) {
		 	
		 
	        // 변수 설정
	        //   - 요청(Request) 인터페이스 Map
	        //   - 어제자 다양성 한국영화 10개 조회
	        HashMap<String, Object> paramMap = new HashMap<>();
	        paramMap.put("key"          , KEY);                        // 발급받은 인증키
	        paramMap.put("targetDt"     , bdto.getTargetDt().replace("-",""));  // 조회하고자 하는 날짜
	        paramMap.put("itemPerPage"  , bdto.getItemPerPage());                            // 결과 ROW 의 개수( 최대 10개 )
	        paramMap.put("multiMovieYn" , bdto.getMultiMovieYn());                             // Y:다양성 영화, N:상업영화, Default:전체
	        paramMap.put("repNationCd"  , bdto.getRepNationCd());                             // K:한국영화, F:외국영화, Default:전체
	 
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
	 
	            // JSON 객체로  변환
	            JSONObject responseBody = new JSONObject(response.toString());
	 
	            // 데이터 추출
	            JSONObject boxOfficeResult = responseBody.getJSONObject("boxOfficeResult");
	            
	            return boxOfficeResult.toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "api 서버 오류";
	        }
	    }
}
