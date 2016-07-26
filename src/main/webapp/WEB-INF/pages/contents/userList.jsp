<%--
  Created by IntelliJ IDEA.
  User: donghoon
  Date: 15. 8. 23.
  Time: 오후 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="content-header">
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active">UserList</li>
    </ol>
</section>
<br><br>
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">User Table</h3>
                    <div class="box-tools pull-right">
                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i
                                class="fa fa-minus"></i>
                        </button>
                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i
                                class="fa fa-remove"></i>
                        </button>
                    </div>
                </div>
                <!-- /.box-header -->
                <div class="box-body">
                    <div class="col-sm-12">
                        <table id="user_table" class="table table-striped table-bordered dataTable no-footer"
                               cellspacing="0" width="100%" role="grid" aria-describedby="user_table_info"
                               style="width: 100%;">
                            <thead>
                            <tr role="row">
                                <th class="sorting_desc" tabindex="0" aria-controls="user_table" rowspan="1" colspan="1"
                                    aria-label="Id: activate to sort column ascending" aria-sort="descending"
                                    style="width: 25px;">#
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="user_table" rowspan="1" colspan="1"
                                    aria-label="Name: activate to sort column ascending">Email
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="user_table" rowspan="1" colspan="1"
                                    aria-label="Explanation: activate to sort column ascending">
                                    Password
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="user_table" rowspan="1" colspan="1"
                                    aria-label="Explanation: activate to sort column ascending" style="width: 50px;">
                                    Edit
                                </th>
                                <th class="sorting" tabindex="0" aria-controls="user_table" rowspan="1" colspan="1"
                                    aria-label="Explanation: activate to sort column ascending" style="width: 50px;">
                                    Delete
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${userList}" varStatus="status">
                                <tr role="row" class="odd">
                                    <td><c:out value="${status.count}"/></td>
                                    <td class="sorting_1"><c:out value="${user.getEmail()}"/></td>
                                    <td class="sorting_1"><c:out value="${user.getPassword()}"/></td>
                                    <td>
                                        <button type="button" class="btn btn-block btn-info btn-flat full-width">Edit
                                        </button>
                                    </td>
                                    <td>
                                        <form:form role="form" action="/deleteUser" method="post"
                                                   onsubmit="return confirm('Are you really delete this user?')">
                                            <input type="hidden" name="email"
                                                   value="<c:out value="${user.getEmail()}"/>">
                                            <button type="submit" class="btn btn-block btn-danger btn-flat full-width">
                                                Delete
                                            </button>
                                        </form:form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
        </div>
    </div>
</section>