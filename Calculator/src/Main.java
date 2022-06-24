import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static boolean arabicNumeral;

    public static void main(String[] args) throws ModelException {
        System.out.println(calc(init().nextLine()));

//        System.out.println(calc("1 - 2"));
//        System.out.println(calc("7 * 7"));
//        System.out.println(calc("V * V"));
//        System.out.println(calc("VI / III"));
//        System.out.println(calc("3 + II"));
//        System.out.println(calc("1"));
//        System.out.println(calc("1 + 2 + 3"));
//        System.out.println(calc("7 + 11"));
//        System.out.println(calc("10 % 3"));
    }

    public static String calc(String input) throws ModelException {
        String[] arrInput = input.split(" ");
        ArrayList<Argument> listOperations = new ArrayList<>();

        for (String s: arrInput) {
            listOperations.add(checkArgument(s));
        }

        if (listOperations.size() > 3)
            throw new ModelException(ModelException.ONE_OPERATOR);
        else if (listOperations.size() < 3)
            throw new ModelException(ModelException.IS_NOT_A_MATH_OPERATION);

        return calculate(listOperations);
    }

    private static String calculate(ArrayList<Argument> listOperations) throws ModelException {
        if (listOperations.get(0) instanceof Number
                && listOperations.get(2) instanceof Number) {

            if (((Number) listOperations.get(0)).isArabicNumeral()
                    && ((Number) listOperations.get(2)).isArabicNumeral()) {
                return Integer.toString(calculateNumber(
                        ((Number) listOperations.get(0)).getIntNumber(),
                        ((Number) listOperations.get(2)).getIntNumber(),
                        listOperations));

            } else if (!(((Number) listOperations.get(0)).isArabicNumeral())
                    && !(((Number) listOperations.get(2)).isArabicNumeral())) {

                int result = calculateNumber(
                        ((Number) listOperations.get(0)).getIntNumber(),
                        ((Number) listOperations.get(2)).getIntNumber(),
                        listOperations);

                if (result < 1)
                    throw new ModelException(ModelException.NEGATIVE_NUMBERS);
                return Number.arabicInRoman(result);

            } else throw new ModelException(ModelException.DIFFERENT_NUMBER_SYSTEM);
        } else throw new ModelException(ModelException.ERROR_ARGUMENT);
    }



    private static int calculateNumber(int num1, int num2, ArrayList<Argument> listOperations) throws ModelException {
        if ((num1 < 1 || num1 > 10) || (num2 < 1 || num2 > 10))
            throw new ModelException(ModelException.INCORRECT_INPUT);
        switch (listOperations.get(1).getArgument()) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return -1;
    }

     private static Argument checkArgument(String arg) throws ModelException {
            if (arg.equals("+")) {
                return new Operation("+");
            } else if (arg.equals("-")) {
                return new Operation("-");
            } else if (arg.equals("*")) {
                return new Operation("*");
            } else if (arg.equals("/")) {
                return new Operation("/");
            } else if (checkRomanOrArabicNumber(arg)) {
                return new Number(arg, arabicNumeral);
            }
        return null;
    }

    private static boolean checkRomanOrArabicNumber(String num) throws ModelException {
        char[] arr = num.toCharArray();
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};

        arabicNumeral = true;
        for (char c : arr) {
            if (!Character.isDigit(c)) {
                arabicNumeral = false;
                break;
            }
        }

        if (!arabicNumeral) {
            for (char a : arr) {
                boolean found = String.valueOf(roman).contains(String.valueOf(a));
                if (!found)
                    throw new ModelException(ModelException.INCORRECT_INPUT);
            }
        }
        return true;
    }

    private static Scanner init() {
        System.out.println("Калькулятор");
        System.out.println("Формат: два операнда и один оператор. Например: '2 + 7' или 'MX - VI' (без кавычек)");
        System.out.println("Доступны операторы: +, -, /, *, а также римские цифры: I, V, X, L, C, D, M");
        System.out.println("Арабские цифры доступны от 1 до 10");
        System.out.print("\nВведите выражение для подсчета: ");
        return new Scanner(System.in);
    }
}
