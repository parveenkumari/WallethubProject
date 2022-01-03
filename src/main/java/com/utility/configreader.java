package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configreader {
	
	Properties prop;
	
	public Properties configread() throws IOException {
	
	    FileInputStream fil = new FileInputStream("C:/Users/kumar/Practiceworkspace/WallethubProject/src/main/resources/com/config/config.properties");
	    Properties prop = new Properties();
        prop.load(fil);
        return prop;
	}
		
	}


