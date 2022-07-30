<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student List</title>
<%@ include file="/components/commom_css_js.jsp"%>
</head>

<body>
	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-md-4 offset-md-4 margin-table">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center mmy-3">Add Student</h3>
						<form action="/student-manager/student/add" method="post">
							<div class="form-group">
								<label for="name">Name:</label> 
								<input class="form-control" type="text" id="name" name="name" placeholder="Input Name here...">
							</div>
							
							<div class="form-group">
								<label for="age">Age:</label> 
								<input class="form-control" type="text" id="age" name="age" placeholder="Input Age here...">
							</div>
							
							<div class="form-group">
								<label for="address">Address:</label> 
								<textarea style="height:100px" class="form-control" type="text" id="address" name="address" placeholder="Input Address here..."></textarea>
							</div>
							
							<div class="container text-center">
								<button type="submit" class="btn btn-outline-success">Create</button>
								<button type="reset" class="btn btn-outline-warning">Reset</button>
								<a href="/student-manager/student" class="btn btn-outline-info">Back</a>													
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>