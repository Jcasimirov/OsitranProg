<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head></head>
    <body>
        <h3>Lista de Usuarios</h3>
        <table style="text-align:center">
            <tr>
                <td>Nombres</td>
                <td>Terminal</td>
                <td>UPD</td>
                <td>DEL</td>
            </tr>             
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>
                        ${user.usuNombre}
                    </td>
                    <td>
                        ${user.usuTerminal}
                    </td>
                    <th>
                        <a href="usuario.htm?accion=upd1&amp;id=${user.usuId}">${user.usuId}</a>
                    </th>
                    <th>
                        <a href="usuario.htm?accion=del&amp;id=${user.usuId}">${user.usuId}</a>
                    </th>
                </tr>
            </c:forEach>
        </table>
        <p style="text-align:center">
            <a href="usuario.htm?accion=ins1">Nuevo usuario</a>
        </p>
    </body>
</html>