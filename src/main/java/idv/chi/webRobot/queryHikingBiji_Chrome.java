package idv.chi.webRobot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 需要打開瀏覽器(ex:Chrome)
 *
 */
public class queryHikingBiji_Chrome 
{
	private static WebDriver driver;
	private static WebElement element;
	private static JavascriptExecutor jse;
	private static List<WebElement> elements;
	
	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.chrome.driver", "driver/chromedriver_win.exe");// 導入chromedriver for window
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver_mac");// 導入chromedriver for mac
		
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		driver.get("https://www.google.com/");// 開啟google
		
		driver.findElement(By.className("gLFyf")).sendKeys("健行筆記");//搜尋輸入"健行筆記" 
		driver.findElement(By.name("btnK")).submit();//點擊"Google 搜尋" 

		Thread.sleep(500);//延遲0.5秒
		elements=driver.findElements(By.tagName("h3"));//搜尋出來的結果(標籤h3)
		if(elements.size()>0){
			elements.get(0).click();//點擊搜尋結果的第一個(健行筆記)
		}
		
		driver.findElement(By.linkText("路線")).click();//點擊 連結"路線"	
		
		Thread.sleep(500);
		
		//選擇"時間" -->兩天以上(所有時間裡，點選"兩天以上")
		elements=driver.findElement(By.id("time_filter")).findElements(By.tagName("li"));
		for(WebElement e:elements){
			if("兩天以上".equals(e.getAttribute("data-value"))){
				e.click();
			}
		}
		
		//選擇"類型" -->百岳(所有類型裡，點選"百岳")
		elements=driver.findElement(By.id("type_filter")).findElements(By.tagName("li"));
		for(WebElement e:elements){
			if("百岳".equals(e.getAttribute("data-value"))){
				e.click();
			}
		}
		
		//搜尋框輸入"嘉明湖"
		driver.findElement(By.xpath("//*[@id='wrap']/div/main/div[3]/div[1]/div[2]/div/input")).sendKeys("嘉明湖");
		driver.findElement(By.linkText("搜尋")).click();//點擊 連結"搜尋"
		
		driver.findElements(By.partialLinkText("嘉明湖")).get(0).click();//點擊"含""嘉明湖"第一個連結
		
		Thread.sleep(3500);
		driver.quit(); //關閉及釋放driver
				
	}

}
