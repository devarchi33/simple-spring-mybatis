<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 15. 8. 24.
  Time: 오전 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>devarchi33_test Join</title>

    <%--style--%>
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/bower_components/font-awesome/css/font-awesome.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/form-elements.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/styleSignUp.css"/>">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <%-- Favicon and touch icons --%>
    <link rel="shortcut icon" href="<c:url value="/resources/ico/favicon.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="<c:url value="/resources/ico/apple-touch-icon-144-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="<c:url value="/resources/ico/apple-touch-icon-114-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="<c:url value="/resources/ico/apple-touch-icon-72-precomposed.png"/>">
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="<c:url value="/resources/ico/apple-touch-icon-57-precomposed.png"/>">
</head>
<body>
<!-- Top menu -->
<%--<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">--%>
<%--<div class="container">--%>
<%--<div class="navbar-header">--%>
<%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#top-navbar-1">--%>
<%--<span class="sr-only">Toggle navigation</span>--%>
<%--<span class="icon-bar"></span>--%>
<%--<span class="icon-bar"></span>--%>
<%--<span class="icon-bar"></span>--%>
<%--</button>--%>
<%--<a class="navbar-brand" href="#">devarchi33_test Registration Form</a>--%>
<%--</div>--%>
<%--<!-- Collect the nav links, forms, and other content for toggling -->--%>
<%--<div class="collapse navbar-collapse" id="top-navbar-1">--%>
<%--<ul class="nav navbar-nav navbar-right">--%>
<%--<li>--%>
<%--<span class="li-text">--%>
<%--Put some text or--%>
<%--</span>--%>
<%--<a href="#"><strong>links</strong></a>--%>
<%--<span class="li-text">--%>
<%--here, or some icons:--%>
<%--</span>--%>
<%--<span class="li-social">--%>
<%--<a href="#"><i class="fa fa-facebook"></i></a>--%>
<%--<a href="#"><i class="fa fa-twitter"></i></a>--%>
<%--<a href="#"><i class="fa fa-envelope"></i></a>--%>
<%--<a href="#"><i class="fa fa-skype"></i></a>--%>
<%--</span>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</div>--%>
<%--</div>--%>
<%--</nav>--%>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-7 text">
                    <h1><strong>devarchi33_test</strong> Registration Form</h1>

                    <div class="description">
                        <p>
                            <c:out value="${message}"/>
                        </p>
                    </div>
                    <div class="top-big-link">
                        <a class="btn btn-link-1" href="/">Login</a>
                        <%--<a class="btn btn-link-2" href="#">Button 2</a>--%>
                    </div>
                </div>
                <div class="col-sm-5 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>Sign up now</h3>

                            <p>Fill in the form below to get instant access:</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-pencil"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form:form modelAttribute="user" role="form" action="signUp" method="post"
                                   class="registration-form">
                            <%--<div class="form-group">--%>
                            <%--<label class="sr-only" for="email">Email</label>--%>
                            <%--<form:input path="email" placeholder="Email.."--%>
                            <%--class="form-email form-control" id="form-email"/>--%>
                            <%--</div>--%>
                            <div class="form-group">
                                <label class="sr-only" for="form-email">Email</label>
                                <input type="email" name="email" placeholder="Email..."
                                       class="form-email form-control" id="form-email">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="password">Password</label>
                                <form:password path="password" placeholder="Password.."
                                               class="form-password form-control" id="form-password"/>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="authority">Authority</label>
                                <form:select path="authority" placeholder="Authority.."
                                             class="form-authority form-control" id="form-authority">
                                    <form:option value="권한을 선택하세요." disabled="true"/>
                                    <form:option value="admin"/>
                                    <form:option value="manager"/>
                                    <form:option value="monitor"/>
                                </form:select>
                            </div>
                            <button type="submit" class="btn">Sign me up!</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%-- Javascript --%>
    <script src="<c:url value="/resources/bower_components/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/jquery-backstretch/jquery.backstretch.min.js"/>"></script>
    <script src="<c:url value="/resources/bower_components/retina.js/dist/retina.min.js"/>"></script>
    <script src="<c:url value="/resources/js/scriptsSignUp.js"/>"></script>

    <!--[if lt IE 10]>
    <script src="<c:url value="/resources/js/placeholder.js"/>"></script>
    <![endif]-->


</div>
</body>
</html>