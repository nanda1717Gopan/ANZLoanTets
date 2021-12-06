package loanCalculatorStepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseClass {
	
	public static WebDriver driver = null;
	
	public static void initialize() {
		
		if (driver == null) {
			if (ConstantVariable.browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", ConstantVariable.chromeDriverPath);
				driver = new ChromeDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void close() {
		driver.close();
		driver = null;
	}
	public static void getPage(String url) {
		driver.get(url);
	}

}
