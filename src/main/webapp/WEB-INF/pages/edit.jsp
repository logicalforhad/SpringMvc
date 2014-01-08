<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Pizza</title>
    <link rel="stylesheet" type="text/css" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <h1>Edit Pizza</h1>
            <form:form class="form-horizontal" role="form" method="post" commandName="editPizza">
                <div class="form-group">

                    <form:label class="control-label" path="name">Name:</form:label>


                    <form:input path="name" class="form-control" value="${editPizza.name}"/>

                </div>
                <div class="form-group">
                    <form:label class="control-label" path="price">Price</form:label>

                    <form:input path="price" class="form-control" value="${editPizza.price}"/>

                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-default" value="Update"/>
                </div>
            </form:form>

        </div>
    </div>
</div>

</body>
</html>