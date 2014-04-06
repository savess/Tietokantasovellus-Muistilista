<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:pohja pageTitle="Musitilista">
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
    <li class="active"><a href="etusivu.jsp">Etusivu</a></li>
    <li><a href="luokat.html">Luokat</a></li>
    <li><a href="tarkeys.html">Tärkysasteet</a></li>
    <li><a href="omasivu.html">Oma sivu</a></li>
    <li><a href="kirjautuminen.html">Kirjaudu ulos</a></li>
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
                <p>Muistilista on tyhjä</p>
            </c:when>
            <c:otherwise>
          
          
          
          <c:forEach var="askare" items="${lista}">
                    <tr>
                        
                        <td id="projektitlista">${askare.nimi}<br>  </br> <a href="askaremuokkaus.jsp"<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Muokkaa</button></a><a href="askarepoisto.jsp"<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span>Poista</button></a></td>
                        <td id="projektitlista">${askare.tarkeys}</td> 
                        <td id="projektitlista">${askare.luokka}</td>
                        
                       
                    </tr>
                    
                    
                    
                </c:forEach>
                    
                    
                     <td><a href="askareenlisays.jsp"<button type="submit" class="btn btn-xs btn-default"><span class="col-md-offset-0 col-md-1"></span> Lisää askare</button></a></td>   
                    
                    </c:otherwise>
        </c:choose>
                    
                    
          
                    </tr>
      </thead>
     
    </table>
                    
                    
      
      
        
  </div>
</body>
        
</html>

   </t:pohja>

