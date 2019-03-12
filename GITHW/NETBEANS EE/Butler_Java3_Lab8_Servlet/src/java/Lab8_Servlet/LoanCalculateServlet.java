/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab8_Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tfran
 */
@WebServlet(name = "LoanCalculateServlet", urlPatterns = {"/"})
public class LoanCalculateServlet extends HttpServlet {
    
    LoanCalculator lc;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String amount = request.getParameter("amount");
            String air = request.getParameter("interestRate");
            String years = request.getParameter("yearNum");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                out.println("<head>");
                    out.println("<title>Servlet LoanCalculateServlet</title>");    
                out.println("</head>");
                out.println("<body>");
                    out.println("<h1>Loan Calculator Servlet</h1>");
                    out.println("<form method=\"post\">");
                        out.println("<p>Loan Amount: <input title=\"LoanAmt\" name=\"amount\" size=\"30\" tpe=\"text\" ></p>");
                        out.println("<p>Annual Interest Rate: <input title=\"IntAmt\" name=\"interestRate\" size=\"30\" tpe=\"text\" ></p>");
                        out.println("<p>Number of Years: <input title=\"Years\" name=\"yearNum\" size=\"30\" tpe=\"text\" ></p>");
                        out.println("<br/>");
                        out.println("<input type=\"submit\" value=\"Compute Loan Payment\"><button type=\"reset\" value=\"Reset\">Reset</button>");
                        
                    out.println("</form>");
                    
                    if(amount != null && amount.length() > 0){
                        if(air != null && air.length() > 0){
                            if(years != null && years.length() > 0){
                                NumberFormat CF = NumberFormat.getCurrencyInstance(Locale.getDefault());
                                Double loanAmt = Double.parseDouble(amount);
                                Double annInt = Double.parseDouble(air);
                                int yearNum = Integer.parseInt(years);
                                lc = new LoanCalculator(annInt, yearNum, loanAmt);
                                
                                out.println("<p>Loan Amount: " + CF.format(loanAmt) + "</p>");
                                out.println("<p>Annual Interest Rate: " + annInt + "</p>");
                                out.println("<p>Number of Years: " + yearNum + "</p>");
                                out.println("<p style=\"color:red;\">Monthly Payment: " + CF.format(lc.getMonthlyPayment()) + "</p>");
                                out.println("<p style=\"color:red;\">Total Payment: " + CF.format(lc.getTotalPayment()) + "</p>");
                            }
                        }
                    }
                out.println("</body>");
            out.println("</html>");
        }
        finally{
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

    /**
     * Handles the HTTP <code>POST</code> method.
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
