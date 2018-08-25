package utility;

import java.util.HashMap;

public class Locator {

	static class Keys {
		private static String SEARCHBY = "searchBy";
		private static String SEARCHVALUE = "searchValue"; 
	}
	
	private static class Values {
		private static String LINKTEXT = "linktext";
		private static String ID = "id";
		private static String NAME = "name";
		private static String XPATH = "xpath";
		private static String CSSSELECTOR = "cssselector";
		private static String TAGNAME = "tagname";
		private static String CLASSNAME = "classname";
		private static String PARTIALLINKTEXT = "partiallinktext";
	}
	
	public static HashMap<String, String>byLinkText(String linkText) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.LINKTEXT);
		params.put(Keys.SEARCHVALUE, linkText);
		return params;
	}
	
	public static HashMap<String, String>byId(String id) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.ID);
		params.put(Keys.SEARCHVALUE, id);
		return params;
	}
	
	public static HashMap<String, String>byName(String name) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.NAME);
		params.put(Keys.SEARCHVALUE, name);
		return params;
	}
	
	public static HashMap<String, String>byXpath(String xpath) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.XPATH);
		params.put(Keys.SEARCHVALUE, xpath);
		return params;
	}
	
	public static HashMap<String, String>byCssSelector(String cssSelector) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.CSSSELECTOR);
		params.put(Keys.SEARCHVALUE, cssSelector);
		return params;
	}
	
	public static HashMap<String, String>byTagName(String tageName) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.TAGNAME);
		params.put(Keys.SEARCHVALUE, tageName);
		return params;
	}
	
	public static HashMap<String, String>byClassName(String classname) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.CLASSNAME);
		params.put(Keys.SEARCHVALUE, classname);
		return params;
	}
	
	public static HashMap<String, String>byPartialLinkText(String partiallinkText) {
		HashMap<String, String> params = new HashMap<>();
		params.put(Keys.SEARCHBY, Values.PARTIALLINKTEXT);
		params.put(Keys.SEARCHVALUE, partiallinkText);
		return params;
	}
}
