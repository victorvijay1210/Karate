package testdemo;

import com.intuit.karate.junit5.Karate;

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
