package com.hotshi.wechat.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotshi.Message;
import com.hotshi.wechat.common.JSSDK_Config;
/** 
* @author  hotshi 
* @date 创建时间：2017年11月14日 下午9:58:16
* @Description: 前端用户微信配置获取
*/

@Controller
@RequestMapping("/wechatconfig/")
public class WeChatController {

   /**
    * @Description: 前端获取微信JSSDK的配置参数
    * @param @param response
    * @param @param request
    * @param @param url
    * @param @throws Exception
    * @author  hotshi 
    * @date 创建时间：2017年11月14日 下午9:58:16
    */
   @RequestMapping("jssdk")
   public void JSSDK_config(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       try {
    	   String url=request.getRequestURL().toString();
           Map<String, String> configMap = JSSDK_Config.jsSDK_Sign(url);
           request.setAttribute("sign",configMap);
           request.getRequestDispatcher("/jssdkconfig.jsp").forward(request, response);
           //System.out.println("url1111111111111:"+url);
       } catch (Exception e) {
    	   System.out.println("====代码有问题额☺！");
       }

   }
}
