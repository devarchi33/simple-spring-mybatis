<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 15. 8. 23.
  Time: 오후 1:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<header class="main-header">
    <!-- Logo -->
    <a href="/main/home" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>dev</b>33</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>devarchi33</b>test</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <span class="hidden-xs">Login with <c:out
                                value="${sessionScope.get('loginUser').getEmail()}"/></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <p>
                                Login with <c:out value="${sessionScope.get('loginUser').getEmail()}"/>
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-right">
                                <form:form role="form" action="/logout" method="post"
                                           onsubmit="return confirm('Are you really sign out?')">
                                    <button type="submit" class="btn btn-default btn-flat">Sign out</button>
                                </form:form>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>