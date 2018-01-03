<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>表单</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">

		<link rel="stylesheet" href="static/plugins/layui/css/layui.css" media="all" />
		<link rel="stylesheet" href="static/plugins/font-awesome/css/font-awesome.min.css">
	</head>

	<body>
		<div style="margin: 15px;">
			<input type="button" class="layui-btn" onclick="sendMsg()" value="发送" />
		</div>
		<div id="userList" style="width: 100%;height: 300px;"></div>
		<script type="text/javascript" src="static/plugins/layui/layui.js"></script>
        <script src="static/scripts/jquery-1.9.1.min.js"></script>
        <script>
			function sendMsg(){
			    $.post("sendGeneralMsg.action",{'templateId':'wl9gg8ZmzxXhmQBNKvemD6yCioeKCW_vVKBff6RbV10','sendType':'all','msgs[head]':'爆炸新闻','msgs[title]':'java100出来啦','msgs[date]':'2111-11-11 08:08:08','msgs[feel]':'有点小激动','msgs[remark]':'大家一起围观啊'},function (data){
			        console.log(data);
                });
			}
		</script>
	</body>

</html>