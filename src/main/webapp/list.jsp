<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>

	
	
	
	<table>
		<tr>
			<td colspan="10">
				<a href="add.jsp"><input type="button" value="添加"></a>
			</td>
		</tr>
		<tr>
			<td>编号</td>
			<td>英雄名称</td>
			<td>价格</td>
			<td>是否拥有</td>
			<td>图片</td>
			<td>所属阵营</td>
			<td>操作</td>
		</tr>
		
	<c:forEach items="${plist.list }" var="y">
		<tr>
			<td>${y.yid }</td>
			<td>${y.yname }</td>
			<td>${y.yjg }</td>
			<td>${y.yis==0?"未拥有":"已拥有" }</td>
			<td>
				<img alt="xxx" height="70px" width="90px" src="lookImg?path=${y.ytp }">
			</td>
			<td>${y.cname }</td>
			<td>
				<a href="queryHeroById?id=${y.yid }"><input type="button" value="详情"></a>
				<input type="button" value="购买" onclick="buy('${y.yid }')">
			</td>
		</tr>
	</c:forEach>
		
	<tr>
			<td colspan="10">
				当前${plist.pageNum }/${plist.pages }页，共${plist.total }记录
				<a href="?pageNum=${plist.firstPage }">首页</a>
				<a href="?pageNum=${plist.prePage }">上一页</a>
				<a href="?pageNum=${plist.nextPage }">下一页</a>
				<a href="?pageNum=${plist.lastPage }">末页</a>
			</td>
		</tr>
	</table>

</body>
</html>