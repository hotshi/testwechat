package com.hotshi.wechat.common;

import java.security.MessageDigest;

import java.util.Formatter;

import java.util.HashMap;

import java.util.UUID;

import com.hotshi.web.util.GlobalConstants;



/**
* ClassName: JSSDK_Config
* @Description: 用户微信前端页面的jssdk配置使用
* @author hotshi
* @date 2017年11月14日21:49:00
*/

public class JSSDK_Config {

   /**
    * @Description: 前端jssdk页面配置需要用到的配置参数
    * @param @return hashmap {appid,timestamp,nonceStr,signature}
    * @param @throws Exception   
    * @author hotshi
    * @date 2017年11月14日21:49:00
    */
   public static HashMap<String, String> jsSDK_Sign(String url) throws Exception {
       String nonce_str = create_nonce_str();
       //String timestamp=GlobalConstants.getInterfaceUrl("timestamp");
       String timestamp = create_timestamp();
       String jsapi_ticket=GlobalConstants.getInterfaceUrl("jsapi_ticket");
       // 注意这里参数名必须全部小写，且必须有序
       String  string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str
               + "&timestamp=" + timestamp  + "&url=" + url;
       //System.out.println("string1::"+string1);
       MessageDigest crypt = MessageDigest.getInstance("SHA-1");
       crypt.reset();
       crypt.update(string1.getBytes("UTF-8"));
       String signature = byteToHex(crypt.digest());
       HashMap<String, String> jssdk=new HashMap<String, String>();
       jssdk.put("appId", GlobalConstants.getInterfaceUrl("appid"));
       //System.out.println("appId::"+GlobalConstants.getInterfaceUrl("appid"));
       jssdk.put("timestamp", timestamp);
       //System.out.println("timestamp::"+timestamp);
       jssdk.put("nonceStr", nonce_str);
       //System.out.println("nonceStr::"+nonce_str);
       jssdk.put("signature", signature);
       //System.out.println("signature::"+signature);
       jssdk.put("url", url);
       //System.out.println("url::"+url);
       return jssdk;
   }
    
   private static String byteToHex(final byte[] hash) {
       Formatter formatter = new Formatter();
       for (byte b : hash) {
           formatter.format("%02x", b);
       }
       String result = formatter.toString();
       formatter.close();
       return result;
   }
    
   private static String create_nonce_str() {
       return UUID.randomUUID().toString();
   }
   private static String create_timestamp() {
	   return Long.toString(System.currentTimeMillis() / 1000);
   }
}
