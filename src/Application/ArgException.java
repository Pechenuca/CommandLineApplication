package Application;

public class ArgException extends RuntimeException{
    public ArgException(){
        super("Вы ввели неккоректные аргументы для команды! Попробуйте снова");
    }
}
