package controller;

import command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; //������
import javax.servlet.http.HttpServletResponse; //�����
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Controller extends HttpServlet { //����������� ����� HttpServlet �������� �� ��������� �������� HTTP

    private final CommandFactory commandFactory = CommandFactory.getInstance();
    static final Logger logger = Logger.getLogger("Commander"); //������������ ������ �� ���������� �����, ������� � ����� ������ 
    //����� �� ��������� � ������ ������. ���� ����� ����� ���� �������, ���� ���� ������������� � ������ ������� �������� ��������� 
    //� ����� ���������

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //������ GET �������� (��� ���������) ����������
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //������ POST �������� (��� ����������) ������ �� ������
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param servletRequest servlet request
     * @param servletResponse servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            //ServletRequest ������, ������� ������������ ������ ������, ������ �� ��������. ServletResponse ������, 
            //������� ������������ ����� �������, ������������ � �������
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String page = null;
        ICommand command = commandFactory.getCommand(servletRequest);
        page = command.execute(servletRequest, servletResponse);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        //��������� RequestDispatcher ������������ ��� ������ � ��������������� ���������, � ������� ��������� ������ 
        //�������, �������� JSP ��� �������� HTML. ��� �������, ������ ��������� ������������ ��� ���������� ������������ 
        //����� ���������� � ����� ���������. ������ � RequestDispatcher ����� �������� � ������� ������ getRequestDispatcher(String url) 
        //���������� ServletContext
        try {
            requestDispatcher.forward(servletRequest, servletResponse);
            //forward - �������� ������ �� �������� �� ������� ������� (�������, ���� JSP, ��� ���� HTML) �� �������
        } catch (ServletException | IOException e) {
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description"; //������� ��������
    }// </editor-fold>
}
