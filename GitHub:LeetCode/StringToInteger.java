import java.util.ArrayList;
import java.util.List;

public class StringToInteger {
    public int myAtoi(String s) {
        int INT_MIN = Integer.MIN_VALUE;
        int INT_MAX = Integer.MAX_VALUE;

        List<Character> charList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            charList.add(c);
        }

        List<Character> filteredList = new ArrayList<>();
        int sign = 1;
        boolean signSet = false;
        boolean numberStarted = false;

        for (Character c : charList) {
            if (!numberStarted && c == ' ') {
                continue;
            }

            if (!numberStarted && (c == '+' || c == '-')) {
                if (!signSet) {
                    sign = (c == '-') ? -1 : 1;
                    signSet = true;
                } else {
                    break;
                }
                numberStarted = true;
                continue;
            }

            if (Character.isDigit(c)) {
                filteredList.add(c);
                numberStarted = true;
            } else {
                break;
            }
        }

        int result = 0;
        for (Character c : filteredList) {
            int digit = c - '0';

            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }

            result = result * 10 + digit;
        }

        return result * sign;
    }      
    
}