package projekat;
import java.util.logging.Logger;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(TestSuite.class);
		
		Logger log = Logger.getLogger(TestRunner.class.toString());
		
		for(Failure f: result.getFailures()) {
			log.warning(f.toString());
		}
		
		log.info("Vreme izvrsavanja: " + result.getRunTime());
		log.info("Broj testova: " + result.getRunCount());
		
		log.info("Uspesno testova: " + (result.getRunCount() - result.getFailureCount()));
		log.info("Palih testova: " + result.getFailureCount());
		log.info("Broj preskocenih: " + result.getIgnoreCount());
		log.info("Broj dinamicki preskocenih: " + result.getAssumptionFailureCount());
		
		if(result.wasSuccessful())
			log.info("Svi testovi su uspesno izvrseni");
		else
			log.warning("Postoje greske u testovima");
	}
}