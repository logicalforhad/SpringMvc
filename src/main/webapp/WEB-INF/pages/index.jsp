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
            <h1>Create Pizza</h1>
            <form:form class="form-horizontal" role="form" method="post" action="create" commandName="pizza">
                <div class="form-group">

                    <form:label class="control-label" path="name">Name:</form:label>


                    <form:input path="name" class="form-control" placeHolder="name"/>

                </div>
                <div class="form-group">
                    <form:label class="control-label" path="price">Price</form:label>

                    <form:input path="price" class="form-control" placeHolder="price"/>

                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-default" value="Add Pizza"/>
                </div>
            </form:form>
            <c:if test="${!empty pizzaList}">
                <h3>Pizzas</h3>
                <table class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>&nbsp;</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pizzaList}" var="pizza">
                        <tr>
                            <td>${pizza.name}</td>
                            <td>${pizza.price}</td>
                            <td>
                                <form action="/delete/${pizza.id}" method="post">
                                    <input type="submit" class="btn btn-danger btn-mini" value="Delete"/>

                                </form>
                            </td>
                            <td>
                                <form action="/edit/${pizza.id}" method="GET">
                                    <input type="submit" class="btn btn-small" value="edit">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

</body>
</html>
