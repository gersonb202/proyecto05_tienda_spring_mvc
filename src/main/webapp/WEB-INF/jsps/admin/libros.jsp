<%--
  Created by IntelliJ IDEA.
  User: gbaque
  Date: 30/09/2025
  Time: 19:09
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

Gestión de los libros de la tienda: <br>
<c:forEach items="${libros}" var ="libro">
    <div style="margin: 10px">
        titulo: ${libro.titulo} <br>
        <img src="subidas/${libro.id}.jpg" height="80px" <br>
        precio: ${libro.precio} <br>
        descripción: ${libro.descripcion} <br>
        <a onclick="return confirm('¿Estás seguro?')" href="borrarLibro?id=${libro.id}">BORRAR</a> <br>
        <a href="modificarLibro?id=${libro.id}">EDITAR</a>
    </div>
</c:forEach>

</body>
</html>
