<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3 style="text-align:center">Actualizar datos de usuario</h3>
	<form:form commandName="usuario" action="usuario.htm?accion=upd2" method="post">
                <form:input path="usuId"/>
		<table style="margin:auto">
			<tr>
				<td>Nombre</td>
				<td>
                                    <form:input path="usuNombre"/>
                                </td>
                        </tr><tr>                                
				<td>Terminal</td>
				<td>
                                    <form:input path="usuTerminal"/>
                                </td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
                                <input type="submit" value="Enviar Datos"/></td>
			</tr>
		</table>
	</form:form>
        <p style="text-align:center">
            <a href="usuario.htm?accion=qry">Cancelar</a>
        </p>
</body>
</html>