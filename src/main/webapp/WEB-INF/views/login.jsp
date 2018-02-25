<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="templates/head.jsp"/>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
      
      	<spring:url value="/j_spring_security_check " var="loginURL"/>
      
        <form:form method="post" action="${loginURL}" modelAttribute="credential">
       	 <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
          <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <form:input path="username" class="form-control"  id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter username"/>
			<form:errors path="username" cssClass="error" />
            
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <form:password path="password" class="form-control" id="exampleInputPassword1"  placeholder="Enter Password"/>
			<form:errors path="password" cssClass="error" />
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox"> Remember Password</label>
            </div>
          </div>
          <input type="submit" value="Login" class="btn btn-primary btn-block" />
        </form:form>
        <c:if test="${param.error eq '1' }">
   					<font color="red">Login / Password incorrect</font>
   		</c:if> 
        
        <font color="red">${message}</font>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  
  <jsp:include page="templates/loadJs.jsp"/>
  
</body>

</html>
