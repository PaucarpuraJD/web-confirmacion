<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="layout/header.jsp" />
<h3>Crear Alumno</h3>
<form action="${pageContext.request.contextPath}/sacramentos/form" method="post">
<div class="row mb-2">
    <label for="nombre" class="col-form-label col-sm-2">Nombre</label>
    <div class="col-sm-4">
        <input type="text" name="nombre" id="nombre" value="${sacramento.nombre}" class="form-control">
    </div>
</div>

<div class="row mb-2">
    <div>
        <input class="btn btn-primary my-2" type="submit" value="${sacramento.id != null && sacramento.id > 0 ? "Editar" : "Crear"}">
        <a class="btn btn-success my-2" href="${pageContext.request.contextPath}/sacramentos">Cancelar</a>
    </div>
</div>
<input type="hidden" name="id" value="${sacramento.id}">
</form>
<jsp:include page="layout/footer.jsp" />