package com.hotshi.test;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.hotshi.web.util.GlobalConstants;
import com.hotshi.wechat.menu.ClickButton;
import com.hotshi.wechat.menu.ViewButton;
import com.hotshi.wechat.util.HttpUtils;
import net.sf.json.JSONArray;

public class MenuMain {
public static String create_menu_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
   public static void main(String[] args) throws Exception {
       try{
		   String accessToken=GlobalConstants.getInterfaceUrl("access_token");
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
       //System.out.println(menujson);
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
}