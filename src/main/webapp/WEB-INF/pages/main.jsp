<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 15. 8. 23.
  Time: 오후 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>CubeoneAPI_Test</title>
    <%--style--%>
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/adminlte/dist/css/AdminLTE.min.css"/>"/>
    <link rel="stylesheet"
          href="<c:url value="/resources/bower_components/adminlte/dist/css/skins/_all-skins.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/adminlte/plugins/iCheck/flat/blue.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/adminlte/plugins/morris/morris.css"/>"/>
    <link rel="stylesheet"
          href="<c:url value="/resources/bower_components/adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/>"/>
    <link rel="stylesheet"
          href="<c:url value="/resources/bower_components/adminlte/plugins/datepicker/datepicker3.css"/>"/>
    <link rel="stylesheet"
          href="<c:url value="/resources/bower_components/adminlte/plugins/daterangepicker/daterangepicker-bs3.css"/>"/>
    <link rel="stylesheet"
          href="<c:url value="/resources/bower_components/adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css"/>"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="wrapper skin-black">

    <%@ include file="components/header.jsp" %>
    <%@ include file="components/mainSideBar.jsp" %>

    <div class="content-wrapper">
        <%@ include file="contents/userList.jsp" %>
    </div>

    <%--script--%>
    <!-- jQuery 2.1.4 -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/jQuery/jQuery-2.1.4.min.js"/>"></script>
    <!-- jQuery UI 1.11.4 -->
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.5 -->
    <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js" />"></script>
    <!-- Sparkline -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/sparkline/jquery.sparkline.min.js" /> "></script>
    <!-- jvectormap -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"/> "></script>
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"/> "></script>
    <!-- jQuery Knob Chart -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/knob/jquery.knob.js"/>"></script>
    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js"></script>
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/daterangepicker/daterangepicker.js"/>"></script>
    <!-- datepicker -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/datepicker/bootstrap-datepicker.js"/>"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"/>"></script>
    <!-- Slimscroll -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/slimScroll/jquery.slimscroll.min.js"/>"></script>
    <!-- FastClick -->
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/fastclick/fastclick.min.js"/>"></script>
    <!-- AdminLTE App -->
    <script src="<c:url value="/resources/bower_components/adminlte/dist/js/app.min.js"/>"></script>
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<c:url value="/resources/bower_components/adminlte/dist/js/pages/dashboard.js"/> "></script>
    <!-- AdminLTE for demo purposes -->
    <script src="<c:url value="/resources/bower_components/adminlte/dist/js/demo.js"/> "></script>
    <!-- Morris.js charts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="<c:url value="/resources/bower_components/adminlte/plugins/morris/morris.min.js"/> "></script>
</div>
</body>
</html>