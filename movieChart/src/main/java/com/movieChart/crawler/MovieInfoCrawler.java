package com.movieChart.crawler;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

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

public class MovieInfoCrawler {
	private static final Logger logger = LoggerFactory.getLogger(MovieInfoCrawler.class);

	private static final String CRAWLER_URL = "http://kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do?dtTp=movie&dtCd=";
	private static final String CRAWLER_URL2 = "http://kobis.or.kr/kobis/business/mast/mvie/searchMovieList.do";

//	public MovieDTO crawlWeb(String parameter) {
//
//		MovieDTO midto = new MovieDTO();
//
//		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//
//		driver.get(CRAWLER_URL + parameter);
//
//		try {
//			WebElement image = driver.findElement(By.cssSelector(".fl.thumb"));
//			WebElement synopsis = driver.findElement(By.cssSelector(".desc_info"));
//
//			String imageUrl = image.getAttribute("src");
//			String synopsisText = synopsis.getText();
//
//			logger.debug(imageUrl);
//			logger.debug(synopsisText);
//
//			midto.setImage(imageUrl);
//			midto.setSynopsis(synopsisText);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			driver.quit();
//		}
//
//		return midto;
//	}

	public Set<MovieDTO> crawlMovie(List<String> mList) throws Exception {
		Set<MovieDTO> miSet = new HashSet<MovieDTO>();
		Queue<String> alreadyCrawledQueue= new LinkedList<>();

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win32\\chromedriver.exe");//window 119.0.6045.105
//		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");//lunix 2.37.544315 
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofSeconds(30));
		driver.get(CRAWLER_URL2);

		try {
			loop:
			for (int i = 1;; i++) {
				for (int j = 1; j < 11; j++) {
					if(alreadyCrawledQueue.size()==10) {
						break loop;
					}
					((JavascriptExecutor) driver).executeScript("goPage(arguments[0]);", String.valueOf(i));
					Thread.sleep(2000);
					
					String xpathExpressionMovieCode = "(//tr//td[3])[" + j + "]";
					WebElement MovieCodeElement = wait
							.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpressionMovieCode)));
					String movieCode = MovieCodeElement.getText();

					if (!mList.contains(movieCode)) {
						alreadyCrawledQueue.poll();
						
						String xpathExpressionView = "(//tr//td[1]//a[contains(@onclick, 'mstView')])[" + j + "]";
						String xpathExpressionProdYear = "(//tr//td[4])[" + j + "]";
						String xpathExpressionGenre = "(//tr//td[7])[" + j + "]";
						String xpathExpressionDirector = "(//tr//td[9])[" + j + "]";

						WebElement mstViewLink = wait
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpressionView)));
						WebElement prodYearElement = wait
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpressionProdYear)));
						WebElement GenreElement = wait
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpressionGenre)));
						WebElement DirectorElement = wait
								.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpressionDirector)));

						MovieDTO midto = new MovieDTO();

						String title = mstViewLink.getText();
						String genre = GenreElement.getText();
						String director = DirectorElement.getText();

						midto.setTitle(title);
						midto.setCode_no(movieCode);
						midto.setDirector(director);
						midto.setGenre(genre);
						if (!(prodYearElement.getText().equals("") || prodYearElement == null)) {
							int prodYear = Integer.parseInt(prodYearElement.getText());
							midto.setProd_year(prodYear);
						}
						mstViewLink.click();

						// 페이지 로딩을 기다림
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".fl.thumb")));
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.desc_info")));
						wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".tit")));

						WebElement aTag = driver.findElement(By.cssSelector(".fl.thumb"));
						WebElement synopsis = driver.findElement(By.cssSelector(".desc_info"));
						WebElement imgTag = aTag.findElement(By.tagName("img"));
						String imageUrl = imgTag.getAttribute("src");

						String synopsisText = synopsis.getText();

						logger.debug(imageUrl);
						logger.debug(synopsisText);

						midto.setImage(imageUrl);
						midto.setSynopsis(synopsisText);
						miSet.add(midto);

						// JavaScript를 사용하여 "닫기" 버튼을 강제로 클릭
						((JavascriptExecutor) driver).executeScript("dtlRmAll();");
					}else {
						alreadyCrawledQueue.add(movieCode);
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
		return miSet;
	}

}