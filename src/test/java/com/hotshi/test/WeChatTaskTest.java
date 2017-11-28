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
import com.hotshi.wechat.util.HttpUtils;
import org.junit.Test;
/**
* ClassName: WeChatTask
* @Description: 微信两小时定时任务体
* @author dapengniao
* @date 2016年3月10日 下午1:42:29
*/

public class WeChatTaskTest {
   /**
    * @Description: 任务执行体
    * @param @throws Exception
    * @author dapengniao
    * @date 2016年3月10日 下午2:04:37
    */
	private static String access_token="";
	@Test
   public void getToken_getTicket() throws Exception {
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
       access_token = JSONObject.fromObject(jstoken).getString(
               "access_token"); // 获取到token并赋值保存
       GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
               System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token==============="+access_token);
      }
}

