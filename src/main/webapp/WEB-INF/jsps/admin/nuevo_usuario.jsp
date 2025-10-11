<%--
  Created by IntelliJ IDEA.
  User: gbaque
  Date: 06/10/2025
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

Introduce los datos de nuevo usuario: <br>

<springform:form modelAttribute="nuevoUsuario" action="guardarNuevoUsuario" >
    nombre: <springform:input path="nombre"/> <br>
    email: <springform:input path="email"/> <br>
    pass: <springform:input path="pass"/> <br>
    <input type="submit" value="REGISTRAR NUEVO USUARIO"/>
</springform:form>


</body>
</html>
