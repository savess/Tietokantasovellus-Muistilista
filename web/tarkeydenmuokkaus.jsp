<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">
<!DOCTYPE html>
<html>
   
        <body>
  
            
  <div class="container">
    
       
      <table class="table table-striped">
      <thead>
        <tr>
          
            
          <th></th>
          
        
           <c:choose>
            <c:when test="${empty lista}">
                <p>Tärkeyttä ei ole</p>
            </c:when>
            <c:otherwise>
          
          
          
          <c:forEach var="tarkeys" items="${lista}">
                   
                    
                    
                    
                    
                        
                        <form name="muokkaa tarkytta"
                  action="${pageContext.request.contextPath}/MuokkaaTarkeytta2"
                  method="post">
                <tr>
                    <td>Tärkeyden arvo:</td>
                    <td><input type="text" name="arvo" maxlength=30 value="${tarkeys.arvo}"></td>
                     <td>Tärkeyden selite:</td>
                    <td><input type="text" name="selite" maxlength=30 value="${tarkeys.selite}"></td>
                    
                     <input type="hidden" name="id" value="${tarkeys.tid}">
                    
                </tr>
                
                <tr>
                    <td><input type="submit" value="Muokkaa" /> </td>
                </tr>
            </form>
                       
                    
                    
                    
                    
                    
                </c:forEach>
                    
                    
                     
                    
                    </c:otherwise>
        </c:choose>
                    
                    
          
                    </tr>
      </thead>
     
    </table>
                    
                    
      
      
        
  </div>
</body>
        
</html>

   </t:pohja>


