package command;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            //Все параметры запроса упаковываются в экземпляр request интерфейса HttpServletRequest, передаваемый сервлет. Ещё один параметр 
            //этого метода является экземпляр response интерфейса HttpServletResponse, в который загружается информация для передачи клиенту
            throws ServletException, IOException, ClassNotFoundException, SQLException;
}
