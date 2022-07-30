<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Content-Type" content="text/html charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Student List</title>
		<%@ include file="/components/common_css_js.jsp" %>
	</head>

	<body>
		<div class="container">
			<div class="card mt-3">
				<h2 class="text-center">Student List</h2>
				
				<div class="container mb-3 btn-add">
					<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#addModal">
						Add Student
					</button>
					<a href="${urlApi}/pdfview" class="btn btn-outline-info">Export to PDF</a>
				</div>
				
				<table class="table table-striped border table-bordered text-center ">
					<thead class="thead-dark">
						<tr class="">
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Age</th>
							<th scope="col">Address</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody id="data_body">
						
					</tbody>
				</table>
			</div>		
		</div>
		
		<!-- The Modal Add -->
		<div class="modal" id="addModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Add Student</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		       	<form id="add-from" action="${urlApi}" method="post">
							<div class="form-group">
								<label for="name">Name:</label> 
								<input class="form-control" type="text" id="name-add" name="name" placeholder="Input Name here...">
							</div>
							
							<div class="form-group">
								<label for="age">Age:</label> 
								<input class="form-control" type="text" id="age-add" name="age" placeholder="Input age student here...">
							</div>
							
							<div class="form-group">
								<label for="dob">Address</label> 
								<input class="form-control" type="text" id="address-add" name="address" placeholder="Input address here...">
							</div>
							
							<div class="container text-center">
								<button type="submit" class="btn btn-outline-success">Create</button>
								<button type="reset" class="btn btn-outline-warning">Reset</button>
							</div>
						</form>
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		
		    </div>
		  </div>
		 </div>
		 
		 
		 <!-- The Modal Update -->
		<div class="modal" id="updateModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		
		      <!-- Modal Header -->
		      <div class="modal-header">
		        <h4 class="modal-title">Update Student</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		
		      <!-- Modal body -->
		      <div class="modal-body">
		       	<form id="update-from" action="${urlApi}" method="post">
		       				<div class="form-group">
								<input class="form-control" type="hidden" id="id-update" name="id">
							</div>
		       				
							<div class="form-group">
								<label for="name">Name:</label> 
								<input class="form-control" type="text" id="name-update" name="name" placeholder="Input Name here...">
							</div>
							
							<div class="form-group">
								<label for="studentCode">Age:</label> 
								<input class="form-control" type="text" id="age-update" name="age" placeholder="Input age here...">
							</div>
							
							<div class="form-group">
								<label for="dob">Address</label> 
								<input class="form-control" type="text" id="address-update" name="address" placeholder="Input address here...">
							</div>
							
							<div class="container text-center">
								<button type="submit" class="btn btn-outline-success">Update</button>
								<button type="reset" class="btn btn-outline-warning">Reset</button>
							</div>
						</form>
		      </div>
		
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
		
		    </div>
		  </div>
		 </div>
	</body>
	
	<script>
	let text = "";
	var url = "${urlApi}";
	$( document ).ready(function() {
		 $.ajax({url: url, success: function(result){
			 result.forEach(getData);
			 document.getElementById("data_body").innerHTML = text;
		    }});
	});
	
	function getData(item, index) {
		 	text += "<tr>"+
				"<td>"+item.id+"</td><td>"+item.name+"</td><td>"+item.age+"</td><td>"+item.address+"</td>"+
				"<td><div>"+
						"<button id="+item.id+" onclick='openUpdatePage(this)' type='button' class='btn btn-outline-info btn-action' data-toggle='modal' data-target='#updateModal'>"
							+"Update"+
						"</button>"+
						"<button id='"+url+"/delete/"+item.id+"' class='btn btn-outline-danger btn-action' onclick='return confirmDelete(this)'>Delete</button>"+
				"</div></td>"	+						
			"</tr>"
		}
	
	function confirmDelete(a) {
		var answer = window.confirm("Delete student?");
		if (answer) {
			var href = a.id;
			 $.ajax({
			        type: "DELETE",
			        url: href,
			        success: function(data)
			        {
			          alert("Delete susscess");
			          location.reload();
			        },
			        error: function(data)
			        {
			          alert("Delete Fail");
			          location.reload();
			        }
			    });
		}
		else {
		  	return false;
		}
	}

	function openUpdatePage(button) {
		var id = button.id;
		var url = "${urlApi}/"+id;
		var put = "${urlApi}/update/"+id;
		 $.ajax({url: url, success: function(result){
			 const obj = result;
			 var id = obj['id'];
			 var name = obj['name'];
			 var age = obj['age'];
			 var address = obj['address'];

			 $('#update-from').attr('action', put);
			 $('#id-update').val(id);
			 $('#name-update').val(name);
			 $('#age-update').val(age);
			 $('#address-update').val(address);
			
		    }});
	}

	$("#add-from").submit(function(e) {

	    e.preventDefault(); // avoid to execute the actual submit of the form.
		//.serialize()
	    var form = $(this);
	    var actionUrl = form.attr('action');
	    $.ajax({
	        type: "POST",
	        url: actionUrl,
	        data: JSON.stringify(convertFormToJSON(form)), // serializes the form's elements.
	        contentType: "application/json",
	        success: function(data)
	        {
	          alert("Create seccess");
	          location.reload();
	        },
	        error: function(data)
	        {
	          alert("Create Fail");
	          location.reload();
	        }
	    });
	    
	});

	$("#update-from").submit(function(e) {

	    e.preventDefault(); // avoid to execute the actual submit of the form.
		//.serialize()
	    var form = $(this);
	    var actionUrl = form.attr('action');
	    $.ajax({
	        type: "PUT",
	        url: actionUrl,
	        data: JSON.stringify(convertFormToJSON(form)), // serializes the form's elements.
	        contentType: "application/json",
	        success: function(data)
	        {
	          alert("Update seccess");
	          location.reload();
	        },
	        error: function(data)
	        {
	          alert("Update Fail");
	          location.reload();
	        }
	    });
	    
	});
	
	function convertFormToJSON(form) {
		  const array = $(form).serializeArray(); // Encodes the set of form elements as an array of names and values.
		  const json = {};
		  $.each(array, function () {
		    json[this.name] = this.value || "";
		  });
		  return json;
		}
	</script>
</html>