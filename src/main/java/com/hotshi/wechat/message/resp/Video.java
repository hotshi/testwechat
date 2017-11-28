package com.hotshi.wechat.message.resp;
/**

 * ClassName: Video

 * @Description: 视频消息体

 * @author hotshi

 * @date 2017年10月20日 下午3:16:57

 */

public class Video {

 
 private String MediaId;
 private String Title;
 private String Description;

 
 public String getTitle() {
     return Title;
 }

 
 public void setTitle(String title) {
     Title = title;
 }

 
 public String getDescription() {
     return Description;
 }

 
 public void setDescription(String description) {
     Description = description;
 }

 public String getMediaId() {
     return MediaId;
 }

 
 public void setMediaId(String mediaId) {
     MediaId = mediaId;
 }
}