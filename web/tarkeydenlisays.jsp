<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">


<form name="lisaa tarkeys"
                  action="${pageContext.request.contextPath}/LisaaTarkeys"
                  method="post">
                <tr>
                    <td>Tärkeyden arvo:</td>
                    <td><input type="text" name="arvo" id="formfield"/></td>
                </tr>
                <tr>
                    <td>Selite:</td>
                    <td><input type="text" name="selite" id="formfield"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Lisää" /> </td>
                </tr>
            </form>
    
    </t:pohja>