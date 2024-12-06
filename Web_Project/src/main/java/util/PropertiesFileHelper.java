package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

public class PropertiesFileHelper {

	public static Properties getProperties(ServletContext context, String filePath) {
		Properties properties = new Properties();
		InputStream is = context.getResourceAsStream(filePath);
		try {
			properties.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties;
	}
}
