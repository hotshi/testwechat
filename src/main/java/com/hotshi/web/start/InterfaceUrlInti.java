package com.hotshi.web.start;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.hotshi.web.util.GlobalConstants;

public class InterfaceUrlInti {
	public synchronized static void init(){
	       ClassLoader cl = Thread.currentThread().getContextClassLoader();
	       Properties props = new Properties();
	       if(GlobalConstants.interfaceUrlProperties==null){
	           GlobalConstants.interfaceUrlProperties = new Properties();
	       }
	       InputStream in = null;
	       try {
	           in = cl.getResourceAsStream("interface_url.properties");
	           props.load(in);
	           for(Object key : props.keySet()){
	               GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
	               //System.out.println("key");
	           }
	            
	           props = new Properties();
	           in = cl.getResourceAsStream("testwechat.properties");
	           props.load(in);
	           for(Object key : props.keySet()){
	               GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
	           }
	            
	       } catch (IOException e) {
	           e.printStackTrace();
	       }finally{
	           if(in!=null){
	               try {
	                   in.close();
	               } catch (IOException e) {
	                   e.printStackTrace();
	               }
	           }
	       }
	       return;
	}
}