package command;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            //��� ��������� ������� ������������� � ��������� request ���������� HttpServletRequest, ������������ �������. ��� ���� �������� 
            //����� ������ �������� ��������� response ���������� HttpServletResponse, � ������� ����������� ���������� ��� �������� �������
            throws ServletException, IOException, ClassNotFoundException, SQLException;
}
