package Servlets;

import Models.Askare;
import Models.Listaus;
import Models.Kayttaja;
import Models.Luokka;
import Models.Tarkeys;
import Models.Yhteys;
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
// lisää uuden askareen tietokantaan 

public class LisaaAskare extends HttpServlet {
    private String lnimi;
    private RequestDispatcher dispatcher;


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
        PrintWriter out = response.getWriter();
        String idParam = request.getParameter("id");
        int id;
      
          Yhteys yhteys = new Yhteys();
          Listaus listaus = new Listaus();  
          Askare askare = new Askare();
          Kayttaja kayttaja = new Kayttaja();
            
            int tarkeysid = yhteys.haeIntArvo("tarkeys", request);
            int luokkaid = yhteys.haeIntArvo("luokka", request);
            
            String nimi = request.getParameter("nimi");
            askare.setNimi(request.getParameter("nimi"));
           
        
                
         HttpSession session=request.getSession(false);

         // tarkistaa onko käyttäjä kirjautunut
          if (session.getAttribute("kirjautunut")!=null) {

            String tunnus = (String) session.getAttribute("tunnus");
            
            
            
                     try {
            
            
                        //jos askaretta lisättäessä ei anneta nimeä: virheviesti 
                        if ((nimi == null || nimi.equals(""))) {
                        request.setAttribute("virheViesti", "Et antanut askareelle nimeä, lisäys epäonnistui");
                        dispatcher = request.getRequestDispatcher("Etusivu");
                        dispatcher.forward(request, response);}
            
            
                        // jos nimi annetaan, askare lisätään tietokantaan
                        // näytetään viesti onnistuneesta lisäyksestä siirryttäessä Etusivulle
                        else if ((nimi!=null)){
                        request.setAttribute("lista", listaus.lisaaAskare(nimi, tarkeysid, luokkaid, tunnus));             
                        request.setAttribute("viesti", "Askare lisätty");
                        dispatcher = request.getRequestDispatcher("Etusivu");
                        dispatcher.forward(request, response);  }
            
            
            
                } finally {            
                out.close();
                }
        
                 }
        // jos käyttjä ei ole kirjautunut siirrytään kirjatumissivulle  
        else  {
                response.sendRedirect("Kirjautuminen");
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
