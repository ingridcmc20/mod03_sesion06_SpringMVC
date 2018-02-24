<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<spring:url value="/resources/vendor/jquery/jquery.min.js" var="jqueryMinJs"/>
	<spring:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapMinJs"/>
	<spring:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" var="jqueryEasingMinJs"/>
	<spring:url value="/resources/vendor/datatables/jquery.dataTables.js" var="jqueryDataTablesMinJs"/>
	<spring:url value="/resources/vendor/datatables/dataTables.bootstrap4.js" var="dataTablesBootstropJs"/>
	<spring:url value="/resources/js/sb-admin.min.js" var="sdAdminMinJs"/>
	<spring:url value="/resources/js/sb-admin-datatables.min.js" var="sdAdminDataTablesMinJs"/>
 
 	<!-- Bootstrap core JavaScript-->
   	<script src="${jqueryMinJs}"></script>
   	<script src="${bootstrapMinJs}"></script>
   
   	<!-- Core plugin JavaScript-->
   	<script src="${jqueryEasingMinJs}"></script>
   
   	<!-- Page level plugin JavaScript-->
   	<script src="${jqueryDataTablesMinJs}"></script>
   	<script src="${dataTablesBootstropJs}"></script>
   
   	<!-- Custom scripts for all pages-->
   	<script src="${sdAdminMinJs}"></script>
   
   	<!-- Custom scripts for this page-->
   	<script src="${sdAdminDataTablesMinJs}"></script>
 
 
 