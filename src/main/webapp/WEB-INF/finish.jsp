<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="gameInfo.jsp"/>

<body>
<section id="dialog">
    <div class="row text-center">

        <div class="col-12">

            <c:if test="${win == true}">
                <h1 class="container text-center colorText">Win</h1>
            </c:if>

            <c:if test="${win == false}">
                <h1 class="container text-center colorText">Fail</h1>
            </c:if>

            <br><br>
            <a class="btn nextButton" href="${pageContext.request.contextPath}/rooms?nextRoom=0">
                restart </a>

        </div>
    </div>
</section>
</body>
