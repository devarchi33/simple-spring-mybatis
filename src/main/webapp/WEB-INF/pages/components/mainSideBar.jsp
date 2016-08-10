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
                    <li class="${usa}">
                        <a href="#">
                            <i class="fa fa-globe"></i>USA<i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li class="${boston}">
                                <a href="/country/usa/boston">
                                    <i class="fa fa-circle-o"></i> Boston<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${la}">
                                <a href="/country/usa/la">
                                    <i class="fa fa-circle-o"></i> La<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${washington}">
                                <a href="/country/usa/washington">
                                    <i class="fa fa-circle-o"></i> Washington<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${baltimore}">
                                <a href="/country/usa/baltimore">
                                    <i class="fa fa-circle-o"></i> Baltimore<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${texas}">
                                <a href="/country/usa/texas">
                                    <i class="fa fa-circle-o"></i> Texas<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${philadelphia}">
                                <a href="/country/usa/philadelphia">
                                    <i class="fa fa-circle-o"></i> Philadelphia<i
                                        class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${sandiego}">
                                <a href="/country/usa/sandiego">
                                    <i class="fa fa-circle-o"></i> Sandiego<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${arizona}">
                                <a href="/country/usa/arizona">
                                    <i class="fa fa-circle-o"></i> Arizona<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${chicago}">
                                <a href="/country/usa/chicago">
                                    <i class="fa fa-circle-o"></i> Chicago<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${seattle}">
                                <a href="/country/usa/seattle">
                                    <i class="fa fa-circle-o"></i> Seattle<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="${uk}">
                        <a href="#">
                            <i class="fa fa-globe"></i>UK<i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li class="${cardiff}">
                                <a href="/country/uk/cardiff">
                                    <i class="fa fa-circle-o"></i> Cardiff<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${leeds}">
                                <a href="/country/uk/leeds">
                                    <i class="fa fa-circle-o"></i> Leeds<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${birmingham}">
                                <a href="/country/uk/birmingham">
                                    <i class="fa fa-circle-o"></i> Birmingham<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${liverpool}">
                                <a href="/country/uk/liverpool">
                                    <i class="fa fa-circle-o"></i> Liverpool<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${manchester}">
                                <a href="/country/uk/manchester">
                                    <i class="fa fa-circle-o"></i> Manchester<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${london}">
                                <a href="/country/uk/london">
                                    <i class="fa fa-circle-o"></i> London<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${southamton}">
                                <a href="/country/uk/southamton">
                                    <i class="fa fa-circle-o"></i> Southamton<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${norwich}">
                                <a href="/country/uk/norwich">
                                    <i class="fa fa-circle-o"></i> Norwich<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${leicester}">
                                <a href="/country/uk/leicester">
                                    <i class="fa fa-circle-o"></i> Leicester<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${newcastle}">
                                <a href="/country/uk/newcastle">
                                    <i class="fa fa-circle-o"></i> Newcastle<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="${korea}">
                        <a href="#">
                            <i class="fa fa-globe"></i>Korea<i class="fa fa-angle-left pull-right"></i>
                        </a>
                        <ul class="treeview-menu">
                            <li class="${incheon}">
                                <a href="/country/korea/incheon">
                                    <i class="fa fa-circle-o"></i> Incheon<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${seoul}">
                                <a href="/country/korea/seoul">
                                    <i class="fa fa-circle-o"></i> Seoul<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${bucheon}">
                                <a href="/country/korea/bucheon">
                                    <i class="fa fa-circle-o"></i> Bucheon<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${ilsan}">
                                <a href="/country/korea/ilsan">
                                    <i class="fa fa-circle-o"></i> Ilsan<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${suwon}">
                                <a href="/country/korea/suwon">
                                    <i class="fa fa-circle-o"></i> Suwon<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${daegu}">
                                <a href="/country/korea/daegu">
                                    <i class="fa fa-circle-o"></i> Daegu<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${pusan}">
                                <a href="/country/korea/pusan">
                                    <i class="fa fa-circle-o"></i> Pusan<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${gwangju}">
                                <a href="/country/korea/gwangju">
                                    <i class="fa fa-circle-o"></i> Gwangju<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${daejeon}">
                                <a href="/country/korea/daejeon">
                                    <i class="fa fa-circle-o"></i> Daejeon<i class="fa fa-angle-left pull-right"></i>
                                </a>
                            </li>
                            <li class="${jeju}">
                                <a href="/country/korea/jeju">
                                    <i class="fa fa-circle-o"></i> Jeju<i class="fa fa-angle-left pull-right"></i>
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