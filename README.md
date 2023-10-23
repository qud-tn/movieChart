# 무비차트는
영화진흥위원회 api와 영화관입장권통합전산망 홈페이지를 활용한 영화 리뷰 및 커뮤니티 입니다.

## 사용 프로그램
IDE : 이클립스(SPRING STS)
서버 : 톰켓
형상 관리 : 깃허브(깃허브 데스크탑)
배포 : AWS(EC2)
데이터 베이스 : MYSQL(MYSQL워크벤치,디비버), AWS(RDS)

## 사용한 라이브러리
데이터 베이스 관련 : MySQL Connector, MyBatis, Spring Framework JDBC, Log4jdbc-Log4j2, HikariCP 
JSON 관련 : Jackson Databind, JSON
보안 관련 : Spring Security
크롤링 관련 : Selenium
기타 : commons-fileupload, commons.io

## 프로젝트 특징
1. REST API 설계 규칙 준수 노력
2. 스프링 시큐리티 사용으로 보안 강화
3. 셀레니움으로 동적 페이지 크롤링 기능 구현
4. ajax로 동적 데이터 페이지 구현
5. 데이터베이스 정규화
6. 지속적인 리팩토링
7. AWS(EC2, RDS)를 활용하여 배포

