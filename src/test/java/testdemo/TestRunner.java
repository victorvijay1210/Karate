package testdemo;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import com.intuit.karate.junit5.Karate;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;



public class TestRunner {
	
	@Karate.Test
	Karate getAPItest() {
		return Karate.run("getAPI").relativeTo(getClass());
	}
	
	@Karate.Test
	Karate deleteAPItest() {
		return Karate.run("delete").relativeTo(getClass());
	}

   

	
}
