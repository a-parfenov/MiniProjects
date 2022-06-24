import static java.lang.System.exit;

public class ModelException extends java.lang.Exception {
    public static final String ONE_OPERATOR = "Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
    public static final String IS_NOT_A_MATH_OPERATION = "Некорректный ввод: Строка не является математической операцией";
    public static final String NEGATIVE_NUMBERS = "Ошибка: В римской системе нет отрицательных чисел";
    public static final String DIFFERENT_NUMBER_SYSTEM = "Некорректный ввод: Используются одновременно разные системы счисления";
    public static final String INCORRECT_INPUT = "Некорректный ввод: число должно быть целым и положительным, цифры должны быть в диапазоне от 1 до 10, операторы только +, -, /, *";
    public static final String ERROR_ARGUMENT = "Error argument";

    public ModelException(String exception) {
        System.out.println(exception);
        exit(1);
    }
}
