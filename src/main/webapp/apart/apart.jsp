<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%@ include file="/include/head.jsp" %>
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Font Awesome icons (free version)-->
	<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
	<!-- Google fonts-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
	<link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css/styles.css" rel="stylesheet" />
</head>

<body id="page-top">
<!-- Navigation-->
<%@ include file="/include/nav.jsp" %>

<!-- Masthead-->
<header class="masthead">
	<div class="container">
		<div class="masthead-heading text-uppercase">It's Nice To Meet You</div>

		<form id="searchForm" method="post" action="${root }/home">
			<input type="hidden" name="act" value="list">
			<div class="row col-md-12 justify-content-center mb-2">
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="sido" name="sido">
						<option value="">시도선택</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="gugun" name="gugun">
						<option value="">구군선택</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<select class="form-select bg-secondary text-light" id="dong" name="dong">
						<option value="">동선택</option>
					</select>
				</div>
				<div class="form-group col-md-2">
					<input type="text" class="form-control bg-secondary text-light" placeholder="아파트 명" id="aptname" name="aptname">
				</div>
				<div class="form-group col-md-2">
					<button type="submit" name="list-btn"
							class="btn btn-outline-primary">조회하기</button>
				</div>

				<br /> <br /> <br />
			</div>
		</form>
	</div>기
</header>

<div class="row">
	<div class="row align-items-center">
		<div class="col-md-12 col-sm-12">
			<table class="table table-hover text-center" style="">
				<tr>
					<th>아파트이름</th>
					<th>층</th>
					<th>면적</th>
					<th>법정동</th>
					<th>거래금액</th>
				</tr>
				<!-- ***************** DB 구축 후 수정 요망 ************ -->
				<tbody id="aptlist">
				<c:forEach var="deal" items = "${deals}">
					<tr>
						<td><a href="${root }/home?act=detail&aptCode=${deal.apt_code}&aptName=${deal.apt_name}&floor=${deal.floor}&area=${deal.area}&dong=${deal.dong_name}&deal=${deal.deal_amount}"
							   style="text-decoration: none; color: #ffc800; font-weight: bold;">
								${deal.apt_name }</a></td>
						<td>${deal.floor }</td>
						<td>${deal.area }</td>
						<td>${deal.dong_name }</td>
						<td>${deal.deal_amount }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=a55445555a66d8b5e8ad74af0600510c&libraries=services"></script>

<!-- Footer-->
<%@ include file="/include/footer.jsp" %>
<script src="../js/main.js"></script>
</body>
</html>
