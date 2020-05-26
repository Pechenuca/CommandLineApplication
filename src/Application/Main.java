package Application;

import Application.command.*;


import javax.xml.bind.JAXBException;
import java.util.Scanner;

public class Main {
    private static String path;
    {
        String filePath = System.getenv("INPUT_PATH");
        System.out.println(System.getenv("INPUT_PATH"));
        if (filePath == null){
            setPath("src\\ConsoleApp\\resources\\data.json");
        }else{
            setPath(filePath+"data.json");
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        String line = "";
        ConsoleCommands consoleCommands = new ConsoleCommands();
        Collection myCollection = new Collection(new com.sun.java.util.jar.pack.Package.File(getPath()));
        Command help = new HelpCommand(consoleCommands);
        Command info = new InfoCommand(consoleCommands);
        Command exit = new ExitCommand(consoleCommands);
        Command add = new AddCommand(consoleCommands);
        Command show = new ShowCommand(consoleCommands);
        Command remove = new RemoveCommand(consoleCommands);
        Command update = new UpdateCommand(consoleCommands);
        Command clear = new ClearCommand(consoleCommands);
        Command addIfMax = new AddIfMaxCommand(consoleCommands);
        Command removeGreater = new RemoveGreater(consoleCommands);
        Command removeLower = new RemoveLower(consoleCommands);
        Command countGreaterThanSalary = new Count(consoleCommands);

        Command save = new SaveCommand(consoleCommands);
        Command execute = new Script(consoleCommands);
        CommandManager mySwitch = new CommandManager();
        mySwitch.register("filter_contains_name", filter);
        mySwitch.register("save",save);
        mySwitch.register("execute_script",execute);
        mySwitch.register("count_greater_than_salary",countGreaterThanSalary);
        mySwitch.register("print_field_ascending_person",printfields);
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
        mySwitch.register("remove_lower", removeLower);
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