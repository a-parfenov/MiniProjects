public class Main {
    public static void main(String[] args)
    {
        System.out.println("Enter the code: ");
        String code = Interpreter.scanner.nextLine();
        System.out.println("Output: ");
        Interpreter.interpret(code);
    }

}
