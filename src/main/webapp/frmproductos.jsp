<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Productos"%>
<%
    Productos producto = (Productos) request.getAttribute("producto");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
    <fieldset>
        <p style="text-align: center; font-size: 22px">
            SEGUNDO PARCIAL TEM-742
        </p>
        <p style="text-align: center; font-size: 22px">
            Nombre: Marca Perez Dalilo
        </p>
        <p style="text-align: center; font-size: 22px">
            Carnet: 10943552 LP
        </p>
    </fieldset>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


    <title>PRODUCTOS</title>
</head>
<body>
    <div class="container">
        <h1>FORMULARIO DE PRODUCTOS</h1>
        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="option" value="productos"/>
        </jsp:include>
        <br>
        <form action="ProductosControlador" method="post">
            <input type="hidden" name="id" value="${productos.id}" />
            <div class="mb-3">
                <label for="" class="form-label">Descripcion</label>
                <input type="text" class="form-control" name="descripcion" value="${productos.descripcion}" placeholder="Escriba la descripcion">
            </div>
            <div class="mb-3">
                <label for="" class="form-label">cantidad</label>
                <input type="number" class="form-control" name="cantidad" value="${productos.cantidad}" placeholder="Escriba la cantidad">
            </div>
            
             <div class="mb-3">
                <label for="" class="form-label">Precio</label>
                <input type="number" step="0.01" class="form-control" name="precio" value="${productos.precio}" placeholder="Escriba el precio">
                
             </div>
 
            <div class="mb-3">
                <label for="" class="form-label">Categoria</label>
                <input type="text" class="form-control" name="categorias" value="${productos.categorias}" placeholder="Escriba la categoria">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>