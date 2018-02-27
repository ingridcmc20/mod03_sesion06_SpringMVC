<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

	<jsp:include page="../templates/head.jsp"/>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">

 <jsp:include page="../templates/nav.jsp"/>
  <div class="content-wrapper">
    <div class="container-fluid">
      		<div class="row-fluid">
			<div class="col-md-4">
				<h4 class="text-center">You do not have permission to access this page!</h4>
				<hr>
				<table class="table table-bordered table-striped">
					<tbody>
						<tr>
							<td align="center">
								<form class="form-inline" action="<%=request.getContextPath()%>/j_spring_security_logout" method="post">
							      <input type="submit" value="Sign in as different user"  class="btn btn-primary"/>
							      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							    </form>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
    <!-- /.container-fluid-->
    
    
	<jsp:include page="../templates/footer.jsp"/>

  	</div>
  </div>  
</body>

</html>






