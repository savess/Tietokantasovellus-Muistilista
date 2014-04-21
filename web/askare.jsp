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
    <li><a href="Omasivu">Oma sivu</a></li>
    <li><a href="KirjauduUlos">Kirjaudu ulos</a></li>
  </ul>
  <div class="container">
     
     
      <table class="table table-striped">
      <thead>
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
                    <tr>
                        
                         
                        
                      
                        <td id="askareetlista">${askare.nimi}
          
           <br> </br> <a href="MuokkaaAskaretta?id=${askare.aid}">${Muokkaa}<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Muokkaa</button></a><a href="PoistaAskare?id=${askare.aid}">${Poista}<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Poista</button></a></td>
          
                        <td id="askareetlista">${askare.tarkeys}</td> 
                        <td id="askareetlista">${askare.luokka}</td>
                        
                       
                    </tr>
                    
                    
                    
                </c:forEach>
                    
                    
                   
                    
                    </c:otherwise>
        </c:choose>
      
        
  </div>
</body>
        
</html>

   </t:pohja>

