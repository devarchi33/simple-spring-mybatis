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
        <li><a href="#">UserList</a></li>
        <li class="active">editUser</li>
    </ol>
</section>
<br><br>
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">Edit User</h3>
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
                        <table class="table table-condensed">
                            <thead>
                            <tr role="row">
                                <th>Email</th>
                                <th>Password</th>
                                <th>Edit</th>
                                <th>Back</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr role="row" class="odd">
                                <form:form role="form" action="/user/editUser" method="post">
                                    <td><input type="text" name="editEmail" placeholder="email.."/>
                                    </td>
                                    <td><input type="password" name="editPassword" placeholder="password.."/>
                                    </td>
                                    <td>
                                        <button type="submit" class="btn btn-block btn-info btn-flat full-width">
                                            Edit
                                        </button>
                                    </td>
                                </form:form>
                                <td>
                                    <button type="submit" class="btn btn-block btn-success btn-flat full-width"
                                            onclick="history.back();">
                                        back
                                    </button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
        </div>
    </div>
</section>