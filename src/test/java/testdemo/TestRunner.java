package testdemo;

import java.io.File;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/testdemo/getAPI.feature", glue = {
		"testdemo" }, tags = "@karatedemo2", monochrome = true, plugin = { "json:target/cucumber.json"}
)
////
//@SuppressWarnings("deprecation")
//@KarateOptions(tags = {"~@ignore"})
public class TestRunner {
	
	
	
	@Test
	   public void testParallel() {
	       Results results = Runner.path("classpath:testdemo/getAPI.feature")
	               .outputCucumberJson(true)
	               .karateEnv("karate demo")
	               .parallel(1);
	       generateReport(results.getReportDir());
	       assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
	   }

	@SuppressWarnings("unchecked")
	public static void generateReport(String karateOutputPath) {
		Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
		@SuppressWarnings("rawtypes")
		List<String> jsonPaths = new ArrayList(jsonFiles.size());
		jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
		Configuration config = new Configuration(new File("target"), "karateTesting");
		ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
		reportBuilder.generateReports();
		    }


}
