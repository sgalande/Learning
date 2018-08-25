package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class DynamicTestNG {
	public void runTestNGTest(List<Map<String, String>> allMaps) {
		TestNG myTestNG = new TestNG();

		// Create an instance of XML Suite and assign a name for it.
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("MySuite");
		mySuite.setParallel(XmlSuite.ParallelMode.TESTS);
		mySuite.addListener("utility.ReportGenrator");

		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest = new XmlTest(mySuite);
		myTest.setName("ChromeTests");

		// Add any parameters that you want to set to the Test.
		myTest.setParameters(allMaps.get(0));

		// Create an instance of XmlTest and assign a name for it.
		XmlTest myTest2 = new XmlTest(mySuite);
		myTest2.setName("FireFoxTests");

		// Add any parameters that you want to set to the Test.
		myTest2.setParameters(allMaps.get(1));

		// Create a list which can contain the classes that you want to run.
		List<XmlClass> myClasses = new ArrayList<XmlClass>();
		myClasses.add(new XmlClass("scripts.web.Login"));

		// Assign that to the XmlTest Object created earlier.
		myTest.setXmlClasses(myClasses);
		myTest2.setXmlClasses(myClasses);

		// Create a list of XmlTests and add the Xmltest you created earlier to
		// it.
		List<XmlTest> myTests = new ArrayList<XmlTest>();
		myTests.add(myTest);
		myTests.add(myTest2);

		// add the list of tests to your Suite.
		mySuite.setTests(myTests);

		// Add the suite to the list of suites.
		List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		mySuites.add(mySuite);

		// Set the list of Suites to the testNG object you created earlier.
		myTestNG.setXmlSuites(mySuites);
		mySuite.setFileName("myTemp.xml");
		//myTestNG.run();

		// Create physical XML file based on the virtual XML content
		for (XmlSuite suite : mySuites) {
			createXmlFile(suite);
		}
		System.out.println("Filerated successfully.");

	}

	// This method will create an Xml file based on the XmlSuite data
	public void createXmlFile(XmlSuite mSuite) {
		FileWriter writer;
		try {
			writer = new FileWriter(new File("myTemp.xml"));
			writer.write(mSuite.toXml());
			writer.flush();
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Main Method
	public static void main(String args[]) {
		DynamicTestNG dt = new DynamicTestNG();

		// This Map can hold your testng Parameters.
		List<Map<String, String>> allMaps = new ArrayList<Map<String, String>>();

		Map<String, String> chromeParam = new HashMap<String, String>();
		chromeParam.put("browser", "chrome");

		Map<String, String> firefoxparam = new HashMap<String, String>();
		firefoxparam.put("browser", "IE");

		allMaps.add(chromeParam);
		allMaps.add(firefoxparam);

		dt.runTestNGTest(allMaps);
	}
}
