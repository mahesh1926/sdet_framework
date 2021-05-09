package com.crm.vtiget.GenericUtilities;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FileUtility {
	/*
	 * this method used to read data from properties
	 * returns the values based on key specified
	 * @para key
	 * @para return value
	 * @throws throwable
	 */
	
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream file=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(key);
		
	}
	/*
	 * this method return json value
	 * @par jsonkey
	 * jsonvalue
	 * throwable
	 */
	
	public String getDatafromJson(String jsonkey) throws Throwable 
	{
		FileReader reader=new FileReader(IPathConstant.JSONFILEPATH);
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsonobject=(JSONObject)object;
		String value=jsonobject.get(jsonkey).toString();
		return value;	
					
	}

}
