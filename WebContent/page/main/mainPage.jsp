<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<%@ include file="/common/taglib.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>resource/css/globalStyle.css" />
<title>主页</title>
</head>
<body>
	welcome to the main page!
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<td>序号</td>
					<td>日期</td>
					<td>早餐</td>
					<td>午餐</td>
					<td>晚餐</td>
					<td>交通费</td>
					<td>话费</td>
					<td>房租</td>
					<td>医疗</td>
					<td>水电天然气</td>
					<td>衣服</td>
					<td>交际费</td>
					<td>文化娱乐</td>
					<td>网上购物</td>
					<td>其他</td>
					<td>当天合计</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>23</td>
					<td><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %><%=new SimpleDateFormat("EEEE").format(new Date()) %></td>
					<td>11</td>
					<td>23</td>
					<td>13</td>
					<td>13</td>
					<td>11</td>
					<td>23</td>
					<td>13</td>
					<td>13</td>
					<td>11</td>
					<td>23</td>
					<td>11</td>
					<td>23</td>
					<td>13</td>
					<td>11</td>
				</tr>
				<tr>
					<td>5</td>
					<td>56</td>
					<td>77</td>
					<td>5</td>
					<td>56</td>
					<td>77</td>
					<td>5</td>
					<td>5</td>
					<td>56</td>
					<td>5</td>
					<td>56</td>
					<td>56</td>
					<td>77</td>
					<td>5</td>
					<td>56</td>
					<td>77</td>
				</tr>
				<tr>
					<td>5</td>
					<td>56</td>
					<td>77</td>
					<td>5</td>
					<td>5</td>
					<td>5</td>
					<td>56</td>
					<td>77</td>
					<td>5</td>
					<td>77</td>
					<td>5</td>
					<td>56</td>
					<td>77</td>
					<td>5</td>
					<td>56</td>
					<td>77</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>