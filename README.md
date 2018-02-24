

# Wechat_push
微信推送服务
功能：微信模消息推送，将粉丝保存到数据库，（其他功能正在完善，敬请期待）！

准备：
1). download
2). 修改application.properties，配置公众号的appID和appsecret（必填）
3). 修改数据库链接信息

1.将粉丝保存到数据库
1.1运行项目
1.2浏览器访问http://127.0.0.1:8080/saveAllUsers.action；
OK！

2.微信模板消息推送
2.1 需要自己修改页面（generalTemplateUI.ftl），line:27-->
 $.post("sendGeneralMsg.action",
        {'templateId':'模板消息的id','sendType':'all'(发送给所有人),'msgs[模板消息中的参数名]':'此参数所对应的内容',...},
        function (data){console.log(data);});
2.2 运行项目
2.3 浏览器访问http://localhost:8080/loadIndexUI.action ---> 点击 通用模板 --> 点击发送
OK!
(备注：也可根据paperTemplateUI.ftl修改成表单提交)


欢迎指正：微信(Ont147852)
some content 
