package com.hotshi.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.json.JSONObject;

import com.hotshi.web.util.GlobalConstants;
import com.hotshi.wechat.menu.ClickButton;
import com.hotshi.wechat.menu.ViewButton;
import com.hotshi.wechat.util.HttpUtils;
import net.sf.json.JSONArray;

public class MenuTest {
	private static String accessToken="";
   public static void main(String[] args) throws Exception {
	   String create_menu_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

       try{
    	   accessToken=getToken();
		 //2.获取请求的url  
	        create_menu_url = create_menu_url.replace("ACCESS_TOKEN", accessToken);
	        System.out.println("accessToken:"+accessToken);
	   }
       catch(Exception e){
           System.out.println("请求错误111！");
       }
       ClickButton cbt=new ClickButton();
       cbt.setKey("image");
       cbt.setName("回复图片");
       cbt.setType("click");
        
        
       ViewButton vbt=new ViewButton();
       vbt.setUrl("http://v7dnxuw.hk1.mofasuidao.cn/testwechat/wechatconfig/jssdk");
       vbt.setName("jssdk");
       vbt.setType("view");
        
       JSONArray sub_button=new JSONArray();
       sub_button.add(cbt);
       sub_button.add(vbt);
        
        
       JSONObject buttonOne=new JSONObject();
       buttonOne.put("name", "菜单");
       buttonOne.put("sub_button", sub_button);
        
       JSONArray button=new JSONArray();
       button.add(vbt);
       button.add(buttonOne);
       button.add(cbt);
        
       JSONObject menujson=new JSONObject();
       menujson.put("button", button);
       System.out.println("menujson:"+menujson);
       //这里为请求接口的url   +号后面的是token，这里就不做过多对token获取的方法解释
       /*String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+
       "aHnKrTutg5YPEX_K1xGUmiVjy0s_gPDK7m0qpsrdjIxSWg9BF_oYrunDlfysLb92H153qLi_b0hW0Ja7OOUhkI8AR9i0-1jynqcuZrFWAGq1Qkfou2-TtWq8OkN7E44iUUZjAHACCH";
        */
       try{
           String rs=HttpUtils.sendPostBuffer(create_menu_url, menujson.toString());
           System.out.println(rs);
       }catch(Exception e){
           System.out.println("请求错误！");
       }
   }
   
   public static String getToken() throws Exception {
       Map<String, String> params = new HashMap<String, String>();
       
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
       params.put("grant_type", "client_credential");
       params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
       params.put("secret", GlobalConstants.getInterfaceUrl("AppSecret"));
        String jstoken = HttpUtils.sendGet(
               GlobalConstants.getInterfaceUrl("tokenUrl"), params);
        accessToken = JSONObject.fromObject(jstoken).getString(
               "access_token"); // 获取到token并赋值保存
       GlobalConstants.interfaceUrlProperties.put("accessToken", accessToken);
               System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token==============="+accessToken);
			return accessToken;
      }
}