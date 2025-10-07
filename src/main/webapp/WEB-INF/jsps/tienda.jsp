<%--
  Created by IntelliJ IDEA.
  User: gbaque
  Date: 30/09/2025
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="admin">Acceder a administración</a>
<div>Bienvenido a mi tienda</div>

<div>
    <a id="enlace_productos" href="#">PRODUCTOS</a> <br>
    <a id="enlace_identificarme" href="#">IDENTIFICARME</a> <br>
    <a id="enlace_registrarme" href="#">REGISTRARME</a> <br>
    <a id="" onclick="alert('por hacer...')" href="#">CARRITO</a> <br>
    <a id="" onclick="alert('por hacer...')" href="#">MIS PEDIDOS</a> <br>
</div>

<div id="contenedor"></div>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/mustache.js"></script>
<script type="text/javascript">
    var plantilla_registro = ""
    var plantilla_login = ""
    var plantilla_libros = ""

    $.get("plantillas_mustache/registrarme.html", function(valor){
        plantilla_registro = valor
    })

    $.get("plantillas_mustache/login.html", function(valor){
        plantilla_login = valor
    })

    $.get("plantillas_mustache/libros.html", function(valor){
        plantilla_libros = valor
    })

    function obtenerLibros(){
        $.get("librosREST/obtener", function(valor){
            var libros = JSON.parse(valor)
            console.log(libros)
            var info = Mustache.render(plantilla_libros, {xxx:"hola desde mustache", array_libros: libros})
            $("#contenedor").html(info)
        })
        $("#contendor").html("cargando...");
    }
    function mostrarLogin(){
        $("#contenedor").html(plantilla_login)
    }

    function mostrarRegistro(){
        $("#contenedor").html(plantilla_registro)
        // Vamos a interceptar el envío de formulario
        $("#form_registro").submit(function(evento){
            evento.preventDefault()
            //alert("Se intenta enviar el formulario")
            // Recoger los datos del form y mandarlos a UsuariosREST
            var nombre = $("#nombre").val()
            var email = $("#email").val()
            var pass = $("#pass").val()
            $.post("usuariosREST/registrar",{
                nombre: nombre,
                email: email,
                pass: pass
            }).done(function(res){
                alert(res)
            }) // end done
        })// end submit
    }// end mostrarRegistro

    // Atención a eventos:

    $("#enlace_productos").click(obtenerLibros)
    $("#enlace_identificarme").click(mostrarLogin)
    $("#enlace_registrarme").click(mostrarRegistro)

    // Función a invocar por defecto:
    obtenerLibros()
</script>
</body>
</html>
