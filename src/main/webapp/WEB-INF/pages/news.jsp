<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>News Page</title>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<main>
<h1>Add a News</h1>

<c:url var="addAction" value="/news/add"/>

<form:form action="${addAction}" commandName="news">
    <table>
        <c:if test="${!empty news.title}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="title">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="category">
                    <spring:message text="Category"/>
                </form:label>
            </td>
            <td>
                <form:input path="category"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="text">
                    <spring:message text="Text"/>
                </form:label>
            </td>
            <td>
                <form:input path="text"/>
            </td>
        </tr>
        <c:if test="${!empty news.title}">
            <tr>
                <td>
                    <form:label path="createDate">
                        <spring:message text="CreateDate"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="createDate" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="createDate"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td colspan="2">
                <c:if test="${!empty news.title}">
                    <input type="submit"
                           value="<spring:message text="Edit News"/>"/>
                </c:if>
                <c:if test="${empty news.title}">
                    <input type="submit"
                           value="<spring:message text="Add News"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<h1>Find News</h1>

<c:url var="findAction" value="/news/finded"/>
<form:form action="${findAction}" commandName="news" modelAttribute="news">
    <table>
        <tr>
            <td>
                <form:label path="title">
                <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="title"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="category">
                    <spring:message text="Categorys"/>
                </form:label>
            </td>
            <td>
                <form:select path="category">
                <form:option value="NONE" label="NONE" />
                <form:options items="${listCategorys}" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Find News"/>"/>
            </td>
        </tr>
    </table>
</form:form>

<h1>News List</h1>

<c:if test="${!empty listNews}">
    <c:forEach items="${listNews}" var="news">
        <hr />
        <section class="news_title">
            <h1><a href="/newsinfo/${news.id}" target="_blank">${news.title}</a></h1>
            <b><a href="/findByCategory/${news.category}" target="_blank">${news.category}</a></b>
            <br/>
            <i>${news.createDate}</i>
            <article class="news_text">
                    ${news.text}
            </article>
            <b><a href="<c:url value='/edit/${news.id}'/>">Edit</a> <a href="<c:url value='/remove/${news.id}'/>">Delete</a></b>
        </section>
    </c:forEach>
</c:if>
</main>
</body>
</html>