<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<ul class="nav justify-content-end">
  <li class="nav-item">
    <a class="nav-link active" href="/">Admin</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="user">User</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="cart">Cart</a>
  </li>
</ul>
<form:form modelAttribute="productAtt" style="margin: 2em; max-width:700px">
                   <h4>Add Product Form</h4>
                  <div class="form-group">
                    <label  for="ProductName">Name</label>
                    <form:input path="productName" class="form-control"/>
                  </div>

                  <div class="form-group">
                    <label for="productQty">Quantity</label>
                    <form:input path="productQuantity" class="form-control" />
                  </div>
                   <div class="form-group">
                      <label  for="productPrice">Price</label>
                      <form:input path="productPrice" class="form-control" />
                   </div>
                <button type="submit" class="btn btn-primary">Add</button>
        </form:form>
<br/>
<br/>

<h4 style="margin: 2em">Product List:</h4>
<table class="table table-hover" style="margin: 2em; max-width:700px">
<thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>

    <tbody>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.getProductName()}</td>
<td>${product.getProductQuantity()}</td>
<td>${product.getProductPrice()}</td>
<td>
<a href="delete?id=${product.id}"}><button class="btn btn-primary" value="delete" name="delete">Delete</button></a>
<a href="edit?id=${product.id}"}><button class="btn btn-primary" value="edit" name="edit">Edit</button></a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</html>