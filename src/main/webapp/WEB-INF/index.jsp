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

<script src="${pageContext.request.contextPath}/styles/bootstrap.bundle.min.js"></script>

<jsp:include page="gameInfo.jsp" />

<body>

<!--History-->
<c:if test="${user == null}">
<section id="preview">
    <div class="row text-center">
        <div class="rol-12">

            <h3 class="container text-center colorText"> Ты помнишь истроию про Алису в стране чудес? Это квест о ней
                <br> <br> Алиса так же попала в кроличью нору, и теперь ей надо вернуться в Лондон.
                <br> Но для этого нужно съесть печеньку чтоб уменьшится, победить чудовище и все такое.
                <br> <br> Добавь свое имя, чтоб сохраниться: <br> <br> </h3>

            <form action="${pageContext.request.contextPath}/init">
                <div>
                    <label for="name"></label>
                    <input type="text" id="name" name="name">
                    <div id="nameHelp" class="form-text colorText">придумай что-то поригинальней</div>
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

<!--Steps-->
<c:if test="${user != null}">
<section id="game">
    <div class="row text-center">
        <div class="col-3">

            <h3 class="container text-center colorText">Speak with:</h3>
            <br>

            <div class="container text-center">
                <div class="row">
                    <form action="${pageContext.request.contextPath}/dialog" >
                        <div class="text-center btn-lg">
                            <input type="hidden" name="personage" value="${personage}">
                            <button type="submit"  class="btn nextButton">
                               ${personage.getName()}
                            </button>
                        </div>
                    </form>
                </div>
            </div>

            <h3 class="container text-center colorText"></h3>
            <br>

                <c:forEach var="invent" items="${actualRoom.getInvents()}">

                    <form action="${pageContext.request.contextPath}/rooms" method="post">
                        <div class="text-center btn-lg">
                            <c:if test="${!user.getInvents().contains(invent)}">
                                <c:if test="${!user.getUsedInvents().contains(invent)}">
                                <input type="hidden" name="getInvent" value="${invent}">
                                <button type="submit" class="btn nextButton">Pick up invent</button>
                            </c:if>
                            </c:if>
                        </div>
                    </form>
                </c:forEach>

        </div>

        <div class="col-6">

            <h3 class="container text-center colorText">Your actual location: ${user.getActualRoom()},
                you can go to: </h3>
            <br>
            <div class="btn-group" role="group" aria-label="Basic example">
                <c:forEach var="room" items="${actualRoom.getDoor()}">

                    <form action="${pageContext.request.contextPath}/rooms" >
                        <c:if test="${openedRoom || actualRoom.getOpenedDoors().contains(room)}">
                        <div class="text-center btn-lg">
                            <input type="hidden" name="nextRoom" value="${room}">
                            <button type="submit" class="btn nextButton">${room}</button>
                        </div>
                        </c:if>
                    </form>

                </c:forEach>
                </div>
        </div>
        <div class="col-3">
            <h3 class="container text-center colorText">Your invents: </h3>

            <br>
            <ul>
                <c:forEach var="invent" items="${user.getInvents()}">
                    <form action="${pageContext.request.contextPath}/rooms" method="post" >
                        <div class="text-center btn-lg">
                            <input type="hidden" name="getInvent" value="${invent}">
                            <button class="btn nextButton">${invent}</button>
                        </div>
                    </form>
                </c:forEach>
            </ul>
        </div>
    </div>

</section>
</c:if>

</body>