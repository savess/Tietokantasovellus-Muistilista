
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">
<!DOCTYPE html>
<html>

        <body>
  
  <div class="container">
    
      <form name="lisaa askare"
                  action="${pageContext.request.contextPath}/LisaaAskare"
                  method="post">
                <tr>
                    <td>Askareen nimi:</td>
                    <td><input type="text" name="nimi" id="formfield"/></td>
                     
                </tr>
                <label>Tärkeys</label>
                    <select name="tarkeys">
                        
                        <c:forEach var="tarkeys" items="${lista}">
                            
                         <option value="${tarkeys.tid}" name="tarkeys">${tarkeys.selite}</option>
                        
                         </c:forEach>
                         
                    </select>
                 <label>Luokka</label>
                    <select name="luokka">
                       
                        <c:forEach var="luokka" items="${listaa}">
                          
                         <option value="${luokka.lid}" name="luokka">${luokka.nimi}</option>
                         
                         </c:forEach>
                    </select>
                <tr>
                     
                    <td><input type="submit" value="Lisää" /> </td>
                </tr>
            </form>
       
      <table class="table table-striped">
          
          
          
          
          
      <thead>
        <tr>
         
                    
                    
          
                    </tr>
      </thead>
      
      
       
     
    </table>
                    
                    
      
      
        
  </div>
</body>
        
</html>

   </t:pohja>


