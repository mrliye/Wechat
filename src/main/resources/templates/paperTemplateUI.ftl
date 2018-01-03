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

			<form class="layui-form" action="sendPaperMsg.action" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">大标题</label>
					<div class="layui-input-inline">
						<input type="text" name="msgs[head]" lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">正文标题</label>
					<div class="layui-input-inline">
						<input type="text" name="msgs[title]" lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">阅读心情</label>
					<div class="layui-input-inline">
						<input type="text" name="msgs[feel]" lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">备注</label>
					<div class="layui-input-inline">
						<input type="text" name="msgs[remark]" autocomplete="off" class="layui-input">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">消息接收人</label>
					<div class="layui-input-block">
						<input type="radio" name="sendType" value="all" title="所有人" >
						<input type="radio" name="sendType" value="boss" title="大领导">
						<input type="radio" name="sendType" value="leader" title="部门领导">
						<input type="radio" name="sendType" value="worker" title="员工">
						<#--<input id="someuser" type="radio" name="sendType" value="some" id="someuser" title="自选" checked="">-->
                        <#--<input type="button" class="layui-btn" onclick="idShowUserList()" value="选人" />-->
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit="" lay-filter="demo1">发送</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
		</div>
		<div id="userList" style="width: 100%;height: 300px;"></div>
		<script type="text/javascript" src="static/plugins/layui/layui.js"></script>
        <script src="static/scripts/jquery-1.9.1.min.js"></script>
        <script>
			layui.use(['form', 'layedit', 'laydate'], function() {
				var form = layui.form(),
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate;

				//自定义验证规则
				form.verify({
					title: function(value) {
						if(value.length < 5) {
							return '标题至少得5个字符啊';
						}
					}
				});

				//监听提交
				form.on('submit(demo1)', function(data) {
					return true;
				});
			});
			//加载用户列表
			//function idShowUserList(){
				//$("#userList").html('<iframe src="showUserList.action" style="width: 100%;height: 100%;"></iframe>')
			//}
		</script>
	</body>

</html>