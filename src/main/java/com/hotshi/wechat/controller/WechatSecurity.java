package com.hotshi.wechat.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotshi.wechat.dispatcher.EventDispatcher;
import com.hotshi.wechat.dispatcher.MsgDispatcher;
import com.hotshi.wechat.util.MessageUtil;
import com.hotshi.wechat.util.SignUtil;


@Controller

@RequestMapping("/wechat")

public class WechatSecurity {
   private static Logger logger = Logger.getLogger(WechatSecurity.class);

   /**
    * 
    * @Description: 用于接收get参数，返回验证参数
    * @param @param request
    * @param @param response
    * @param @param signature
    * @param @param timestamp
    * @param @param nonce
    * @param @param echostr
    * @author hotshi
    * @date 2017年11月10日16:20:00
    */
   @RequestMapping(value = "security", method = RequestMethod.GET)
   public void doGet(
           HttpServletRequest request,
           HttpServletResponse response,
           @RequestParam(value = "signature", required = true) String signature,
           @RequestParam(value = "timestamp", required = true) String timestamp,
           @RequestParam(value = "nonce", required = true) String nonce,
           @RequestParam(value = "echostr", required = true) String echostr) {
       try {
           if (SignUtil.checkSignature(signature, timestamp, nonce)) {
               PrintWriter out = response.getWriter();
               System.out.println("request=" + request.getRequestURL());  
               out.print(echostr);
               out.close();
           } else {
        	   System.out.println("request=" + request.getRequestURL());  
               logger.info("这里存在非法请求！");
           }
       } catch (Exception e) {
           logger.error(e, e);
       }
   }

   @RequestMapping(value = "security", method = RequestMethod.POST)

   // post方法用于接收微信服务端消息

   public void DoPost(HttpServletRequest request,HttpServletResponse response) {
       try{
    	// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
           request.setCharacterEncoding("UTF-8");
           response.setCharacterEncoding("UTF-8");
           Map<String, String> map=MessageUtil.parseXml(request);
           String msgtype=map.get("MsgType");
           System.out.println("msgtype:"+msgtype);
           System.out.println("REQ_MESSAGE_TYPE_EVENT:"+MessageUtil.REQ_MESSAGE_TYPE_EVENT);
           if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
        	   String msgrsp=EventDispatcher.processEvent(map); //进入事件处理
               //EventDispatcher.processEvent(map); //进入事件处理
               PrintWriter out = response.getWriter();
               out.print(msgrsp);
               out.close();
           }else{
        	// 响应消息  */
        	   String msgrsp=MsgDispatcher.processMessage(map); //进入消息处理
               PrintWriter out = response.getWriter();  
               out.print(msgrsp);  
               out.close(); 
               //MsgDispatcher.processMessage(map); //进入消息处理
           }
       }catch(Exception e){
           logger.error(e,e);
       }
   }
}