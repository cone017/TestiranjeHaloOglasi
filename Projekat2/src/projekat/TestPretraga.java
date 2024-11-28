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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPretraga {

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
	  public void search() throws Exception {
		  driver.get("https://www.halooglasi.com");
		  driver.manage().window().maximize();
		  
		  driver.findElement(By.id("search-query")).sendKeys("fotelja");
		  driver.findElement(By.id("search-query")).sendKeys(Keys.ENTER);
		  
		  String text = "Ime testa: TestPretraga\nDeskripcija: Automatsko testiranje pretrage\nTest successful\n\n";
		    
		  log.info(text);
		  File dir = new File("C:\\Users\\Dell\\eclipse-workspace\\Testiranje2\\Projekat2\\src\\Reports");
		  File reportFile = new File(dir,"TestPretraga-report.txt");
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
