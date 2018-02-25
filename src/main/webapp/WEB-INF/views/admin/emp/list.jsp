<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="../../templates/head.jsp"/>



<body class="fixed-nav sticky-footer bg-dark" id="page-top">

  <jsp:include page="../../templates/nav.jsp"/>
 	
  <div class="content-wrapper">
    <div class="container-fluid">
      
      <!-- Example DataTables Card-->
      <div class="card mb-3">
        <div class="card-header">
          <i class="fa fa-table"></i> Employee List</div>
        <div class="card-body">
          <div class="table-responsive" >
            <table class="table table-bordered" id="dataTable2" >
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Username</th>
                  <th>Firstname</th>
                  <th>Lastname</th>
                  <th>Salary</th>
                  <th>Email</th>
                  <th>Action</th>
				  
                </tr>
              </thead>
              <!--  
              <tfoot>
                <tr>
                  <th>Id</th>
                  <th>Username</th>
                  <th>Firstname</th>
                  <th>Lastname</th>
                  <th>Salary</th>
                  <th>Email</th>
                  <th></th>
				  <th></th>
                </tr>
              </tfoot>
              -->
              <tbody>
	          	<c:forEach items="${employees}" var="emp"> 
	            	<tr>
	                  <td>${emp.employeeId}</td>
	                  <td>${emp.username}</td>
	                  <td>${emp.firstname}</td>
	                  <td>${emp.lastname}</td>
	                  <td>${emp.salary}</td>
	                  <td></td>
	                  <%--  
	                  <td>${emp.email}</td>
	                   --%>
	                   	<td>
	                   		<spring:url value="/admin/emp/editform/${emp.employeeId}"  var="editEmpURL" />
	                   		<a href="${editEmpURL}" class="btn btn-info btn-xs"> 
	                   			<i class="glyphicon glyphicon-check"></i>Edit
							</a>
							&nbsp;
							<spring:url value="/admin/emp/deleteform/${emp.employeeId}"  var="delEmpURL" />
	        				<a href="${delEmpURL}" class="btn btn-danger btn-xs"> 
	        					<i class="glyphicon glyphicon-trash"></i> Delete
							</a>
						</td>
	                </tr>
				</c:forEach>
              </tbody>
              
            </table>
          </div>
        </div>
        <div class="card-footer small text-muted"></div>
      </div>
    </div>
    <!-- /.container-fluid-->
    
    
	<jsp:include page="../../templates/footer.jsp"/>

	<script type="text/javascript">
		//Call the dataTables jQuery plugin
		$(document).ready(function() {
		  $('#dataTable2').DataTable( {
		        "lengthMenu": [[5, 10, 20], [5, 10, 20]],
		        "language": {
		            "lengthMenu": "Display _MENU_ records per page",
		            "zeroRecords": "Nothing found - sorry",
		            "info": "Showing page _PAGE_ of _PAGES_",
		            "infoEmpty": "No records available",
		            "infoFiltered": "(filtered from _MAX_ total records)",		            
		        },
		        "ordering": false
		    } );
		});
	</script>



  </div>
  
</body>

</html>
