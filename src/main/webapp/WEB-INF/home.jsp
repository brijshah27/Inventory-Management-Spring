<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<h3>Add Product Form</h3>

<form:form modelAttribute="productAtt">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Add product form</h2></td>
                </tr>

                <tr>
                    <td>Product Name:</td>
                    <td><form:input path="productName" /></td>
                </tr>
                <tr>
                    <td>Product Quantity:</td>
                    <td><form:input path="productQuantity" /></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><form:input path="productPrice" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Add" /></td>
                </tr>
            </table>
        </form:form>
<br/>
<br/>
<c:forEach items="${products}" var="product">

<h1>${product.getProductName()}</h1>
<h4>Qty: ${product.getProductQuantity()}</h4>
<h4>Price: ${product.getProductPrice()}</h4>
<a href="delete?id=${product.id}"}><button value="delete" name="delete"></button></a>
</c:forEach>
</html>