package com.hotshi.wechat.message.req;

/**
 * ClassName: ImageMessage
 * @Description: 图片消息
 *	@author hotshi
 *  @date 2017年11月8日10:53:59
 */

public class ImageMessage extends BaseMessage {

    // 图片链接

    private String PicUrl;

 

    public String getPicUrl() {

        return PicUrl;

    }

 

    public void setPicUrl(String picUrl) {

        PicUrl = picUrl;

    }

}