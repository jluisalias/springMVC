<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
   <head>
       <title>Formularios con Spring MVC</title>
   </head>
   <body>
       <h2>Datos del estudiante</h2>
       <form:form method="POST" action="/SpringForm/addStudent">
          <table>
             <tr>
                <td><form:label path="name">Nombre: </form:label></td>
                <td><form:input path="name" /></td>
             </tr>
             <tr>
                <td><form:label path="age">Edad: </form:label></td>
                <td><form:input path="age" /></td>
             </tr>
             <tr>
                <td><form:label path="id">ID: </form:label></td>
                <td><form:input path="id" /></td>
             </tr>
             <tr>
                <td colspan="2">
                   <input type="submit" value="Aceptar"/>
                </td>
             </tr>
          </table>  
       </form:form>
   </body>
</html>