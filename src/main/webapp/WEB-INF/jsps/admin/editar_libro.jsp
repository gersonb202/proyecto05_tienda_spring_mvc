<%--
  Created by IntelliJ IDEA.
  User: gbaque
  Date: 03/10/2025
  Time: 15:57
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

<div>
    Editar productos:
</div>

<springform:form modelAttribute="libroEditar" method="post" action="guardarCambiosLibro">
    titulo: <springform:input path="titulo" /> <br>
    precio: <springform:input path="precio"/> <br>
    descripcion: <springform:textarea path="descripcion" rows="2" cols="18"/> <br>
    <springform:hidden path="id"/>
    <input type="submit" value="GUARDAR CAMBIOS"/>
</springform:form>

</body>
</html>
