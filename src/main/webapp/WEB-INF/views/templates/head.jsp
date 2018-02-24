<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Start Bootstrap Template</title>
  
  
  <spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapMinUrl"/>
  <spring:url value="/resources/vendor/font-awesome/css/font-awesome.min.css" var="fontAwesomeMinUrl"/>
  <spring:url value="/resources/vendor/datatables/dataTables.bootstrap4.css" var="dataTablesUrl"/>
  <spring:url value="/resources/css/sb-admin.css" var="sbAdminUrl"/>
  
  
  <!-- Bootstrap core CSS-->
  <link href="${bootstrapMinUrl}" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${fontAwesomeMinUrl}" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${dataTablesUrl}" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="${sbAdminUrl}" rel="stylesheet">
  
</head>