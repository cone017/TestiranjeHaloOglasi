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

public class TestONama {

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
	  public void oNama() throws Exception {  
		  driver.get("https://www.halooglasi.com");
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[1]/div[5]/div/section/div[2]/div[2]/a")).click();
		  Thread.sleep(2000);
		  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  driver.findElement(By.xpath("/html/body/div[3]/div[5]/footer/div/div/div[2]/div[2]/ul/li[2]/a")).click();
		  
		  
		  String text = "Ime testa: TestONama\nDeskripcija: Automatsko testiranje otvaranje stranice o nama\nTest successful\n\n";
		    
			log.info(text);
			File dir = new File("C:\\Users\\Dell\\eclipse-workspace\\Testiranje2\\Projekat2\\src\\Reports");
			File reportFile = new File(dir,"TestONama-report.txt");
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