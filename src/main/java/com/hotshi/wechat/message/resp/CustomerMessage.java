package com.hotshi.wechat.message.resp;

/**
* ClassName: CustomerMessage
* @Description: 客服消息接口
* @author hotshi
* @date 2017年11月13日 11:48:04
*/

public class CustomerMessage {
   // 接收方帐号（收到的OpenID）
   private String ToUserName;
   // 开发者微信号
   private String FromUserName;
   // 消息创建时间 （整型）
   private long CreateTime;
   // 消息类型（text/music/news）
   private String MsgType;
   private String Kf_account;
   public String getToUserName() {
       return ToUserName;
   }

   public void setToUserName(String toUserName) {
       ToUserName = toUserName;
   }

   public String getFromUserName() {
       return FromUserName;
   }

   public void setKf_account(String kf_account) {
	   Kf_account = kf_account;
   }
   public String getKf_account() {
       return Kf_account;
   }

   public void setFromUserName(String fromUserName) {
       FromUserName = fromUserName;
   }
   public long getCreateTime() {
       return CreateTime;
   }

   public void setCreateTime(long createTime) {
       CreateTime = createTime;
   }

   public String getMsgType() {
       return MsgType;
   }

   public void setMsgType(String msgType) {
       MsgType = msgType;
   }
}