package testdemo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Parellelbuildwithcucumber {
	
	
	
	@Test
	   public void testParallel() {
	       Results results = Runner.path("classpath:testdemo/getAPI.feature")
	               .outputCucumberJson(true)
	               .karateEnv("karate demo")
	               .parallel(1);
	       generateReport(results.getReportDir());
	       assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
	   }

	   public static void generateReport(String karateOutputPath) {
	       Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
	       List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
	       jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
	       Configuration config = new Configuration(new File("report"), "karate demo");
	       ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
	       reportBuilder.generateReports();
	   }


}