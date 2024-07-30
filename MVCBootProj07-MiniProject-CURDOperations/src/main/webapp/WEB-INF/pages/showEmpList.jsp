<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1 style="color: blue;text-align: center;">Employee Details Page</h1>
<c:choose>
       <c:when test="${!empty eList }">
         <table border="1"align="center" bgcolor="yellow">
            <tr>
            <th>EMPNO</th> <th>EMPNAME</th><th>JOB</th>  <th>SAL</th><th>DEPTNO</th><th>Operations</th>
            </tr>   
            <c:forEach var="emp" items="${eList}">
               <tr>
                   <td>${emp.empNo}</td>
                   <td>${emp.empName}</td>
                   <td>${emp.job}</td>
                   <td>${emp.sal}</td>
                    <td>${emp.deptNo}</td>
                    <td><a href="edit?no1=${emp.empNo}"><img src="images/edit.png" width="20px" height="20px"></a>
                     <a href="delete?no2= ${emp.empNo}" onclick="return confirm('Do you really want to delete')"><img src="images/delete.jpg" width="20px" height="20px"></a></td>
                </tr>
            </c:forEach>
         </table>
       </c:when>
      <c:otherwise>
           <h1 style="color: red;text-align: center;">NO Recordes Are Found</h1>
      </c:otherwise> 
</c:choose>

         <h1 style="color: red;text-align: center;"><a href="register"><img  src="images/add.jpg" width="50px"  height="50px"></a>
         &nbsp; &nbsp; &nbsp;<a href="./"><img  src="images/home.jpg" width="50px"  height="50px"></a></h1>

         <br></br>
         
         <h1 style="color:green;text-align: center;">${resultMsg}</h1>
         
         