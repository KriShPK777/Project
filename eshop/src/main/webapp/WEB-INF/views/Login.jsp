<%@include file="Header.jsp"%>

<h3 align="center">Login Page</h3>

<div class="container">
<body background="Loginpage.jpeg" class="user"></body>
<form action="perform_login" method="post">
<table class="table table-borderd responsive">
<tr class="success">
<td colspan="4" class="text-center">Sign in Here</td>
</tr>
<tr>
   <td colspan="4">User Name</td>
   <td colspan="4"> <input type="text" name="username"/></td>
   </tr>
   <tr>
      <td colspan="4">Password </td>
      <td colspan="4"> <input type="password" name="password"/></td>
      </tr>
      <tr>
          <td colspan="4">
          <input type="submit" value="Login" class="btn btn-success"/>
          </center>
          </td>
          </tr>
     
</table>
</form>
</div>