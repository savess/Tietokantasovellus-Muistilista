
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Musitilista">


<form name="kirjautuminen"
                  action="${pageContext.request.contextPath}/Kirjautuminen"
                  method="post">
                <tr>
                    <td>Käyttäjätunnus:</td>
                    <td><input type="text" name="tunnus" id="formfield"/></td>
                </tr>
                <tr>
                    <td>Salasana:</td>
                    <td><input type="password" name="salasana" id="formfield"/> </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Kirjaudu" /> </td>
                </tr>
            </form>
    
    </t:pohja>