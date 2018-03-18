<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/common/common.jsp" %>
<title>license管理系统</title>
<style>
    .search {
        border: 1px solid #ddd;
        padding: 15px 20px;
    }

    #searchForm > .myFilter {
        margin-right: 12px;
    }
</style>
</head>

<body>
<h2 class="pageTitle"><b>license列表</b></h2>
<div class="container">
    <div class="search">
        <form class="form-inline" id="searchForm" action="/license/list">
            <div class="form-group myFilter">
                <label>过期状态：</label>
                <select class="form-control" name="cusStatus">
                    <option ${tbLicenseVo.cusStatus=='all'?selected:''} value="all">所有</option>
                    <option ${tbLicenseVo.cusStatus=='all'?willExpire:''} value="willExipre">快过期</option>
                </select>
            </div>
            <div class="form-group myFilter">
                <label>集群名称：</label>
                <input type="text" class="form-control" name="clusterName" value="${tbLicenseVo.clusterName}"/>
            </div>
            <div data-toggle="distpicker" class="myFilter" style="display:inline-block;">
                <div class="form-group">
                    <label>省份：</label>
                    <select class="form-control" name="province"></select>
                </div>
                <div class="form-group" style=" margin-left: 10px;">
                    <label>城市：</label>
                    <select class="form-control" name="city"></select>
                </div>
            </div>
            <br/>
            <div style="margin-bottom: 8px;"></div>
            <div class="form-group myFilter">
                <label>license生成时间：</label>
                <input type="text" class="form-control" id="createTimeStr" name="createTimeStr" style="width:310px;"/>
            </div>
            <div class="form-group myFilter">
                <label>license过期时间：</label>
                <input type="text" class="form-control" id="expireTimeStr" name="expireTimeStr" style="width:310px;"/>
            </div>
            <div class="form-group myFilter">
                <button type="submit" class="btn btn-primary">查询</button>
            </div>
        </form>
    </div>
    <a class="btn btn-primary" href="/license/gotoAdd" style="margin-top:10px;">新增</a>
    <table class="table table-bordered" style="margin-top:20px;">
        <thead>
        <th>序号</th>
        <th>省份</th>
        <th>城市</th>
        <th>集群名称</th>
        <th>集群节点数</th>
        <th>生成时间</th>
        <th>有效天数</th>
        <th>过期时间</th>
        <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${licenseList}" var="item" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item.province}</td>
                <td>${item.city}</td>
                <td>${item.clusterName}</td>
                <td>${item.clusterNum}</td>
                <td>${item.createTime}</td>
                <td>${item.indate}</td>
                <td>${item.expireTime}</td>
                <td>
                    <a class="" href="${ctx}/license/gotoUpdate?id=${item.id}">编辑</a>
                    <a class="" href="${ctx}/license/delete?id=${item.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="myPagination"></div>
</div>
<%@include file="/WEB-INF/pages/common/commonJS.jsp" %>
<script>
    layui.use('laypage', function () {
        var laypage = layui.laypage;
        laypage.render({
            elem: 'myPagination',
            count: 50
        });
    });

    laydate.render({
        elem: '#createTimeStr',
        type: 'datetime',
        range: true
    });
    laydate.render({
        elem: '#expireTimeStr',
        type: 'datetime',
        range: true
    });

    $(function () {

    })
</script>
</body>
</html>