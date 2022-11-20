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

              <div class="col-xl-8">
                  <h1 class="text-center colorRed">AliceGame</h1>
              </div>

            <div class="col-xl-4">
                <button type="button" class="btn nextButton" data-bs-toggle="modal" data-bs-target="#mapModal">
                    GameMap
                </button>
            </div>

                <div class="modal fade" id="mapModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <img src="${pageContext.request.contextPath}/img/map.png">
                            </div>
                        </div>
                    </div>
                </div>

        </div>
    </div>

</header>

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
        <div class="rol-12">

            <h3 class="container text-center colorText">${user.getName()}, ты в ${user.getActualRoom()},
                отсюда мы можешь пойти в: </h3>
            <br>
            <div class="btn-group" role="group" aria-label="Basic example">
                <c:forEach var="room" items="${actualRoom.getDoor()}">

                    <form action="${pageContext.request.contextPath}/rooms" >
                        <div class="text-center btn-lg">
                            <input type="hidden" name="nextRoom" value="${room}">
                            <button type="submit" class="btn nextButton">${room}</button>
                        </div>
                    </form>

                </c:forEach>
                </div>
        </div>
    </div>

    <div class="row text-center">
        <div class="rol-12">

            <h3 class="container text-center colorText">На локации с тобой ${personage.getName()}</h3>
            <br>

                <div class="container text-center">
                    <div class="row">
                        <form action="${pageContext.request.contextPath}/dialog" >
                            <div class="text-center btn-lg">
                                <input type="hidden" name="personage" value="${personage}">
                        <button type="submit"  class="btn nextButton">
                            Поговорить с ${personage.getName()}
                        </button>
                            </div>
                        </form>
                    </div>
                </div>

        </div>
    </div>

    <div class="row text-center">
        <div class="rol-12">

            <h3 class="container text-center colorText">Еще тут есть предметы: </h3>
            <br>
            <ul>
                <c:forEach var="invent" items="${actualRoom.getInvents()}">

                    <form action="${pageContext.request.contextPath}/rooms" method="post">
                        <div class="text-center btn-lg">
                            <input type="hidden" name="getInvent" value="${invent}">
                            <button type="submit" class="btn nextButton">Подобрать: ${invent}</button>
                        </div>
                    </form>

                </c:forEach>
            </ul>

        </div>
    </div>

</section>
</c:if>

</body>