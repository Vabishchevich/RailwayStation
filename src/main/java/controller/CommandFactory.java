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
        //Добавление элементов при помощи метода put(K key, V value)
        commands.put("Удалить запись о пользователе", new DeleteInformationAboutUsers());
        commands.put("Просмотр", new WorkWithUsers());
        commands.put("Добавить данные", new AddNewTrainAdmin());
        commands.put("Просмотр доступных поездов", new ViewTrainsAdmin());
        commands.put("Вход в систему", new LoginVerification());
        commands.put("Поехали", new ToBookATicketUser());
        commands.put("Продолжить", new ChoiceTrainUser());
        commands.put("Хороший выбор", new ChoiceTypeRailCarUser());
        commands.put("Оформить билет", new AddTicketUser());
        commands.put("Просмотр поездов", new ViewAllTrainsUser());
        commands.put("Войти", new PrivateOfficeUsers());
        commands.put("Удалить", new DeleteTicket());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter(COMMAND_PARAMETER);
        //String getParameter(String name) – определение значения параметра по его имени или null, если параметр с таким именем не задан
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
