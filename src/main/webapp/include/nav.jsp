<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="${root }/index.jsp"><img
                src="../assets/img/navbar-logo.svg" alt="..." /></a>
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarResponsive"
                aria-controls="navbarResponsive"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            Menu
            <i class="fas fa-bars ms-1"></i>
        </button>


        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav text-uppercase ms-auto py-4 py-lg-0">
                <div class="first" style="display:flex">
                    <li class="nav-item"><a class="nav-link" href="${root }/user/login.jsp">로그인</a></li>
                    <li class="nav-item"><a class="nav-link" href="${root }/user/registMember.jsp">회원가입</a></li>
                </div>
                <div class="second" style="display: none">
                    <li class="nav-item" id="login_name"></li>
                    <li class="nav-item"><a class="nav-link" href="#portfolio">로그아웃</a></li>
                </div>
            </ul>
        </div>
    </div>


</nav>
<!--
<c:choose>
    <%-- session에 userInfo 객체 없는 경우(로그인 X) --%>
    <c:when test="${empty userInfo}">
        <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link"
        href="${root }/user?action=form">로그인</a>
        </li>
        </ul>
    </c:when>
    <%-- session에 userInfo 객체 있는 경우(로그인 O) --%>
    <c:otherwise>
        <ul class="navbar-nav">
        <li class="nav-item">
        <a class="nav-link disabled">${userInfo.id}님 반갑습니다.</a>
        </li>
        <li class="nav-item"><a class="nav-link"
        href="${root }/user?action=logout">로그아웃</a>
        </li>
        </ul>
    </c:otherwise>
</c:choose>
