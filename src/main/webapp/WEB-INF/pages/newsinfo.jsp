<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>News information</title>

    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

</head>
<body>
<h1>News information</h1>

<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Category</th>
        <th width="360">Text</th>
        <th width="120">createDate</th>
    </tr>
    <tr>
        <td>${news.id}</td>
        <td>${news.title}</td>
        <td>${news.category}</td>
        <td>${news.text}</td>
        <td>${news.createDate}</td>
    </tr>
</table>
</body>
</html>