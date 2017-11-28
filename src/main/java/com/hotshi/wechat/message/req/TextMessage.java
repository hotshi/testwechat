package com.hotshi.wechat.message.req;

/**

 * ClassName: TextMessage

 * @Description: 文本消息

 * @author hotshi
 * 
 * @date 2017年10月20日 下午3:03:59

 */

public class TextMessage extends BaseMessage {  

    // 消息内容   

    private String Content;  

   

    public String getContent() {  

        return Content;  

    }  

   

    public void setContent(String content) {  

        Content = content;  

    }  

}
