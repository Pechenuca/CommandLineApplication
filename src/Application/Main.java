package Application;

import Application.command.*;


import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static String path;
    {
        String filePath = System.getenv("INPUT_PATH");
        System.out.println(System.getenv("INPUT_PATH"));
        if (filePath == null){
            setPath("src\\ConsoleApp\\resources\\file.xml");
        }else{
            setPath(filePath+"file.xml");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String line = "";
        ConsoleCommands consoleCommands = new ConsoleCommands();
        Collection myCollection = new Collection(new File(getPath()));
        Command help = new HelpCommand(consoleCommands);
        Command info = new InfoCommand(consoleCommands);
        Command exit = new ExitCommand(consoleCommands);
        Command add = new AddCommand(consoleCommands);
        Command show = new ShowCommand(consoleCommands);
        Command remove = new RemoveCommand(consoleCommands);
        Command update = new UpdateCommand(consoleCommands);
        Command clear = new ClearCommand(consoleCommands);
        Command printDescending = new Print_Descending(consoleCommands);
        Command addIfMax = new ConsoleApp.Command.Add_If_MaxCommand(consoleCommands);
        Command removeGreater = new Remove_By_IdCommand(consoleCommands);
        Command filterContainsAnnualTurnover = new Filter_By_Annual_TurnoverCommand(consoleCommands);
        Command countGreaterThanOfficialAddress = new Count_Greater_Than_Official_AddressCommand(consoleCommands);

        Command save = new SaveCommand(consoleCommands);
        Command execute = new Script(consoleCommands);
        CommandManager mySwitch = new CommandManager();
        mySwitch.register("filter_contains_annual_turnover", filterContainsAnnualTurnover);
        mySwitch.register("save",save);
        mySwitch.register("execute_script",execute);
        mySwitch.register("count_greater_than_official_address",countGreaterThanOfficialAddress);
        mySwitch.register("print_descending", printDescending);
        mySwitch.register("help", help);
        mySwitch.register("info", info);
        mySwitch.register("exit", exit);
        mySwitch.register("add", add);
        mySwitch.register("show", show);
        mySwitch.register("update", update);
        mySwitch.register("remove_by_id", remove);
        mySwitch.register("clear", clear);
        mySwitch.register("add_if_max",addIfMax);
        mySwitch.register("remove_greater", removeGreater);
        while (!line.equals("exit")) {
            line = scanner.nextLine();
            String[] lines = line.split(" ");
            try {
                String command = lines[0];

                if (lines.length > 1) {
                    String arg = lines[1];
                    try {
                        mySwitch.execute(command, mySwitch.getCommandHashMap(), myCollection, arg);
                    } catch (IllegalStateException e) {
                        System.out.println("Вы ввели неправильную команду, попробуйте снова!");
                    } catch (ArgException | JAXBException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        mySwitch.execute(command, mySwitch.getCommandHashMap(), myCollection);
                    } catch (IllegalStateException e) {
                        System.out.println("Вы ввели неправильную команду, попробуйте снова!");
                    } catch (ArgException e) {
                        System.out.println(e.getMessage());
                    } catch (JAXBException e) {
                        e.printStackTrace();
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Вы ввели непрвильную команду, попробуйте снова");
            }

        }
        scanner.close();
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Main.path = path;
    }
}