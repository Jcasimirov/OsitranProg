<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
</head>
<body>
        <h3>Mensaje del Sistema:</h3>
	
        <table>
                <tr>
                        <td>
                            ${msg}
                        </td>
                </tr>
        </table>
        <hr/>
<a href="usuario.htm?accion=qry">Lista de usuarios</a>
</body>
</html>