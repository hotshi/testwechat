package com.hotshi.wechat.message.req;

/**

 * ClassName: VoiceMessage

 * @Description: 语音消息

 * @author hotshi
  
 * @date 2017年10月20日 下午3:03:59

 */

public class VoiceMessage extends BaseMessage {  

    // 媒体ID   

    private String MediaId;  

    // 语音格式   

    private String Format;  

   

    public String getMediaId() {  

        return MediaId;  

    }  

   

    public void setMediaId(String mediaId) {  

        MediaId = mediaId;  

    }  

   

    public String getFormat() {  

        return Format;  

    }  

   

    public void setFormat(String format) {  

        Format = format;  

    }  

}