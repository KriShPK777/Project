<%@ include file="Header.jsp"%>"

<form:form action="InsertProduct" modelAttribute="product" method="post">"
<table align="center">
<tr>
<td colspan="2">Product Management </td>
</tr>
<tr>
<td>Product Name</td>
<td><form:input path="productName"/></td>
</tr>
<tr>
<td>Product Desc</td>
<td><form:input path="productDesc"/></td>
</tr>
<tr>
<td>Stock</td>
<td><form:input path="stock"/></td>
</tr>
<tr>
<td>Price</td>
<td><form:input path="price"/></td>
</tr>
<tr>
<td>Category </td>
<td>
<form:select path="categoryId">
</form:select>
</td>
</tr>
<tr>
<td>Supplier</td>
<td><form:input path="supplierId"/></td>
</tr>
<tr>
<td>Product Image</td>
<td><form:input type="file" path="pimage"/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="Insert Product"/>
</td>
</tr>
</form:form>

<br></br>

<table align="center">
<tr bgcolor="blue">
     <td>Product Name</td>
     <td>Stock</td>
     <td>Price</td>
     <td>Category</td>
     <td>Supplier</td>
     <td></td>
     </tr>
     <c:forEach items="$(productList)" var="product">
   <tr> 
     <td>$(product.productName)</td>
     <td>$(product.stock)</td>
     <td>$(product.price)</td>
     <td>$(product.catgoryId)</td>
     <td>$(product.supplierId)</td>
     <td>
    <a href="<c:url value="/editCategory/categoryId"/>">Edit</a>
    <a href="<c:url value="/deleteCategory/categoryId"/>">Delete</a>
    </td>
    </tr> 
    </c:forEach>
    </table>
