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
                <p>Luokkaa ei ole</p>
            </c:when>
            <c:otherwise>
          
          
          
          <c:forEach var="luokka" items="${lista}">
                   
 
                        <form name="muokkaa luokkaa"
                  action="${pageContext.request.contextPath}/MuokkaaLuokkaa2"
                  method="post">
                <tr>
                    <td>Luokan nimi:</td>
                    <td><input type="text" name="nimi" maxlength=30 value="${luokka.nimi}"></td>
                     <input type="hidden" name="id" value="${luokka.lid}">
                    
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


