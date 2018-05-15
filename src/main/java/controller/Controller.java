package controller;

import command.ICommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; //«апрос
import javax.servlet.http.HttpServletResponse; //ќтвет
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Controller extends HttpServlet { //јбстрактный класс HttpServlet отвечает за обработку запросов HTTP

    private final CommandFactory commandFactory = CommandFactory.getInstance();
    static final Logger logger = Logger.getLogger("Commander"); //¬озвращаетс€ логгер по указанному имени, которое в общем случае 
    //может не совпадать с именем класса. Ётот метод может быть полезен, если есть необходимость в разных классах выводить сообщени€ 
    //в одной категории

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //«апрос GET получает (или извлекает) информацию
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
    //«апрос POST помещает (или отправл€ет) данные на сервер
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
            //ServletRequest объект, который представл€ет запрос клиент, делает из сервлета. ServletResponse объект, 
            //который представл€ет ответ сервлет, возвращаетс€ к клиенту
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String page = null;
        ICommand command = commandFactory.getCommand(servletRequest);
        page = command.execute(servletRequest, servletResponse);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        //»нтерфейс RequestDispatcher используетс€ дл€ работы с дополнительными ресурсами, к которым относ€тс€ другой 
        //сервлет, страница JSP или документ HTML.  ак правило, данный интерфейс используетс€ дл€ внутренней коммуникации 
        //между сервлетами в одном контексте. ƒоступ к RequestDispatcher можно получить с помощью метода getRequestDispatcher(String url) 
        //интерфейса ServletContext
        try {
            requestDispatcher.forward(servletRequest, servletResponse);
            //forward - передает запрос от сервлета до другого ресурса (сервлет, файл JSP, или файл HTML) на сервере
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
        return "Short description"; // раткое описание
    }// </editor-fold>
}
