package projekat;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestProveraBrojaOmiljenih {

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
	  public void BrojOmiljenih() throws Exception {
	  
		  driver.get("https://www.halooglasi.com");
		    driver.manage().window().maximize();
		    Thread.sleep(2000);
		    driver.findElement(By.className("cookie-policy-btn")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[5]/div/section/div[2]/div[2]/a")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//input[@id='EMailOrUsername']")).sendKeys("nemanjica123456");
		    driver.findElement(By.id("Password")).sendKeys("paprika2001");
		    driver.findElement(By.cssSelector(".btn-main")).click();
		    Thread.sleep(3000);
		    
		    String broj = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div/div/div/div/div[1]/div[2]/ul/li[3]/a/i")).getText();
		    
		    int broj2 = Integer.parseInt(broj);
		    
		    assertEquals(4, broj2);
		    
		    String text = "Ime testa: TestProveraBrojaOmiljenih\nDeskripcija: Automatsko testiranje provere ukupnog broja omiljenih oglasa\nTest successful\n\n";
		    
			log.info(text);
			File dir = new File("C:\\Users\\Dell\\eclipse-workspace\\Testiranje2\\Projekat2\\src\\Reports");
			File reportFile = new File(dir,"TestProveraBrojaOmiljenih-report.txt");
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