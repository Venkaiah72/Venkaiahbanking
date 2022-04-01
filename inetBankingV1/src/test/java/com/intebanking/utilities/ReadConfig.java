package com.intebanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	// Constructor
	public ReadConfig() {

		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exceotion is " + e.getMessage());

		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;

	}

	public String getuserName() {
		String url = pro.getProperty("username");
		return url;

	}

	public String getPassword() {
		String url = pro.getProperty("password");
		return url;

	}

	public String getchromePath() {
		String url = System.getProperty("user.dir") + pro.getProperty("chromepath");
		System.out.println(url);
		return url;
	}

	public String firefoxpath() {
		String url = pro.getProperty("firefoxpath");
		return null;
	}
}
