package Application.command;


import Application.CommandManager;
import Application.ConsoleCommands;

import java.util.Collection;
import java.util.HashMap;

public class ExitCommand extends Command {
        private final ConsoleCommands consoleCommands;

        public ExitCommand(ConsoleCommands consoleCommands){
            setDescription("завершить программу (без сохранения в файл)");
            this.consoleCommands = consoleCommands;
        }

        @Override
        public void execute(HashMap<String, Command> commandMap, Collection collection, CommandManager mySwitch, String... arg) {
            consoleCommands.exit();
        }
    }


