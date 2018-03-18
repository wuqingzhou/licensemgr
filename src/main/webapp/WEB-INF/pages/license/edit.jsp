<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/common/common.jsp" %>
<title>license管理系统</title>
</head>

<body>
<h2 style="margin:80px 0 40px 0; text-align:center;"><b>编辑license</b></h2>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <form action="/license/update" method="post" class="form-horizontal">
                <input type="hidden" name="id" value=""/>
                <div class="form-group">
                    <label class="col-md-2 control-label">省份：</label>
                    <div class="col-md-10">
                        <input type="text" name="province" value="${license.province}" class="form-control"
                               placeholder="省份"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">城市：</label>
                    <div class="col-md-10">
                        <input type="text" name="city" value="${license.city}" class="form-control" placeholder="城市"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">集群名称：</label>
                    <div class="col-md-10">
                        <input type="text" name="clusterName" value="${license.clusterName}" class="form-control"
                               placeholder="集群名称"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">集群节点数：</label>
                    <div class="col-md-10">
                        <input type="text" name="clusterNum" value="${license.clusterNum}" class="form-control"
                               placeholder="集群节点数"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-2 control-label">有效天数：</label>
                    <div class="col-md-10">
                        <input type="text" name="indate" value="${license.indate}" class="form-control"
                               placeholder="有效天数"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-10 col-md-offset-2">
                        <button type="submit" class="btn btn-primary">保存</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
<%@include file="/WEB-INF/pages/common/commonJS.jsp" %>
</body>
</html>