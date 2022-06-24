import java.util.*;

public class Number implements Argument {
    private final int arabicNumber;
    private final String stringArabicNumber;
    private final boolean isArabicNumeral;
    public static final LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

    static {
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
    }

    public Number(String stringNumber, boolean arabicNumeral) {
        this.stringArabicNumber = stringNumber;
        this.isArabicNumeral = arabicNumeral;
        if (arabicNumeral) {
            this.arabicNumber = Integer.parseInt(stringNumber);
        } else {
            arabicNumber = romanInArabic(stringNumber);
        }
    }

    public static String arabicInRoman(int number) {
        StringBuilder buffer = new StringBuilder();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            int quantity = number / value;
            number -= quantity * value;
            buffer.append(key.repeat(quantity));
        }

        return buffer.toString();
    }

    public static int romanInArabic(String stringNumber) {
        char[] numberRoman = stringNumber.toCharArray();

        int resultNumber = 0;
        for (char item : numberRoman) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().equals(item + "")) {
                    resultNumber += entry.getValue();
                }
            }
        }
        return resultNumber;
    }

    @Override
    public String getArgument() {
        if (isArabicNumeral) {
            return stringArabicNumber;
        } else
            return Integer.toString(arabicNumber);
    }

    public int getIntNumber() {
        return this.arabicNumber;
    }

    public boolean isArabicNumeral() {
        return this.isArabicNumeral;
    }
}
