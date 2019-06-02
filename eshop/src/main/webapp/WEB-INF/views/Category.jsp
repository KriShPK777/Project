<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
<form action="InsertCategory" method="post">
<table align="center">
<tr>
<td colspan="2">Category Management</td>
</tr>
<tr>

<td> Category Name </td>
<td> <input type="text" name="categoryId"/></td>
</tr>
<tr>
<td> Category Desc</td>
<td> <input type="text" name="categoryDesc"/></td>
</tr>
<tr>
<td colspan="2">
<center>
<input type="submit" value="Insert Category">
</center>
</td>
</tr>
</table>
</form>

<br></br>

<table align="center">
<tr>
<td> SL # </td>
<td> Category Name </td>
<td> Category Desc </td>
<td> </td>
<c:forEach items="$(categoryList)" var="category">
<tr>
<td></td>
<td>$(category.categoryName)</td>
<td>$(category.categoryDesc)</td>
<td>
<a href="<c:url value="/editCategory/categoryId"/>">Edit</a>
<a href="<c:url value="/deleteCategory/categoryId"/>">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>