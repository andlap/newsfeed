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
<main>
    <h1>News List</h1>

    <c:choose>
        <c:when test="${!empty listNewsByTitleAndCategory}">
            <c:forEach items="${listNewsByTitleAndCategory}" var="news">
                <hr />
                <section class="news_title">
                    <h1><a href="/newsinfo/${news.id}" target="_blank">${news.title}</a></h1>
                    <b>${news.category}</b>
                    <br/>
                    <i>${news.createDate}</i>
                    <article class="news_text">
                            ${news.text}
                    </article>
                </section>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h1>News not found</h1>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>