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

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/java/testdemo/getAPI.feature", glue = {
//		"StepDefinition" }, tags = "@karatedemo2", monochrome = true, plugin = { "json:target/cucumber.json","pretty:target/cucumber-pretty.txt", "junit:target/cucumber-results.xml" }

//)

@SuppressWarnings("deprecation")
@KarateOptions(tags = {"~@ignore"})
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

	   public static void generateReport(String karateOutputPath) {
	       Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
	       List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
	       jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
	       Configuration config = new Configuration(new File("report"), "karate demo");
	       ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
	       reportBuilder.generateReports();
	   }


}
