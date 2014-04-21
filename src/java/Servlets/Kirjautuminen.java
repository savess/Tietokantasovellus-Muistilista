package Servlets;

import Models.Kayttaja;
import Models.Yhteys;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
*
* @author saves
*/
// Kirjautuminen kirjaa käyttäjän sisään 

public class Kirjautuminen extends HttpServlet {
    
    private Yhteys yhteys = new Yhteys();
 public Kirjautuminen(){
     
 }

    /**
* Processes requests for both HTTP
* <code>GET</code> and
* <code>POST</code> methods.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(false);
        PrintWriter out = response.getWriter();
        
        try {
            
              if(session!=null) {
            session.invalidate();
        }
              
        RequestDispatcher dispatcher;
        
        String tunnus = request.getParameter("tunnus");
        String salasana = request.getParameter("salasana");
        String knimi="";
        Kayttaja kayttaja;
        session = request.getSession(true);
        
        
        if(tunnus!=null) {
            kayttaja = new Kayttaja(tunnus,salasana);
         
            
        }
        else {
            kayttaja=null;
        }
        
        if(yhteys.getKayttajanNimi(tunnus)!=null) {
            knimi=yhteys.getKayttajanNimi(tunnus);
        }
        
        //käyttäjä tunnistettu oikeaksi ja ohjataan Etusivulle
        if(kayttaja!=null&&yhteys.salasanaJaTunnusOikein(kayttaja.getKayttajatunnus(),kayttaja.getSalasana())) {
            session.setAttribute("tunnus", tunnus);
            session.setAttribute("nimi", knimi);
            session.setAttribute("kirjautunut", tunnus);
            
            response.sendRedirect("Etusivu");
        }
        
        //jos käyttäjä ei syötä mitään: virheviesti
        else if ((kayttaja == null || tunnus.equals("")) && (salasana == null || salasana.equals(""))) {
            request.setAttribute("virheViesti", "Et syöttänyt mitään");
            dispatcher = request.getRequestDispatcher("kirjautuminen.jsp");
            dispatcher.forward(request, response);}
        
        //jos käyttäjä ei syötä käyttäjää: virheviesti
        else if (kayttaja == null || tunnus.equals("")) {
            request.setAttribute("virheViesti", "Et syöttänyt käyttäjää");
            dispatcher = request.getRequestDispatcher("kirjautuminen.jsp");
            dispatcher.forward(request, response);
  }
        //jos käyttäjä ei syötä salasanaa: virheviesti
         else if (salasana == null || salasana.equals("")) {
            request.setAttribute("virheViesti", "Et syöttänyt salasanaa");
            dispatcher = request.getRequestDispatcher("kirjautuminen.jsp");
            dispatcher.forward(request, response);
  }
        
        
        
        //jos käyttäjä söttää virheellisiä tietoja: virheviesti
        else if(kayttaja!=null&&!yhteys.salasanaJaTunnusOikein(kayttaja.getKayttajatunnus(),kayttaja.getSalasana())) {
            request.setAttribute("virheViesti", "Syötit virheellisen tunnuksen tai salasanan");
            dispatcher = request.getRequestDispatcher("kirjautuminen.jsp");
            dispatcher.forward(request, response);
        }
        
        
        else {
            dispatcher = request.getRequestDispatcher("kirjautuminen.jsp");
            dispatcher.forward(request, response);
        }
    
          
                     
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
* Handles the HTTP
* <code>GET</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
* Handles the HTTP
* <code>POST</code> method.
*
* @param request servlet request
* @param response servlet response
* @throws ServletException if a servlet-specific error occurs
* @throws IOException if an I/O error occurs
*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
* Returns a short description of the servlet.
*
* @return a String containing servlet description
*/
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}


