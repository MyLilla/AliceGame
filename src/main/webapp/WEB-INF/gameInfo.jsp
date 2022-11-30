<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>AliceGame</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Reenie+Beanie&family=Special+Elite&display=swap"
          rel="stylesheet">
</head>
<script src="${pageContext.request.contextPath}/styles/bootstrap.bundle.min.js"></script>

<html>
<header>

    <div class="container">
        <div class="row">

            <div class="col-xl-6">
                <h1 class="text-center redText">AliceGame</h1>
            </div>

            <div class="col-xl-2">
                <button type="button" class="btn roomButton" data-bs-toggle="modal" data-bs-target="#rulModal">
                    Rules
                </button>
            </div>

            <div class="modal fade" id="rulModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-sm" id="preview">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">Rules for game</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body bg-dark text-white">
                            <ul>
                                <li>Твоя цель - добратся до лондона</li>
                                <li>В каждой локаци есть персонажи, с которыми можно говорить</li>
                                <li>На локациях есть сундуки с разными предметами, можешь собирать</li>
                                <li>Полученные предметы хранятся в твоем инвентаре, их можно использоват</li>
                                <li>Некоторые двери в локациях скрыты</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-xl-2">
                <button type="button" class="btn roomButton" data-bs-toggle="modal" data-bs-target="#mapModal">
                    GameMap
                </button>
            </div>

            <div class="modal fade" id="mapModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-body">
                            <img src="${pageContext.request.contextPath}/img/map.png" class="img-fluid">
                        </div>
                    </div>
                </div>
            </div>

            <c:if test="${user != null}">
                <div class="col-xl-2">
                    <button type="button" class="btn roomButton" data-bs-toggle="modal" data-bs-target="#statistic">
                        Statistic
                    </button>
                </div>

                <div class="modal fade" id="statistic" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog modal-sm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">${user.getName()}</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body bg-dark text-white">
                                <ul>
                                    <li>Count of game: ${user.getCurrentGame()}</li>
                                    <li>Count users in the game: ${usersRepository.getUsersRep().size()}</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

        </div>
    </div>

</header>
<body>

</body>
</html>
