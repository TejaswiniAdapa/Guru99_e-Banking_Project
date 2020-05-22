package com.Guru99.e_Banking.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			
			System.out.println("Exception");
		}
		

	}

	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getuname() {
		String userid = pro.getProperty("username");
		return userid;
	}

	public String getPassword() {
		String userpwd = pro.getProperty("password");
		return userpwd;
	}

	public String getchromepath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getfirefoxpath() {
		String firfoxpath = pro.getProperty("firefox");
		return firfoxpath;
	}

}
