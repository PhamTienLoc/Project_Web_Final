


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="col-sm-3">
	<div class="card bg-light mb-3">
		<div class="card-header bg-primary text-white text-uppercase">
			<i class="fa fa-list"></i> Categories
		</div>
		<ul class="list-group category_block">
			<c:forEach items="${listC}" var="c">
				<%--Ở đây khi nhấn vào thì nó sẽ chuyển tới trang servlet có mapping là category --%>
				<%-- và sau đó nó sẽ gửi qua trang rùi nhỉ thì lúc đó mình requestGetParameter("cidPhat") chắc đã hiểu rùi nhỉ Phát kk --%>
				<li class="list-group-item text-white ${tag==c.cid ?'active':''}"><a
					href="category?cidPhat=${c.cid}">${c.cname}</a></li>
			</c:forEach>

		</ul>
	</div>
	<%--Chỗ này  là sản phẩm mới nhất --%>
	<div class="card bg-light mb-3">
		<div class="card-header bg-success text-white text-uppercase">Last
			product</div>
		<div class="card-body">
			<img class="img-fluid" src="${p.thumbnail}" />
			<h5 class="card-title">${p.title}</h5>  
			<p class="card-text">${p.title}</p>
			<p class="bloc_left_price">${p.price}$</p>
		</div>
	</div>
	<%--Chỗ này  là sản phẩm mới nhất --%>
</div>
<%--Categories end --%>