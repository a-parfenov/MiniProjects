import java.util.*;
class Interpreter
{
    static Scanner scanner = new Scanner(System.in);
    private static int ptr;

    //Max memory limit. It is the highest number which can be represented by an unsigned 16-bit binary number.
    //Many computer programming environments beside brainfuck may have predefined constant values representing 65535.
    private static final int length = 65535;
    private static final byte[] memory = new byte[length];

    static void interpret(String s)
    {
        int c = 0;

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '>') {
                if(ptr==length-1)
                    ptr=0;
                else
                    ptr++;
            }
            else if(s.charAt(i) == '<') {
                if(ptr == 0)
                    ptr = length - 1;
                else
                    ptr--;
            }
            else if(s.charAt(i) == '+')
                memory[ptr]++;
            else if(s.charAt(i) == '-')
                memory[ptr]--;
            else if(s.charAt(i) == '.')
                System.out.print((char)(memory[ptr]));
            else if(s.charAt(i) == ',')
                memory[ptr] = (byte)(scanner.next().charAt(0));
            else if(s.charAt(i) == '[') {
                if(memory[ptr] == 0) {
                    i++;
                    while(c > 0 || s.charAt(i) != ']') {
                        if(s.charAt(i)=='[')
                            c++;
                        else if(s.charAt(i)==']')
                            c--;
                        i++;
                    }
                }
            }
            else if(s.charAt(i) == ']') {
                if(memory[ptr] != 0) {
                    i--;
                    while(c > 0 || s.charAt(i) != '[') {
                        if(s.charAt(i) == ']')
                            c++;
                        else if(s.charAt(i) == '[')
                            c--;
                        i--;
                    }
                    i--;
                }
            }
        }
    }

}