

<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header text-center">
			<h3 class="modal-title w-100">Delete</h3>
		</div>
		<div class="modal-body">
			<h4>Bạn có chắc muốn xóa sinh viên <br> ${product.getProId()} -
				${product.getProName() }</h4>
		</div>
		<div class="modal-footer">
			<div class="container text-center">
				<a href="product/delete/${product.getProId()}" class="btn btn-outline-success">Yes</a>
				<a data-dismiss="modal" class="btn btn-outline-info">No</a>
			</div>
		</div>
	</div>
</div>