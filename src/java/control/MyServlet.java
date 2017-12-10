package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NathanG
 */
public class MyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
           response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                String buttonPress = request.getParameter("signupSubmit");
                //if this isn't null then button with signupSubmit name was pressed
                if (buttonPress != null){
                    String firstName = request.getParameter("firstName");
                    String lastName = request.getParameter("lastName");
                    int age = parseInt(request.getParameter("age"));
                    int yearsLeft = 18 - age;
                    if (age <18){
                        out.println("<p>Thank you for your interst. Sadly"
                                + " you must be at least 18 years old to enroll."
                                + " You stated that you were only "+age+" years old."
                                + " Plese wait "+yearsLeft+ " more years before enrolling.");
                    }
                    else{
                    out.println("<h2> Thank you for enrolling "+firstName +" "+ lastName +".");
                    out.println("<p>You've just taken a very important step in your career."
                            + "  By the time you finish with us you'll be certified to"
                            + " work at some job somewhere.  Isn't that Great!</p>");
                    }
                } else {
                buttonPress = request.getParameter("shopping");
                if (buttonPress != null){
                    String username=request.getParameter("username");
                    String password=request.getParameter("password");
                    MemberControl member = new MemberControl();
                    member.addMember(username, password);
                    //If I get this to work then just add in the hibernate thing for database.
                }else{
                    String user=request.getParameter("user");
                    out.println("<h2> Welcome "+user+ " </h2>");
                }
            } 
            } finally {
                out.close();
            }
        }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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

//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }

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
