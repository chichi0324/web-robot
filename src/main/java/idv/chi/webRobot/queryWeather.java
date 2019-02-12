package idv.chi.webRobot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class queryWeather 
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
		
		driver.findElement(By.className("gLFyf")).sendKeys("中央氣象局");//搜尋輸入"中央氣象局" (ClassName找元素)
		driver.findElement(By.name("btnK")).submit();//點擊"Google 搜尋" (name找元素)

		Thread.sleep(500);//延遲0.5秒
		elements=driver.findElements(By.tagName("h3"));//搜尋出來的結果 (tagName找元素)
		if(elements.size()>0){
			elements.get(0).click();//點擊搜尋結果的第一個(天氣預報 - 中央氣象局)
		}
		
		driver.findElement(By.linkText("國家公園")).click();//點擊"國家公園"連結
		driver.findElement(By.partialLinkText("墾丁")).click();//點擊"含""墾丁"連結(欲查詢墾丁國家公園)
				
	}

}
