package parallel;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.base.BaseClass;
import com.utility.configreader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {
	
	configreader cf = new configreader();
	Properties prop ;
	String browser;
	BaseClass bc = new BaseClass();
	WebDriver driver;
	
	
	@Before(order =0)
	public void bef0() throws IOException {
		
		prop = cf.configread();
		browser = prop.getProperty("browser");
	}
	
	@Before(order=1)
	public void bef1() {
		driver = bc.init(browser);
	}
	
	
	@After
	public void aft(Scenario sc) throws InterruptedException, IOException {
		if (sc.isFailed()) {
			TakesScreenshot src = (TakesScreenshot)driver;
			 byte[] src1 = src.getScreenshotAs(OutputType.BYTES);
			 sc.attach(src1, "image/png", sc.getName());
		}
		
		String[] cmd = {"cmd.exe",  "/C", "Start", "reportgeneration.bat"};
		Runtime.getRuntime().exec(cmd).waitFor();
		
		driver.quit();
	}

}
