<%--
  Created by IntelliJ IDEA.
  User: gbaque
  Date: 07/10/2025
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:include page="menu.jsp"></jsp:include>

Gestión de los usuarios registrados en la tienda: <br>
<c:forEach items="${usuarios}" var="usuario">
    <div style="margin: 10px">
        nombre: ${usuario.nombre} <br>
        email: ${usuario.email} <br>
        pass: ${usuario.pass} <br>
        <a onclick="return confirm('¿Estás seguro?')" href="borrarUsuario?id=${usuario.id}" >borrar usuario</a> <br>
        <a href="editarUsuario?id=${usuario.id}" >editar usuario</a> <br>
    </div>
</c:forEach>

</body>
</html>
