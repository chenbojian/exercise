<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chenbojian
  Date: 7/20/15
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>单选题</title>
    <script src="${pageContext.request.contextPath}/js/bower_components/jquery/dist/jquery.min.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/multiple-choice" method="post">
    <div>
        <p>${multipleChoice.content}</p>
    </div>
    <div>
        <input type="hidden" name="multipleChoiceId" value="${multipleChoice.id}"/>
    </div>
    <div>
        <c:forEach var="selection" items="${multipleChoice.multipleChoiceSelections}">
            <div>
                <label><input type="radio" name="selectionId" value="${selection.id}"/>${selection.content}</label>
            </div>
        </c:forEach>
    </div>
    <div>
        <input type="submit" value="提交"/>
        <a href="${pageContext.request.contextPath}/multiple-choice">下一题</a>
    </div>
</form>
<p>${message}</p>
<script>
</script>
</body>
</html>
