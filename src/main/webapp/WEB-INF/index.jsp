<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<jsp:include page="gameInfo.jsp"/>

<body>

<!--History-->
<c:if test="${user == null}">
    <section id="preview">
        <div class="row text-center">
            <div class="rol-12">

                <h3 class="container text-center colorText"> Do you remember the story about Alice in Wonderland?
                    This is a quest about her
                    <br> <br> Alice also fell into the rabbit hole, and now she must return to London.
                    <br> But for this you need to eat a cookie to reduce, kill the monster and all that...
                    <br> <br> Add your name to save: <br></h3>

                <form action="${pageContext.request.contextPath}/init">
                    <div>
                        <label for="name"></label>
                        <input type="text" id="name" name="name">
                        <div id="nameHelp" class="form-text colorText">more original</div>
                    </div>
                    <br> <br>
                    <h4 class="color1 redText"> Press the red button when you're ready </h4>
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
                        <form action="${pageContext.request.contextPath}/dialog">
                            <div class="text-center btn-lg">
                                <input type="hidden" name="nextMessage" value="0">
                                <button type="submit" class="btn nextButton">
                                        ${personage.getName()}
                                </button>
                            </div>
                        </form>
                    </div>
                </div>

                <br><br>

                <h3 class="container text-center colorText">Invents in location</h3>
                <br>
                <c:forEach var="invent" items="${actualRoom.getInvents()}">

                    <form action="${pageContext.request.contextPath}/quest" method="post">
                        <div class="text-center btn-lg">
                            <c:if test="${!user.getInvents().contains(invent)}">
                                <c:if test="${!user.getUsedInvents().contains(invent)}">
                                    <input type="hidden" name="getInvent" value="${invent}">
                                    <button type="submit" class="btn chestButton"></button>
                                </c:if>
                            </c:if>
                        </div>
                    </form>
                </c:forEach>

            </div>

            <div class="col-6">

                <h3 class="container text-center colorText">Your actual location:
                        ${actualRoom.getName()} <br>
                    you can go to: </h3>
                <br>
                <c:forEach var="room" items="${actualRoom.getDoor()}">

                    <form action="${pageContext.request.contextPath}/rooms">
                        <c:if test="${user.getOpenedDoors().contains(room)}">
                            <div class="text-center btn-lg">
                                <input type="hidden" name="nextRoom" value="${room}">
                                <button type="submit" class="btn darkButton">${rooms.get(room).getName()}</button>

                            </div>
                        </c:if>
                    </form>

                </c:forEach>

                <br>

            </div>
            <div class="col-3">
                <h3 class="container text-center colorText">Your invents: </h3>

                <br>
                <ul>
                    <c:forEach var="invent" items="${user.getInvents()}">
                        <form action="${pageContext.request.contextPath}/quest" >
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