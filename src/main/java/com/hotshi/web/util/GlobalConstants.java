package com.hotshi.web.util;

import java.util.Properties;

public class GlobalConstants {

	public static Properties interfaceUrlProperties;

/**
 * 
 * @Description: TODO
 * @param @param key
 * @param @return   
 * @author hotshi
 * @date 2017年11月8日21:22:14
 */
	public static String getInterfaceUrl(String key) {
		//System.out.println("getInterfaceUrl");
		return (String) interfaceUrlProperties.get(key);
	}
	
		
	
}
