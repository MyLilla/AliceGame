<%--
  Created by IntelliJ IDEA.
  User: Lilla
  Date: 21.11.2022
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                            <img src="${pageContext.request.contextPath}/img/map.png" class="img-fluid">
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</header>
<body>

</body>
</html>
