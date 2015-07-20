<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <input type="text" name="multipleChoiceId" value="${multipleChoice.id}"/>
    </div>
    <div>
        <div><label><input type="radio" name="selection" value="A"/>选项A</label></div>
        <div><label><input type="radio" name="selection" value="B"/>选项B</label></div>
        <div><label><input type="radio" name="selection" value="C"/>选项C</label></div>
        <div><label><input type="radio" name="selection" value="D"/>选项D</label></div>
    </div>
    <div>
        <input type="submit" value="提交"/>
        <a href="${pageContext.request.contextPath}/multiple-choice">下一题</a>
    </div>
</form>
<script>
</script>
</body>
</html>
