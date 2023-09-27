package com.ZMS.genericUtiliti;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consists of methods to fetch common data from property file
 * @author Abhishek
 */
public class FileUtility {

	
	/**
	 * This method is used to fetch common data present inside the property files
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis =new FileInputStream(IPathConstants.propertyFilePath);
		Properties p =new Properties();
		p.load(fis);
		return p.getProperty(key);
		
	}
}
