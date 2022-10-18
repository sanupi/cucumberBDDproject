package utilites;

import java.io.FileInputStream;

import java.util.Properties;

public class Readconfig {
	


Properties properties;

		String path = "config.properties";

		//constructor
		public Readconfig() {
			try {
				properties = new Properties();

				
				//to open config .properties file in input mode and load the file
				FileInputStream  fis = new FileInputStream(path);
				properties.load(fis);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		public String getBrowser()
		{
			String value = properties.getProperty("browser");

			if(value!=null)
				return value;
			else
				throw new RuntimeException("url not specified in config file.");

		}
		
	}



