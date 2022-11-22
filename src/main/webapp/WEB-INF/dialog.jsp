<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>AliceGame</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>

<script src="${pageContext.request.contextPath}/styles/bootstrap.bundle.js"></script>

<jsp:include page="gameInfo.jsp" />

<body>

        <div class="row text-center">
            <div class="col-5">
                <img src="${pageContext.request.contextPath}/${personage.getImgPath()}" class="img-fluid">
            </div>
            <div class="col-7">

                <br><br>
                        <h1 class="container text-center colorText">${textQuestion}</h1>
                    <ul>
                        <c:forEach var="answer" items="${answers}">

                            <form action="${pageContext.request.contextPath}/dialog" >
                                <div class="text-center btn-lg">
                                    <input type="hidden" name="nextQuestion" value="${answer.getNextQuestion()}">
                                    <button type="submit" class="btn nextButton">${answer.getText()}</button>
                                </div>
                            </form>

                        </c:forEach>
                </ul>

            </div>
        </div>

</body>