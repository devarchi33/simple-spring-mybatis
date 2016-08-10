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
        <li> Country</li>
        <li> ${city.getCountryName()}</li>
        <li class="active"> ${city.getCityName()}</li>
    </ol>
</section>
<br><br>
<section class="content">
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">${city.getCityName()}</h3>
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

                </div>
                <!-- /.box-body -->
            </div>
        </div>
    </div>
</section>