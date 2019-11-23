package idv.chi.webRobot;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 不需要打開瀏覽器
 *
 */
public class queryHikingBiji_Phantomjs {
//	private static PhantomJSDriver driver;
	private static WebElement element;
	private static List<WebElement> elements;
	
	public static void main(String[] args) throws InterruptedException {
		

		//設置參數
        DesiredCapabilities dcaps = new DesiredCapabilities();
        //ssl認證
        dcaps.setCapability("acceptSslCerts", true);
        //截屏支持
        dcaps.setCapability("takesScreenshot", false);
        //css支援
        dcaps.setCapability("cssSelectorsEnabled", true);
        //js支援
        dcaps.setJavascriptEnabled(true);
        //驅動
        dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"driver/phantomjs");

		
		PhantomJSDriver driver = new PhantomJSDriver(dcaps);

		driver.get("https://www.cwb.gov.tw/V7/forecast/entertainment/nationalpark/");// 開啟google
		
		element=driver.findElement(By.className("Forecast-Titlespan"));
		System.out.print("內容："+element.getAttribute("value"));		
		
		driver.quit();
	}

}
