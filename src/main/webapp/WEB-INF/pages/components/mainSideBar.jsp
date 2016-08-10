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
                </a>
            </li>
            <li class="${countryListActive}" class="treeview">
                <a href="#">
                    <i class="fa fa-flag"></i> <span>Country</span>
                    <i class="fa fa-angle-left pull-right"></i>
                </a>
                <ul class="treeview-menu">
                    <li class="${germany}"><a href="/country/germany"><i class="fa fa-circle-o"></i>German</a></li>
                </ul>
            </li>

        </ul>
        <!-- /.sidebar-menu -->

    </div>
    <!-- /.sidebar -->
</aside>
<!-- /.main-sidebar -->