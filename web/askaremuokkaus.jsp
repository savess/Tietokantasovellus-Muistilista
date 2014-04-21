
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
      <head><th>Tiedot nyt:</th><head/>
        <tr>
          <th>Askare</th>
          <th>Tärkeys</th>
          <th>Luokka</th>
          <th></th>
    
       
      
            
          
        
          <c:choose>
            <c:when test="${empty lista}">
                <p>Askaretta ei ole</p>
            </c:when>
            <c:otherwise>
          
          <c:forEach var="askare" items="${lista}">
                        
          <form name="muokkaa askaretta"
                  action="${pageContext.request.contextPath}/MuokkaaAskaretta2"
                  method="post">
                <tr>
                   <td id="askareetlista">${askare.nimi}
                   
                    <td id="askareetlista">${askare.tarkeys}</td> 
                    <td id="askareetlista">${askare.luokka}</td>
                    
                </tr>
                
                <tr>
                    
                </tr>
            </form>
                    
                </c:forEach>
                    
            </c:otherwise>
        </c:choose>
                   
         </tr>
      </thead>
     
    </table>
      
       <table class="table table-striped">
      <thead>
      <head><th>Uudet tiedot:</th><head/>
        <tr>
          <th>Askare</th>
          <th>Tärkeys</th>
          <th>Luokka</th>
          <th></th>
      
       
      
        <c:forEach var="askare" items="${lista}">
                 <form name="muokkaa askaretta"
                  action="${pageContext.request.contextPath}/MuokkaaAskaretta2"
                  method="post">
                <tr>
                    
                    <td><input type="text" name="nimi" maxlength=30 value="${askare.nimi}"></td>
                    <input type="hidden" name="id" value="${askare.aid}">
                    
                    </c:forEach>
                    
                    <label></label>
                    <td> <select name="tarkeys">
                        
                        <c:forEach var="tarkeys" items="${lista1}">
                            
                         <option value="${tarkeys.tid}" name="tarkeys">${tarkeys.selite}</option>
                        
                         </c:forEach>
                         
                    </select></td>
                 <label></label>
                 <td> <select name="luokka">
                       
                        <c:forEach var="luokka" items="${listaa}">
                          
                         <option value="${luokka.lid}" name="luokka">${luokka.nimi}</option>
                         
                         </c:forEach>
                    </select></td>
                <tr>
                <tr>
                 </tr>

                     
                    <td><input type="submit" value="Muokkaa" /> </td>
                </tr>
            </form>
        </tr>
      </thead>
     
    </table>
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
