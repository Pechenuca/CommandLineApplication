package command;

import Source.Answer;
import Source.Organization;
import exception.ArgException;
import mainPackage.Collection;
import mainPackage.CommandExecutor;
import mainPackage.CommandManager;
import mainPackage.MyLogger;

import java.util.HashMap;

public class RemoveCommand extends Command {
    private final CommandExecutor commandExecutor;

    public RemoveCommand(CommandExecutor commandExecutor){
        setDescription("удалить элемент из коллекции по его id");
        setArgs(" id");
        this.commandExecutor = commandExecutor;
    }

    @Override

    public Answer execute(HashMap<String, Command> hashMap, Collection collection, CommandManager commandManager,
                          Organization organization, String... arg) {
        MyLogger.info("Выполнение команды REMOVE_BY_ID");
        try {
            return commandExecutor.remove_by_id(collection, Integer.parseInt(arg[0]));
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new ArgException();
        }
    }
}