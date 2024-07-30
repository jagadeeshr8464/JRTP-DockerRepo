<%@ page isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<h1 style="color: blue;text-align: center;"> Edit the Employee Details::</h1>

<frm:form modelAttribute="emp">
    <table border="1"align="center" bgcolor="green">
     <tr>
    <td>Employee No</td>
    <td><frm:input path="empNo" readonly="true"/></td>
    </tr>
    <tr>
    <td>Employee Name</td>
    <td><frm:input path="empName"/></td>
    </tr>
     <tr>
    <td>Employee Designation</td>
    <td><frm:input path="job"/></td>
    </tr>
     <tr>
    <td>Employee Salary</td>
    <td><frm:input path="sal"/></td>
    </tr>
     <tr>
    <td>Employee Department No</td>
    <td><frm:input type="number" min="5" max="10" path="deptNo" /></td>
    </tr>
     <tr>
    <td><input  type="submit" value="Edit Employee"></input></td>
    </tr>
    </table>
</frm:form>