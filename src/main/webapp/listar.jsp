<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h2 style="text-align: center">Listado de Sacramentos</h2>
<form action="${pageContext.request.contextPath}/sacramentos" method="post">
    <div class="input-group mb-3 mt-4">
        <div class="col-sm-3">
            <input type="text" name="nombre" class="form-control" autofocus>
        </div>
        <div class="mx-2">
            <input type="submit" value="Buscar" class="btn btn-secondary">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/sacramentos/form"> Crear [+] </a>
        </div>
    </div>
</form>
<table class="table table-hover table-striped" style="text-align: center">
    <tr>
        <th>Id</th>
        <th>Nombre</th>
        <th>Editar</th>
        <th>Eliminar</th>
    </tr>
    <c:forEach items="${sacramentos}" var="s">
    <tr>
        <td>${s.id}</td>
        <td>${s.nombre}</td>
        <td><a class="btn btn-success" href="${pageContext.request.contextPath}/sacramentos/form?id=${s.id}">editar</></td>
        <td><a class="btn btn-danger" onclick="return confirm('esta seguro que desea eliminar');"
         href="${pageContext.request.contextPath}/sacramentos/eliminar?id=${s.id}">eliminar</a></td>
    </tr>
    </c:forEach>
</table>
<jsp:include page="layout/footer.jsp" />