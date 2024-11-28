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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPerformance {

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
	  public void performanse() {
		  
		  double trenutno1 = System.currentTimeMillis();
	  	  driver.get("https://www.halooglasi.com");
	  	  double drugotrenutno1 = System.currentTimeMillis();
	  	  double konacno1 = drugotrenutno1 - trenutno1;
	  	  System.out.println("Pocetna stranica: " + konacno1 + " milisekundi");
		  
	  	  double trenutno2 = System.currentTimeMillis();
	  	  driver.get("https://www.halooglasi.com/o-nama");
	  	  double drugotrenutno2 = System.currentTimeMillis();
	  	  double konacno2 = drugotrenutno2 - trenutno2;
	  	  System.out.println("Stranica o nama: " + konacno2 + " milisekundi");
	  	  
	  	  double trenutno3 = System.currentTimeMillis();
	  	  driver.get("https://www.halooglasi.com/nekretnine");
	  	  double drugotrenutno3 = System.currentTimeMillis();
	  	  double konacno3 = drugotrenutno3 - trenutno3;
	  	  System.out.println("Nekretnine: " + konacno3 + " milisekundi");
	  	  
	  	  double trenutno4 = System.currentTimeMillis();
	  	  driver.get("https://www.halooglasi.com/sport-i-rekreacija");
	  	  double drugotrenutno4 = System.currentTimeMillis();
	  	  double konacno4 = drugotrenutno4 - trenutno4;
	  	  System.out.println("Sport i rekreacija: " + konacno4 + " milisekundi");
	  	  
	  	  double trenutno5 = System.currentTimeMillis();
	  	  driver.get("https://www.halooglasi.com/postavite-oglas");
	  	  double drugotrenutno5 = System.currentTimeMillis();
	  	  double konacno5 = drugotrenutno5 - trenutno5;
	  	  System.out.println("Postavljanje oglasa: " + konacno5 + " milisekundi");
	  	  
	  	  double prosecnoVreme = (konacno1 + konacno2 + konacno3 + konacno4 + konacno5) / 5;
	  	  
	  	String text = "Ime testa: TestPerformance\nDeskripcija: Prosecno vreme ucitavanja pet stranica: " + prosecnoVreme + " milisekundi\n"
	  			+ "\nProsecno vreme ucitavanja pocetne stranice: " + konacno1 + " milisekundi"
	  			+ "\nProsecno vreme ucitavanja stranice o nama: " + konacno2 + " milisekundi"
	  			+ "\nProsecno vreme ucitavanja stranice o nekretninama: " + konacno3 + " milisekundi"
	  			+ "\nProsecno vreme ucitvanja stranice o sportu i rekreaciji: " + konacno4 + " milisekundi"
	  			+ "\nProsecno vreme ucitavnja stranice o postavljanju oglasa: " + konacno5 + "\nTest successful";
	    
		log.info(text);
		File dir = new File("C:\\Users\\Dell\\eclipse-workspace\\Testiranje2\\Projekat2\\src\\Reports");
		File reportFile = new File(dir,"TestPerformance-report.txt");
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