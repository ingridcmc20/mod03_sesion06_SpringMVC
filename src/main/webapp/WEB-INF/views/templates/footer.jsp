<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Your Website 2018</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <spring:url value="/j_spring_security_logout" var="logoutURL"/>
            <form class="form-inline" action="${logoutURL}" method="post">
				<input type="submit" value="Logout"  class="btn btn-primary"/>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
          </div>
          
        </div>
      </div>
    </div>
    
	<jsp:include page="loadJs.jsp"/>
