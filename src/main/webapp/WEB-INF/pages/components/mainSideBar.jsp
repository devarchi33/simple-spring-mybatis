<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 15. 8. 23.
  Time: 오후 2:02
  To change this template use File | Settings | File Templates.
--%>
<aside class="main-sidebar">
    <!-- Inner sidebar -->
    <div class="sidebar">
        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">MAIN NAVIGATION</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="${userListActive}">
                <a href="/user/list">
                    <i class="fa fa-user"></i> <span>UserList</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
            </li>
            <li class="${countryListActive}" class="treeview">
                <a href="#">
                    <i class="fa fa-flag"></i> <span>Country</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class="${germany}">
                        <a href="#">
                            <i class="fa fa-globe"></i>German<i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li class="${dresden}">
                                <a href="/country/germany/dresden">
                                    <i class="fa fa-circle-o"></i> Dresden<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${hameln}">
                                <a href="/country/germany/hameln">
                                    <i class="fa fa-circle-o"></i> Hameln<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${munchen}">
                                <a href="/country/germany/munchen">
                                    <i class="fa fa-circle-o"></i> Munchen<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${berlin}">
                                <a href="/country/germany/berlin">
                                    <i class="fa fa-circle-o"></i> Berlin<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${fussen}">
                                <a href="/country/germany/fussen">
                                    <i class="fa fa-circle-o"></i> Fussen<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${stralsund}">
                                <a href="/country/germany/stralsund">
                                    <i class="fa fa-circle-o"></i> Stralsund<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${braunschweig}">
                                <a href="/country/germany/braunschweig">
                                    <i class="fa fa-circle-o"></i> Braunschweig<i
                                        class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${koln}">
                                <a href="/country/germany/koln">
                                    <i class="fa fa-circle-o"></i> Koln<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${bremen}">
                                <a href="/country/germany/bremen">
                                    <i class="fa fa-circle-o"></i> Bremen<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${stuttgart}">
                                <a href="/country/germany/stuttgart">
                                    <i class="fa fa-circle-o"></i> Stuttgart<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>

        </ul>
        <!-- /.sidebar-menu -->

    </div>
    <!-- /.sidebar -->
</aside>
<!-- /.main-sidebar -->