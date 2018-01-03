<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="static/bootstrap2.3.2/css/bootstrap.min.css" rel="stylesheet" />
    <title></title>
    <link href=" static/styles/Common.css" rel="stylesheet" />
    <link href=" static/styles/Index.css" rel="stylesheet" />
</head>
<body>
    <div class="header">

        <img class="logo" src=" static/images/logo.png" />
        <label class="logo-title">微信服务</label>
        <ul class="inline">
            <li>
                <img src=" static/images/32/client.png" />&nbsp;&nbsp;欢迎您,Admin
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle mymsg" data-toggle="dropdown" href="#"><img src=" static/images/32/166.png" />&nbsp;&nbsp;修改个人信息<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="form1.html" target="right">修改密码</a></li>
                </ul>

            </li>
            <li>
                <img src=" static/images/32/200.png" />&nbsp;&nbsp;<a class="loginout" href="#">退出</a>
            </li>

        </ul>


    </div>


    <div class="nav">

        <ul class="breadcrumb">
            <li>
                <img src=" static/images/32/5025_networking.png" />
            </li>
            <li><a href="getmain" target="right">首页</a> <span class="divider">>></span></li>
            <li class="active"></li>
        </ul>
    </div>



    <div class="container-fluid content">
        <div class="row-fluid">
            <div class="span2 content-left">
                <div class="accordion">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                                <img class="left-icon" src=" static/images/32/people.png" /><span class="left-title">发送模板消息</span>
                            </a>
                        </div>
                        <div id="collapseOne" class="accordion-body collapse">
                            <div class="accordion-inner">
                                <a href="toPaperTemplateUI.html" target="right"><img class="left-icon-child" src=" static/images/32/99.png" /><span class="left-body"> 消息模板1</span></a>
                            </div>
                            <div class="accordion-inner">
                                <a href="toPeneralTemplateUI.html" target="right"><img class="left-icon-child" src=" static/images/32/4957_customers.png" /><span class="left-body">通用模板</span></a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <div class="span10 content-right" >
                <iframe src="getmain" class="iframe" name="right" scrolling="no"></iframe>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
    <div class="foot"></div>
    <script src="static/scripts/jquery-1.9.1.min.js"></script>
    <script src="static/bootstrap2.3.2/js/bootstrap.min.js"></script>
    <script src="static/scripts/Index.js"></script>
	<div style="text-align:center;">
</div>

</body>
</html>
