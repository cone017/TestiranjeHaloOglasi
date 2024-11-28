package projekat;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.text.SimpleDateFormat;
public class TestRegistracija {
	
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  private SimpleDateFormat formatter;
  private Date date;
  private Logger log = Logger.getLogger(TestRegistracija.class.getName());
  private String exePath ="C:\\Users\\Dell\\eclipse-workspace\\Testiranje2\\Projekat2\\Biblioteke\\geckodriver.exe";
  
  @Before
  public void setUp() {
	  System.setProperty("webdriver.chrome.driver", exePath);
		formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		date = new Date(); 
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
  }

  @Test
  public void registracija() throws Exception {
    driver.get("https://www.halooglasi.com");
    driver.manage().window().maximize();
    Thread.sleep(2000);
    driver.findElement(By.className("cookie-policy-btn")).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[5]/div/section/div[2]/div[2]/a")).click();
    Thread.sleep(5000);
    driver.findElement(By.className("no-account-reg-link")).click();
    Thread.sleep(5000);
    driver.findElement(By.id("UserName")).sendKeys("nemanjica123456");
    driver.findElement(By.id("Email")).sendKeys("nemanjamijajlovic2001@gmail.com");
    driver.findElement(By.id("Password")).sendKeys("paprika2001");
    driver.findElement(By.id("ConfirmPassword")).sendKeys("paprika2001");
    driver.findElement(By.id("HasAgreedToGetFiscalReceiptByEmail")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.button-reg:nth-child(1)")).click();
    
    String text = "Ime testa: TestRegistracija\nDeskripcija: Automatsko testiranje registracije\nTest successful\n\n";
    
	log.info(text);
	File dir = new File("C:\\Users\\Dell\\eclipse-workspace\\Testiranje2\\Projekat2\\src\\Reports");
	File reportFile = new File(dir,"TestRegistracija-report.txt");
	if (!dir.exists() && !reportFile.exists()) {
		  dir.mkdir();
	      try {
	          reportFile.createNewFile();
	      } catch (IOException e) {
	          System.out.println("Error creating file: " + e.getMessage());
	      }
	  }
	  
	try (FileWriter fw = new FileWriter(reportFile, true)) {
	    fw.write(formatter.format(date) + "\n");
	    fw.write(text);
	} catch (IOException e) {
	    System.out.println("Error writing to file: " + e.getMessage());
	}
  }
}