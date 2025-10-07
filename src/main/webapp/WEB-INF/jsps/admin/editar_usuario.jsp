<%--
  Created by IntelliJ IDEA.
  User: gbaque
  Date: 07/10/2025
  Time: 16:05
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
Editar los datos del usuario: <br>
<springform:form modelAttribute="usuarioEditar" action="guardarCambiosUsuario">
    nombre: <springform:input path="nombre"/> <br>
    email: <springform:input path="email"/> <br>
    pass: <springform:input path="pass"/> <br>
    <springform:hidden path="id"/>
    <input type="submit" value="GUARDAR CAMBIOS"/>
</springform:form>
</body>
</html>
