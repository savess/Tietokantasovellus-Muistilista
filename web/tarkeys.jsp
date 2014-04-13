<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Muistilista">
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    
        <body>
  <ul class="nav nav-tabs">
    <li><a href="Etusivu">Etusivu</a></li>
    <li><a href="LuokkaListausServlet">Luokat</a></li>
    <li><a href="TarkeysListausServlet">Tärkeysasteet</a></li>
    <li><a href="omasivu.html">Oma sivu</a></li>
    <li><a href="kirjautuminen.html">Kirjaudu ulos</a></li>
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
                <p>Tärkeyttä ei ole</p>
            </c:when>
            <c:otherwise>
          
          
          
          <c:forEach var="tarkeys" items="${lista}">
                    <tr>
                        
                         
                        
                      
                        <td id="tarkeyslista">${tarkeys.arvo}
          
           <br> </br> <a href="MuokkaaTarkeytta?id=${tarkeys.tid}">${Muokkaa}<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Muokkaa</button></a><a href="PoistaTarkeys?id=${tarkeys.tid}">${Poista}<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Poista</button></a></td>
          
                        <td id="tarkeyslista">${tarkeys.selite}</td> 
                        <td id="tarkeyslista">${tarkeys.knimi}</td>
                        
                       
                    </tr>
                    
                    
                    
                </c:forEach>
                    
                    
                   
                    
                    </c:otherwise>
        </c:choose>
      
        
  </div>
</body>
        
</html>

   </t:pohja>



