<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">


<form name="lisaa luokka"
                  action="${pageContext.request.contextPath}/LisaaLuokka"
                  method="post">
                <tr>
                    <td>Luokan nimi:</td>
                    <td><input type="text" name="nimi" id="formfield"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Lisää" /> </td>
                </tr>
            </form>
    
    </t:pohja>
