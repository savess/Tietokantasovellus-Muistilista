package Servlets;

import Models.Listaus;
import Models.Luokka;
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
// MuokkaaLuokkaa2 muokkaa luokkaa tietokannassa

public class MuokkaaLuokkaa2 extends HttpServlet {
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
        HttpSession session=request.getSession(false);
          
           // tarkastetaan onko käyttäjä kirjautunut
          if (session.getAttribute("kirjautunut")!=null) {

            String tunnus = request.getParameter("kirjautunut");
        
            try {
                id = Integer.parseInt(idParam);
            
                Listaus listaus = new Listaus();
                Luokka luokka = new Luokka();
            
                String nimi = request.getParameter("nimi");
                luokka.setNimi(request.getParameter("nimi"));
            
                    // jos ei anneta nimeä: virheviesti
                    if ((nimi == null || nimi.equals(""))) {
                        request.setAttribute("virheViesti", "Ei nimeä, muokkaus epäonnistui");
                        dispatcher = request.getRequestDispatcher("LuokkaListausServlet");
                        dispatcher.forward(request, response);}
                    
                    // jos annetaan nimi muokataan luokkaa tietokantaan 
                    // viesti onnistuneesta muokkauksesta Etusivulle siirryttäessä
                    else if ((nimi!=null)){
                            request.setAttribute("lista", listaus.muokkaaLuokkaa(nimi, id));
                            request.setAttribute("viesti", "Luokkaa muokattu");
                            dispatcher = request.getRequestDispatcher("LuokkaListausServlet");
                            dispatcher.forward(request, response); 
            
            
                }
            
            
             } finally {            
                      out.close();
                 }
        
                 }
        // jos käyttäjä ei ole kirjautunut ohjataan kirjautumissivulle 
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
