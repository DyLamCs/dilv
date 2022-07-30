<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ include file="/components/common_css_js_signup.jsp"%>
</head>

<body>
    <div class="page-wrapper bg-dark p-t-100 p-b-50">
        <div class="wrapper wrapper--w900">
            <div class="card card-6">
                <div class="card-heading">
                    <h2 class="title">Sign Up</h2>
                </div>
                <div class="card-body">
                    <form id="add-from" action="${pageContext.request.contextPath}/account/signup" method="post">
                        <div class="form-row">
                            <div class="name">Name</div>
                            <div class="value">
                                <input class="input--style-6" type="text" name="accName">
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Password</div>
                            <div class="value">
                                <input class="input--style-6" type="password" name="accPassword">
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Phone</div>
                            <div class="value">
                                <input class="input--style-6" type="number" name="accPhone">
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Email address</div>
                            <div class="value">
                                <div class="input-group">
                                    <input class="input--style-6" type="email" name="accEmail" placeholder="example@email.com">
                                </div>
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">Street</div>
                            <div class="value">
                                <input class="input--style-6" type="text" name="accStreet">
                            </div>
                        </div>
                        
                        <div class="form-row">
                            <div class="name">City</div>
                            <div class="value">
                                <input class="input--style-6" type="text" name="accCity">
                            </div>
                        </div>
                       
                        
                <div class="card-footer">
                    <button class="btn btn--radius-2 btn--blue-2" type="submit">Send</button>
                </div>
                </form>
            </div>
        </div>
    </div>

</div>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->



