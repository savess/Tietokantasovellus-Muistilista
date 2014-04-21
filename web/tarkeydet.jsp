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
    <li class="active"><a href="TarkeysListausServlet">Tärkeysasteet</a></li>
    <li><a href="Omasivu">Oma sivu</a></li>
    <li><a href="KirjauduUlos">Kirjaudu ulos</a></li>
  </ul>
  <div class="container">
    
       
      <table class="table table-striped">
      <thead>
        <tr>
          <th>Arvo</th>
          <th>Selite</th>
          <th>Tekijän nimi</th>
          <th></th>
          
        
           <c:choose>
            <c:when test="${empty lista}">
                <p>Tärkeyslista on tyhjä</p>
            </c:when>
            <c:otherwise>
          
          
          
          <c:forEach var="tarkeys" items="${lista}">
                    <tr>
                        
                         
                        
                      
                        <td id="tarkeyslista"<li><a href="TarkeysServlet?id=${tarkeys.tid}">${tarkeys.arvo}</a></li>
          
          <br> </br> <a href="MuokkaaTarkeytta?id=${tarkeys.tid}">${Muokkaa}<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Muokkaa</button></a><a href="PoistaTarkeys?id=${tarkeys.tid}">${Poista}<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Poista</button></a></td>
          
                        <td id="tarkeyslista">${tarkeys.selite}</td> 
                        <td id="tarekyslista">${tarkeys.knimi}</td>
                        
                       
                    </tr>
                    
                    
                    
                </c:forEach>
                    
                    
                     <td><a href="tarkeydenlisays.jsp"<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span> Lisää tärkeys</button></a></td>   
                    
                    </c:otherwise>
        </c:choose>
                    
                    
          
                    </tr>
      </thead>
     
    </table>
                    
                    
      
      
        
  </div>
</body>
        
</html>

   </t:pohja>


