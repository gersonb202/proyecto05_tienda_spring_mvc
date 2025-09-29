<%--
  Created by IntelliJ IDEA.
  User: gbaque
  Date: 29/09/2025
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Introduce los datos del nuevo libro: <br>

Vamos a usar un form de spring: <br>

<springform:form modelAttribute="libro" method="guardarNuevoLibro">

    titulo: <springform:input path="titulo" /> <br>
    precio: <springform:input path="precio"/> <br>
    descripcion: <springform:textarea path="descripcion" rows="2" cols="18"/> <br>
    <input type="submit" value="REGISTRAR"/>
</springform:form>

</body>
</html>
