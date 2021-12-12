<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix='form' uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<c:url value='/css/_04buyProductMenu.css' />">
<link rel="stylesheet" href="<c:url value='/css/commonStyle.css' />"
	type="text/css">

<title>購物商城</title>

<!-- bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- icon -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet">
<!-- jQuery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- VueJS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.14/vue.min.js"></script>
<!-- sweetAlert -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script src="<c:url value='/js/sortProducts.js' />"></script>
<script>
					
function addCart() {
	Swal.fire({
		position: 'center',
		icon: 'success',
		title: '商品已加入購物車',
		showConfirmButton: false,
		timer: 3000
	})
}

</script>

</head>

<body>
	<div id="body">
		<div id="content">


			<!-- 引入共同的頁首 -->
			<jsp:include page="/WEB-INF/fragment/topMVC.jsp" />

			<!-- Main Start -->

			<!-- imgAd Start -->
			<div class="menuAd d-flex justify-content-center">
				<img src="<c:url value='/images/menuAd.png' />" class="imageAd"
					alt="ad3">
			</div>
			<!-- imgAd End -->

			<!-- 商品列表start -->
			<div class="buyProductMenu-title">
				<h2>
					<i class="fas fa-th-large px-3"></i>商品列表
				</h2>
			</div>
			<!-- 商品列表end -->

			<div id="main" class="row">
				<!-- Side-List Start -->
				<jsp:include page="/WEB-INF/fragment/buySideMenu.jsp" />

				<!-- Product Start -->
				<div class="buyProduct col-9">

					<div class="container-fluid d-flex justify-content-end">
						<select name="sortType" id="sortType" @change="turnPage(1)">
							<option selected disabled value="">請選擇排序條件</option>
							<option value="price DESC">價格由高至低</option>
							<option value="stock DESC">數量由高至低</option>
							<option value="price ASC">價格由低至高</option>
							<option value="stock ASC">數量由低至高</option>
						</select>
					</div>

					<div
						class="container-fluid d-flex flex-wrap justify-content-center">
						<div id="mainBlock" class="row">

							<c:forEach var='product' items='${products}'>
								<div class="col-3 mt-3 " id="cardWidth">
									<div class="card text-center">
										<c:if test="${!empty product.promotionBean}">
											<div class="card-promotion">${product.promotionBean.promoTag}
											</div>
										</c:if>
										<a
											href="<c:url value='/_04_productPage?id=${product.prodId}' />"><img
											src="<c:url value='/images/product/${product.fileName}' />"
											class="card-img-top" id="productImg" alt="..."></a>
										<div class="card-body">
											<h5 class="card-title d-flex justify-content-around">
												${product.prodName}<i class="far fa-heart"
													id="heartFavorite${product.prodId}"
													onclick="track(this,${product.prodId})"></i>
											</h5>
											<div class="card-text mb-2">價格: ${product.price}元</div>

											<form class="row-3 pt-2"
												action="<c:url value='/buyMenu/addCart/${product.prodId}' />"
												method="POST">
												<select name="prodQTY" class="form-select"
													style="width: 45%;" aria-label="Default select example">
													<option selected value="1">數量</option>
													<c:forEach var="amount" begin="1" end="${product.stock}">
														<option value="${amount}">${amount}</option>
													</c:forEach>
												</select> <Input type='hidden' name='prodId'
													value='${product.prodId}'> <Input type='hidden'
													name='flag' value='1'> <input type="submit"
													class="btn btn-warning" value="加入購物車" onclick="addCart()" />
											</form>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>
					</div>

					<div id="pageNav" class="mt-3">
						<nav aria-label="Page navigation">
							<ul class="pagination justify-content-center">
								<c:choose>
									<c:when test="${pageNo == 1}">
										<li class="page-item disabled"><a class="page-link"
											tabindex="-1" aria-disabled="true">上一頁</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item">
											<a class="page-link" href="#" @click="turnPage(${pageNo - 1}, `${vue.prodType}`)">
												上一頁
											</a>
										</li>
									</c:otherwise>
								</c:choose>

								<c:forEach var="currentPage" begin="1" end="${totalPages}">
									<c:choose>
										<c:when test="${currentPage == pageNo}">
											<li class="page-item active"><a class="page-link">${currentPage}</a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="page-item">
												<a class="page-link" href="#" @click="turnPage(${currentPage}, `${vue.prodType}`)">
													${currentPage}
												</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

								<c:choose>
									<c:when test="${pageNo == totalPages}">
										<li class="page-item disabled"><a class="page-link"
											tabindex="-1" aria-disabled="true">下一頁</a></li>
									</c:when>
									<c:otherwise>
										<li class="page-item">
											<a class="page-link" href="#" @click="turnPage(${pageNo + 1}, `${vue.prodType}`)">
												下一頁
											</a>
										</li>
									</c:otherwise>
								</c:choose>

							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- Product End -->
		</div>
		<!-- Main End -->
		<!-- 引入共同的頁尾 -->
		<jsp:include page="/WEB-INF/fragment/bottomMVC.jsp" />
	</div>
	<!-- bootstrap -->
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		var vue = new Vue({
			el: '#main',
			data: {
				pageNo: 0,
				prodType: "",
				sortType: "",
			},
			methods: {
				turnPage(pageNo, prodType) {
					this.pageNo = pageNo;
					if (prodType != null) {
					this.prodType = prodType;
					}
					this.sortType = document.getElementById('sortType').value;
					let url = "<c:url value='/buyMenu/filter?pageNo=' />" + this.pageNo; 
					if (this.prodType != "") {
						url += "&prodType=" + this.prodType;
					}
					if (this.sortType != "") {
						url += "&sortType=" + this.sortType;
					}
					$.ajax({
						url: url,
						type: 'GET',
						async: true,
						success: response => {
							let data = "";
							for (let i = 0; i < response.products.length; i++) {
								let product = response.products[i];
								data += `<div class="col-3 mt-3 " id="cardWidth">
												<div class="card text-center">
								`;
								if (product.promotionBean != null) {
									data += `<div class="card-promotion">` + product.promotionBean.promoTag + `</div>`;
								}
								data += `			
													<a href="${request.getRequestURI}/Whocares/_04_productPage?id=` + product.prodId + `">
														<img src="${request.getRequestURI}/Whocares/images/product/` + product.fileName + `" class="card-img-top" id="productImg"></a>
													<div class="card-body">
														<h5 class="card-title d-flex justify-content-around">
															` + product.prodName + `<i class="far fa-heart" id="heartFavorite` + product.prodId + `" onclick="track(this,` + product.prodId + `)"></i>
														</h5>
													<div class="card-text mb-2">價格: ` + product.price + `元</div>
														<form class="row-3 pt-2"
															action="<c:url value='/buyMenu/addCart/` + product.prodId + `' />"
															method="POST">
															<select name="prodQTY" class="form-select"
																style="width: 45%;" aria-label="Default select example">
																<option selected value="1">數量</option>
								`;
								for (let amount = 1; amount <= product.stock; amount++) {
									data += 					`<option value="` + amount + `">` + amount + `</option>`;
								}
								data += `				</select>
															<input type='hidden' name='prodId' value='` + product.prodId + `'> <Input type='hidden'name='flag' value='1'>
															<input type="submit" class="btn btn-warning" value="加入購物車" onclick="addCart()" />
														</form>
													</div>
												</div>
											</div>
								`;				
							}
							
							let pageNav = "";
							pageNav += `
										<nav aria-label="Page navigation">
											<ul class="pagination justify-content-center">
									   `;
							if (this.pageNo == 1) {
								pageNav += `
												<li class="page-item disabled">
													<a class="page-link" tabindex="-1" aria-disabled="true">
														上一頁
													</a>
												</li>
								`;
							} else {
								pageNav += `
												<li class="page-item">
													<a class="page-link" href="#" onclick="vue.turnPage(` + (this.pageNo-1) + `, '` + this.prodType + `')">
														上一頁
													</a>
												</li>
								`;				
							}
							
							for (var p = 1; p <= response.totalPages; p++) {
								if (p == this.pageNo) {
									pageNav += `
												<li class="page-item active">
													<a class="page-link">
														` + p + `
													</a>
												</li>
									`;
								} else {
									pageNav += `
												<li class="page-item">
													<a class="page-link" href="#" onclick="vue.turnPage(` + p + `, '` + this.prodType + `')">
														` + p + `
													</a>
												</li>
									`;
								}
							}
							if (this.pageNo == response.totalPages) {
								pageNav += `
												<li class="page-item disabled">
													<a class="page-link" tabindex="-1" aria-disabled="true">
														下一頁
													</a>
												</li>
								`;
							} else {
								pageNav += `
												<li class="page-item">
													<a class="page-link" href="#" onclick="vue.turnPage(` + (this.pageNo+1) + `, '` + this.prodType + `')">
														下一頁
													</a>
												</li>
								`;
							}
							pageNav += `
										</ul>
									</nav>
							`;
//				 			document.getElementById('mainBlock').innerHTML = data;
							$('#mainBlock').html(data);
//				 			document.getElementById('pageNav').innerHTML = pageNav;
							$('#pageNav').html(pageNav);
						},

						error: () => {
							$('#mainBlock').html('');
						},
					});
				},
			},
		});
	
	</script>
</body>

</html>