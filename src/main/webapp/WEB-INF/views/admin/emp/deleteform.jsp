<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../templates/head.jsp"/>

<style>
	.error {color: #ff0000; }
</style>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

  <jsp:include page="../../templates/nav.jsp"/>
	
  <div class="content-wrapper">
    <div class="container-fluid">
    	<div class="card mb-3">
      		<div class="card-header">Delete Employee</div>
	     	<div class="card-body">
	     		<spring:url value="/admin/emp/delete " var="deleteEmpURL"/>
		        <form:form method="post" action="${deleteEmpURL}" modelAttribute="employee">
		          <form:hidden path="employeeId" />
		          <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-6">
		                <label for="login">Department</label>
		                <form:input path="departmentId" class="form-control" type="text"  placeholder="Enter department" readonly="true"/>
						<form:errors path="departmentId" cssClass="error" />
				      </div>
		              <div class="col-md-6">
		                <label for="login">Username</label>
		                <form:input path="username" class="form-control" type="text"  placeholder="Enter username" readonly="true"/>
						<form:errors path="username" cssClass="error" />
				      </div>
		            </div>
		          </div>
		          <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-6">
		                <label for="firstname">First name</label>
		                <form:input path="firstname" class="form-control" type="text" placeholder="Enter first name" readonly="true" />
						<form:errors path="firstname" cssClass="error" />
		              </div>
		              <div class="col-md-6">
		                <label for="lastname">Last name</label>
		               	<form:input path="lastname" class="form-control" type="text" placeholder="Enter last name" readonly="true" />
						<form:errors path="lastname" cssClass="error" />
		              </div>
		            </div>
		          </div>		          
		          <div class="form-group">
		            <div class="form-row">
		              <div class="col-md-6">
		                <label for="salary">Salary</label>
		               	<form:input path="salary" class="form-control" type="int" placeholder="Enter salary"  readonly="true"/>
						<form:errors path="salary" cssClass="error" />
		              </div>
		              <div class="col-md-6">
		              <%-- 
		                <label for="email">Email address</label>
		                <form:input path="email" class="form-control" type="text" placeholder="Enter email" />
						<form:errors path="email" cssClass="error" />
						--%>
		              </div>

		            </div>
		          </div>
 		          <button type="submit" class="btn btn-primary">Delete</button>
		        </form:form>
		        <font color="red">${message}</font>
	      	</div>
   		</div>
	</div>

	<jsp:include page="../../templates/footer.jsp"/>
	
  </div>
</body>

</html>
