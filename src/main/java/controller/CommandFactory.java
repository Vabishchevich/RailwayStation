package controller;

import businessLogic.ToBookATicketUser;
import businessLogic.ViewAllTrainsUser;
import businessLogic.AddTicketUser;
import businessLogic.PrivateOfficeUsers;
import businessLogic.DeleteTicket;
import businessLogic.ChoiceTypeRailCarUser;
import businessLogic.ChoiceTrainUser;
import businessLogic.LoginVerification;
import businessLogic.ViewTrainsAdmin;
import businessLogic.WorkWithUsers;
import businessLogic.AddNewTrainAdmin;
import businessLogic.DeleteInformationAboutUsers;
import command.ICommand;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private static final String COMMAND_PARAMETER = "command";
    private static CommandFactory instance = null;

    Map<String, ICommand> commands = new HashMap<>();

    private CommandFactory() {
        //���������� ��������� ��� ������ ������ put(K key, V value)
        commands.put("������� ������ � ������������", new DeleteInformationAboutUsers());
        commands.put("��������", new WorkWithUsers());
        commands.put("�������� ������", new AddNewTrainAdmin());
        commands.put("�������� ��������� �������", new ViewTrainsAdmin());
        commands.put("���� � �������", new LoginVerification());
        commands.put("�������", new ToBookATicketUser());
        commands.put("����������", new ChoiceTrainUser());
        commands.put("������� �����", new ChoiceTypeRailCarUser());
        commands.put("�������� �����", new AddTicketUser());
        commands.put("�������� �������", new ViewAllTrainsUser());
        commands.put("�����", new PrivateOfficeUsers());
        commands.put("�������", new DeleteTicket());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter(COMMAND_PARAMETER);
        //String getParameter(String name) � ����������� �������� ��������� �� ��� ����� ��� null, ���� �������� � ����� ������ �� �����
        ICommand command = commands.get(action);
        return command;
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }
}
