<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="js/jquery-1.11.1.min.js"></script>
<%@ include file="/components/common_css_js_home.jsp"%>
<%@ include file="/templates/layoutclient/head.jsp"%>

<style type="text/css">

.table &amp ;amp ;gt ;tbody &amp ;amp ;gt ;tr &amp ;amp ;gt ;td, .table
	&amp ;amp ;gt ;tfoot &amp ;amp ;gt ;tr &amp ;amp ;gt ;td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
	}
}	
.detail-cart{
		height: 590px;
	    margin-top: auato;
	    display: flex;
	    flex-direction: auto;
	    flex-direction: column;
	    justify-content: flex-end;
	    align-items: flex-end;
	}
	
</style>
</head>

<body>
	<%@ include file="/templates/layoutclient/header.jsp"%>

	<div class="container detail-cart ">
		
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Tên sản phẩm</th>
					<th style="width: 10%">Giá</th>
					<th style="width: 8%">Số lượng</th>
					<th style="width: 22%" class="text-center">Thành tiền</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs">
								<img
									src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/shopping_cart/images/090.jpg"
									alt="Sản phẩm 1" class="img-responsive" width="100">
							</div>
							<div class="col-sm-10">
								<h4 class="nomargin">Sản phẩm 1</h4>
								<p>Mô tả của sản phẩm 1</p>
							</div>
						</div>
					</td>
					<td data-th="Price">200.000 đ</td>
					<td data-th="Quantity"><input class="form-control text-center"
						value="1" type="number"></td>
					<td data-th="Subtotal" class="text-center">200.000 đ</td>
					<td class="actions" data-th="">
						<button class="btn btn-info btn-sm">
							<i class="fa fa-edit"></i>
						</button>
						<button class="btn btn-danger btn-sm">
							<i class="fa fa-trash-o"></i>
						</button>
					</td>
				</tr>
				<tr>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs">
								<img
									src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/shopping_cart/images/174.jpg"
									alt="Sản phẩm 1" class="img-responsive" width="100">
							</div>
							<div class="col-sm-10">
								<h4 class="nomargin">Sản phẩm 2</h4>
								<p>Mô tả của sản phẩm 2</p>
							</div>
						</div>
					</td>
					<td data-th="Price">300.000 đ</td>
					<td data-th="Quantity"><input class="form-control text-center"
						value="1" type="number"></td>
					<td data-th="Subtotal" class="text-center">300.000 đ</td>
					<td class="actions" data-th="">
						<button class="btn btn-info btn-sm">
							<i class="fa fa-edit"></i>
						</button>
						<button class="btn btn-danger btn-sm">
							<i class="fa fa-trash-o"></i>
						</button>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr class="visible-xs">
					<td class="text-center"><strong>Tổng 200.000 đ</strong></td>
				</tr>
				<tr>
					<td><a href="http://hocwebgiare.com/" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Tiếp tục mua hàng</a></td>
					<td colspan="2" class="hidden-xs"></td>
					<td class="hidden-xs text-center"><strong>Tổng tiền
							500.000 đ</strong></td>
					<td><a href="http://hocwebgiare.com/"
						class="btn btn-success btn-block">Thanh toán <i
							class="fa fa-angle-right"></i></a></td>
				</tr>
			</tfoot>
		</table>
	</div>

	<%@ include file="/templates/layoutclient/footer.jsp"%>
	
</body>
</html>