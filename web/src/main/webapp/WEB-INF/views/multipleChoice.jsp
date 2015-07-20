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
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/js/bower_components/bootstrap/dist/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/js/bower_components/jquery/dist/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>


</head>
<body>
<div class="container">
    <form action="${pageContext.request.contextPath}/multiple-choice" method="post">
        <div class="form-group">
            <h3>${multipleChoice.content}</h3>
        </div>
        <div>
            <input type="hidden" name="multipleChoiceId" value="${multipleChoice.id}"/>
        </div>
        <div>
            <c:forEach var="selection" items="${multipleChoice.multipleChoiceSelections}">
                <div class="radio">
                    <label>
                        <input id="selection${selection.id}" type="radio" name="selectionId"
                               value="${selection.id}"/>${selection.content}
                    </label>
                </div>
            </c:forEach>
        </div>
        <div>
            <input class="btn btn-default" type="submit" value="提交"/>
            <a href="${pageContext.request.contextPath}/multiple-choice" class="btn btn-default">下一题</a>
        </div>
    </form>
    <p>${message}</p>
</div>
<script>
    $(document).ready(function () {
        var selectionId = ${selectionId};
        $("#selection" + selectionId).attr("checked", true);
    })
</script>
</body>
</html>
