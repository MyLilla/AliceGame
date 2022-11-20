<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>AliceGame</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>

<script src="../styles/bootstrap.bundle.min.js"></script>

<header>
    <div class="container">
        <div class="row">
            <div class="rol-12">
                <h1 class="text-center colorRed">
                    AliceGame
                </h1>
            </div>
        </div>
    </div>
</header>

<body>

    <section id="">

        <div class="row text-center">
            <div class="rol-12">

                        <h1 class="container text-center colorText">первый вопрос: ${textQuestion}</h1>
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

    </section>

</body>