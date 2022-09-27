<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
    <h1>LogIn</h1>
    <div class="form_login">
      <form name="login-form" class="login-form" action="${root}/user?action=login" method="POST">
        <input id="id" name="id" type="text" placeholder="ID" />
        <input id="password" name="pw" type="password" placeholder="password" />
        <button class="login-btn">로그인</button>
      </form>
      <button>회원가입</button>
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
