<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>接入微信JSSDK</title>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <head>
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
    <script src="js/jquery-3.2.1.min.js"></script>
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript">
	$(function(){
		var appId=$("#appId").val();
		var nonceStr=$("#nonceStr").val();
		var timestamp=$("#timestamp").val();
		var signature=$("#signature").val();
				wx.config({
			      debug: true,
			      appId: appId,
			      timestamp: timestamp,
			      nonceStr: nonceStr,
			      signature: signature,
			      jsApiList: [ 'checkJsApi', 'onMenuShareTimeline',
			                   'onMenuShareAppMessage', 'onMenuShareQQ',
                            'onMenuShareWeibo', 'hideMenuItems',
                            'showMenuItems', 'hideAllNonBaseMenuItem',
                            'showAllNonBaseMenuItem', 'translateVoice',
                            'startRecord', 'stopRecord', 'onRecordEnd',
                            'playVoice', 'pauseVoice', 'stopVoice',
                            'uploadVoice', 'downloadVoice', 'chooseImage',
                            'previewImage', 'uploadImage', 'downloadImage',
                            'getNetworkType', 'openLocation', 'getLocation',
                            'hideOptionMenu', 'showOptionMenu', 'closeWindow',
                            'scanQRCode', 'chooseWXPay',
                            'openProductSpecificView', 'addCard', 'chooseCard',
                            'openCard' ]
				  });	
		
		    //在这里写微信相机的接口
		$("#photo").bind("click",function(){
		    	 wx.chooseImage({
		    		    count: 9, // 默认9
		    		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    		    success: function (res) {
		    		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		    		    }
		    		});
		     
		     });
		     		//微信扫一扫
		$("#sao").bind("click",function(){
		    	 wx.scanQRCode({
				    needResult: 0, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
				    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
				    success: function (res) {
				    	var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
					}
				});
 		});     
	});
 
		     
	wx.ready(function () {
			// 2. 分享接口
		  // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
		   wx.onMenuShareAppMessage({
		     title: '菜鸟程序员成长之路！',
		     desc: '关注java平台开发，前后端框架技术，分享前后端开发资源，服务端教程技术，菜鸟程序员！',
		     link: 'http://www.cuiyongzhi.com/',// 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致		     
		     imgUrl: 'http://res.cuiyongzhi.com/2016/03/201603201591_339.png',
		     trigger: function (res) {
		       // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
		       alert('用户点击发送给朋友');
		     },
		     success: function (res) {
		       alert('已分享');
		     },
		     cancel: function (res) {
		       alert('已取消');
		     },
		     fail: function (res) {
		       alert(JSON.stringify(res));
		     }
		   });
   // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
		 wx.onMenuShareTimeline({
		     title: 'jssdk！',
		     link: 'http://www.sina.com/',
		     imgUrl: 'http://res.cuiyongzhi.com/2016/03/201603201591_339.png',
		     trigger: function (res) {
		       // 不要尝试在trigger中使用ajax异步请求修改本次分享的内容，因为客户端分享操作是一个同步操作，这时候使用ajax的回包会还没有返回
		       alert('用户点击分享到朋友圈');
		     },
		     success: function (res) {
		       alert('已分享');
		     },
		     cancel: function (res) {
		       alert('已取消');
		     },
		     fail: function (res) {
		       alert(JSON.stringify(res));
		     }
		   });
       });
    
 wx.error(function (res) {
  alert(res.errMsg);
});    

</script>
<script type="text/javascript">

</script>
</head>
<body>
     <input type="button" id="photo" value="拍照"/>     
     <input type="button" id="sao" value="扫一扫"/>
     <input id="appId"  type="hidden" value="${sign.appId }"/>
     <input id="url"  type="hidden" value="${sign.url}"/>
     <input id="tk"  type="hidden" value="${sign.jsapi_ticket }"/>     
	<input id="nonceStr" type="hidden" value="${sign.nonceStr }"/>
	<input id="timestamp" type="hidden" value="${sign.timestamp }"/>
	<input id="signature" type="hidden" value="${sign.signature }"/>
  </body>
</html>