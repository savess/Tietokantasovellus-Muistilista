package Servlets;

import Models.Listaus;
import Models.Luokka;
import Models.Tarkeys;
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
public class LisaaTarkeys extends HttpServlet {

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

          if (session.getAttribute("kirjautunut")!=null) {

            String tunnus = request.getParameter("kirjautunut");
        
        try {
            
            
            
             Listaus listaus = new Listaus();
            Tarkeys tarkeys = new Tarkeys();
            
            String selite = request.getParameter("selite");
            
            tarkeys.setSelite(request.getParameter("selite"));
            
             String arvo = request.getParameter("arvo");
            
            tarkeys.setArvo(request.getParameter("arvo"));
            
            
             request.setAttribute("lista", listaus.lisaaTarkeys(arvo, selite, 1));
             
             RequestDispatcher dispatcher = request.getRequestDispatcher("TarkeysListausServlet");
                             dispatcher.forward(request, response);
            
            
             
            
            
        } finally {            
            out.close();
        }
        
                 }
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