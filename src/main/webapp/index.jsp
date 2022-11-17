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

<script src="styles/bootstrap.bundle.min.js"></script>

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

<!--Предистория-->
<c:if test="${user == null}">
<section id="preview">
    <div class="row text-center">
        <div class="rol-12">

            <h3 class="container text-center colorText"> Ты помнишь истроию про Алису в стране чудес? Это квест о ней
                <br> <br> Алиса так же попала в кроличью нору, и теперь ей надо вернуться в Лондон.
                <br> Но для этого нужно съесть печеньку чтоб уменьшится, победить чудовище и все такое.
                <br> <br> Добавь свое имя, чтоб сохраниться <br> <br> </h3>

            <form action="${pageContext.request.contextPath}/init" >
                <div>
                    <h3 class="container text-center colorText" for="name">Твое имя: </h3>
                    <input type="text" id="name" name="name">
                </div>
                <br>
            <h4 class="color1 colorText"> Нажми на красную кнопку когда будешь готов </h4>
            <br>
            <div class="text-center btn-lg">
                <button type="submit" class="btn startButton"></button>
            </div>
            </form>
        </div>
    </div>
</section>
</c:if>

<c:if test="${user != null}">
<section id="game">
    <div class="row text-center">
        <div class="rol-12">

            <h3 class="container text-center colorText">${user.getName()}, ты в ${user.getActualRoom().getName()}, отсюда мы можешь пойти в:
                <br>
            </h3>

            <ul>
                <c:forEach var="room" items="${user.getActualRoom().getDoor()}">
                    <h3 class="container text-center colorText" ><c:out value="${room}" /></h3>
                </c:forEach>
            </ul>
        </div>
    </div>
</section>
</c:if>

</body>