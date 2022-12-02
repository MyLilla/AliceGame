<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<jsp:include page="gameInfo.jsp"/>

<body>
<section id="dialog">
    <div class="row text-center">
        <div class="col-5">
            <img src="${pageContext.request.contextPath}/${personage.getImgPath()}">
        </div>
        <div class="col-7">

            <h1 class="container text-center colorText">${textQuestion}</h1>
            <br><br>

            <ul>
                <c:forEach var="answer" items="${answers}">
                    <form action="${pageContext.request.contextPath}/dialog">
                        <div class="text-center btn-lg">
                            <input type="hidden" name="nextMessage" value="${answer.getNextQuestion()}">
                            <button type="submit" class="btn nextButton">${answer.getText()}</button>
                        </div>
                    </form>
                </c:forEach>
                <a class="btn nextButton"
                   href="${pageContext.request.contextPath}/rooms?nextRoom=${actualRoom.getId()}">
                    exit </a>
            </ul>

        </div>
    </div>
</section>
</body>
