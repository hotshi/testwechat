package com.hotshi.wechat.message.resp;

/**

 * ClassName: ImageMessage

 * @Description: 图片消息

 * @author hotshi

 * @date 2017年10月20日 下午3:16:57
 */

public class ImageMessage extends BaseMessage{
  
 private Image Image;

 
 public Image getImage() {
     return Image;
 }

 
 public void setImage(Image image) {
     Image = image;
 }
}