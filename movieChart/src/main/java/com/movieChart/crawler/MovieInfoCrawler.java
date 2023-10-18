package com.movieChart.crawler;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.movieChart.domain.MovieDTO;
import com.movieChart.persistance.MovieDAO;
import com.movieChart.persistance.MovieDAOImpl;
import com.mysql.cj.xdevapi.JsonArray;

public class MovieInfoCrawler {
	private static final Logger logger = LoggerFactory.getLogger(MovieInfoCrawler.class);

	private static final String CRAWLER_URL = "http://kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do?dtTp=movie&dtCd=";
	private static final String CRAWLER_URL2 = "http://kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do";

	public MovieDTO crawlWeb(String parameter) {

		MovieDTO midto = new MovieDTO();

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(CRAWLER_URL + parameter);

		try {
			WebElement image = driver.findElement(By.cssSelector(".fl.thumb"));
			WebElement synopsis = driver.findElement(By.cssSelector(".desc_info"));

			String imageUrl = image.getAttribute("src");
			String synopsisText = synopsis.getText();

			logger.debug(imageUrl);
			logger.debug(synopsisText);

			midto.setImage(imageUrl);
			midto.setSynopsis(synopsisText);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

		return midto;
	}

	public List<MovieDTO> crawlAll(List<Integer> previousList) throws Exception {
		List<MovieDTO> miList = new ArrayList<MovieDTO>();

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 대기 시간 늘리기

		driver.get(CRAWLER_URL2);

		int startPage=1;
		int endPage=10;
		boolean hasNextPage = true;

		try {
			while (hasNextPage) {
				for (int i = startPage; i <= endPage; i++) {
					for (int j = 1; j < 11; j++) {
						String xpathExpressionView = "(//tr//td[1]//a[contains(@onclick, 'mstView')])[" + j + "]";
						WebElement mstViewLink = wait
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpressionView)));

						mstViewLink.click();

						// 페이지 로딩을 기다림
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fl.thumb")));
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.desc_info")));
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tit")));
						wait.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath("//dt[text()='코드']/following-sibling::dd")));

						WebElement image = driver.findElement(By.cssSelector(".fl.thumb"));
						WebElement synopsis = driver.findElement(By.cssSelector(".desc_info"));
						WebElement title = driver.findElement(By.cssSelector(".tit"));
						WebElement movieCode = driver.findElement(By.xpath("//dt[text()='코드']/following-sibling::dd"));

						String movieCodeText = movieCode.getText();
						String imageUrl = image.getAttribute("src");
						String synopsisText = synopsis.getText();
						String titleText = title.getText();

						int movieCd = Integer.parseInt(movieCodeText);

						if (!previousList.contains(movieCd)) {
							logger.debug(imageUrl);
							logger.debug(synopsisText);

							MovieDTO midto = new MovieDTO();
							midto.setCode_no(movieCd);
							midto.setImage(imageUrl);
							midto.setSynopsis(synopsisText);
							midto.setTitle(titleText);
							miList.add(midto);
						}
						// JavaScript를 사용하여 "닫기" 버튼을 강제로 클릭
						String scriptClose = "document.querySelector('.ico_comm').click();";
						((JavascriptExecutor) driver).executeScript(scriptClose);
					}
					if(startPage==1) {
						startPage++;
					}
					String xpathExpressionPage = "//a[contains(@onclick, 'goPage(" + i + ")')]";
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(By.xpath(xpathExpressionPage))); // 페이지 번호 링크 클릭
				}

				WebElement nextButton = driver.findElement(By.cssSelector(".btn.next"));
				if (nextButton.isEnabled()) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
					// 페이지 이동 후 잠시 대기
					startPage+=10;
					endPage+=10;
					Thread.sleep(10000); 
				} else {
					logger.info("다음 페이지 없음");
					hasNextPage = false;
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return miList;
	}

}