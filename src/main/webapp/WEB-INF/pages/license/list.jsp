<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/pages/common/common.jsp" %>
<body>
<h2 style="margin:80px 0 40px 0; text-align:center;"><b>license列表</b></h2>
<div class="container">
    <div class="search">
        <form class="form-inline" id="searchForm" action="/license/list">
            <div data-toggle="distpicker">
                <div class="form-group">
                    <label for="province">省份：</label>
                    <select class="form-control" id="province"></select>
                </div>
                <div class="form-group">
                    <label for="city">城市：</label>
                    <select class="form-control" id="city"></select>
                </div>
            </div>
        </form>
    </div>
    <a class="btn btn-primary" href="/license/gotoAdd">新增</a>
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
                <td>${item.activeDay}</td>
                <td>${item.expireTime}</td>
                <td>
                    <a class="" href="${ctx}/license/gotoUpdate?id=${item.id}">编辑</a>
                    <a class="" href="${ctx}/license/delete?id=${item.id}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@include file="/WEB-INF/pages/common/commonJS.jsp" %>
<script>
    $(function () {

    })
</script>
</body>
</html>