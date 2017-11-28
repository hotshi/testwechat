package com.hotshi.wechat.quartz;

import org.apache.log4j.Logger;


import com.hotshi.wechat.common.WeChatTask;


public class QuartzJob{
   private static Logger logger = Logger.getLogger(QuartzJob.class);
   /**
    * @Description: 任务执行获取token
    * @param    
    * @author hotshi
    * @date 2017年11月13日11:20:00
    */
   public void workForToken() {
       try {
           WeChatTask timer = new WeChatTask();
           timer.getToken_getTicket();
       } catch (Exception e) {
           logger.error(e, e);
       }
   }
}