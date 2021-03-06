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
        <li><i class="fa fa-globe"></i> Country</li>
        <li> ${city.getCountryName()}</li>
        <li class="active"><a
                href="/country/${city.getCountryName().toLowerCase()}/${city.getCityName().toLowerCase()}"> ${city.getCityName()}</a>
        </li>
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
                    <div class="row margin-bottom">
                        <div class="col-sm-6">
                            <img class="img-responsive pad"
                                 src="<c:url value="/resources/img/country/${city.getCountryName()}/${city.getCityName()}.jpg"/>"
                                 alt="Photo">
                        </div>
                        <!-- /.col -->
                        <div class="col-sm-6">
                            <div class="row">
                                <div class="col-sm-6">
                                    <img class="img-responsive pad"
                                         src="<c:url value="/resources/img/country/${city.getCountryName()}/${city.getCityName()}.jpg"/>"
                                         alt="Photo">
                                    <br>
                                    <img class="img-responsive pad"
                                         src="<c:url value="/resources/img/country/${city.getCountryName()}/${city.getCityName()}.jpg"/>"
                                         alt="Photo">
                                </div>
                                <!-- /.col -->
                                <div class="col-sm-6">
                                    <img class="img-responsive pad"
                                         src="<c:url value="/resources/img/country/${city.getCountryName()}/${city.getCityName()}.jpg"/>"
                                         alt="Photo">
                                    <br>
                                    <img class="img-responsive pad"
                                         src="<c:url value="/resources/img/country/${city.getCountryName()}/${city.getCityName()}.jpg"/>"
                                         alt="Photo">
                                </div>
                                <!-- /.col -->
                            </div>
                            <!-- /.row -->
                        </div>
                        <!-- /.col -->
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
        </div>
    </div>
</section>