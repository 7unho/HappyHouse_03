<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 프로젝트의 context 경로를 편하게 사용하기 위한 코드 --%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@ include file="/include/head.jsp" %>
</head>
<body id="page-top">
<!-- Navigation-->
<%@ include file="/include/nav.jsp" %>

<!-- Masthead-->
<header class="masthead">
  <div class="container">
    <div class="masthead-heading text-uppercase">It's Nice To Meet You</div>
  </div>
</header>

<!-- 로그인 폼-->
<main class="container">
  <div class="login-page">
    <h1>Regist</h1>
    <div class="form_login">
      <form name="register-form" class="register-form">
        <input id="id" name="id" type="text" placeholder="id" />
        <input id="password" name="password" type="password" placeholder="password" />
        <input id="email" name="email" type="email" placeholder="email address" />
        <input id="name" name="name" type="text" placeholder="name" />
        <input id="age" name="age" type="number" placeholder="age" />
        <button onclick="regist()" type="button">회원 등록</button>
      </form>
    </div>
  </div>
</main>
<!-- Footer-->
<%@ include file="/include/footer.jsp" %>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../js/main.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
