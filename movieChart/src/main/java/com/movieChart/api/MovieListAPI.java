package com.movieChart.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.movieChart.domain.MovieListDTO;

public class MovieListAPI {
	QueryStringMaker queryStringMaker=new QueryStringMaker();
	
	private final String KEY="e6ca6989be100694be874a2031dc55ee";
	private final String REQUEST_URL = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList..json";
	
	 public JSONArray requestAPI(MovieListDTO mdto  ) {
		 	
		 
	        // 변수 설정
	        //   - 요청(Request) 인터페이스 Map
	        //   - 어제자 다양성 한국영화 10개 조회
	        HashMap<String, String> paramMap = new HashMap<String, String>();
	        paramMap.put("key"          , KEY);                        // 발급받은 인증키
	        paramMap.put("curPage"     , mdto.getCurPage());  // 현재 페이지
	        paramMap.put("itemPerPage"  , mdto.getItemPerPage());                            // 결과 ROW 의 개수( 최대 10개 )
	        paramMap.put("movieNm" , mdto.getMovieNm());                             // 영화명으로 조회
	        paramMap.put("directorNm"  , mdto.getDirectorNm());                             // 감독명으로 조회
	        paramMap.put("openStartDt"  , mdto.getOpenStartDt());                             // YYYY형식의 조회시작 개봉연도
	        paramMap.put("repNationCd"  , mdto.getRepNationCd());                             // N개의 국적으로 조회 (default : 전체)
	        paramMap.put("movieTypeCd"  , mdto.getMovieTypeCd());                             // N개의 영화유형코드로 조회(default : 전체)
	 
	        try {
	            // Request URL 연결 객체 생성
	            URL requestURL = new URL(REQUEST_URL+"?"+queryStringMaker.makeQueryString(paramMap));
	            HttpURLConnection conn = (HttpURLConnection) requestURL.openConnection();
	 
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
	 
	            // 박스오피스 주제 출력
	            String boxofficeType = boxOfficeResult.getString("boxofficeType");
	            System.out.println(boxofficeType);
	 
	            // 박스오피스 목록 출력
	            JSONArray dailyBoxOfficeList = boxOfficeResult.getJSONArray("dailyBoxOfficeList");
	           
	            return dailyBoxOfficeList;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return null;
	        }
}
}
