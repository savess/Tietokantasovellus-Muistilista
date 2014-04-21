<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">
<!DOCTYPE html>
<html>

    
        <body>
  <ul class="nav nav-tabs">
    <li><a href="Etusivu">Etusivu</a></li>
    <li><a href="LuokkaListausServlet">Luokat</a></li>
    <li><a href="TarkeysListausServlet">Tärkeysasteet</a></li>
   <li class="active"><a href="Omasivu">Oma sivu</a></li>
    <li><a href="KirjauduUlos">Kirjaudu ulos</a></li>
  </ul>
  <div class="container">
     
     
      <table class="table table-striped">
      <thead>
        <tr>
          <th>Nimi</th>
          <th>Tunnus</th>
          <th>Askareita</th>
          
          <th></th>
          
        
         
      <c:choose>
            <c:when test="${empty lista}">
                <p>Askaretta ei ole</p>
            </c:when>
            <c:otherwise>
          
          
          
          <c:forEach var="kayttaja" items="${lista}">
                    <tr>
                        
                         
                        
                      
                        <td id="kayttajalista">${kayttaja.nimi}</td>
                        <td id="kayttajalista">${tunnus}</td> 
                        <td id="kayttajalista">${kayttaja.acount}</td>
           
                     
                        
                       
                    </tr>
                    
                    
                    
                </c:forEach>
                    
                   
                    
                    </c:otherwise>
        </c:choose>
      
        
  </div>
</body>
        
</html>

   </t:pohja>

