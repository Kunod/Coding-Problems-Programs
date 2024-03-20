import java.util.*;
import static java.lang.System.*;
public class daysUntilBirth {

    public static int daysUntilBirthday(int currentMonth, int currentDay, int birthMonth, int birthDay) {
        int daysUntil = 30 - currentDay;
        int birthMinus = birthDay - 1;
        for (int i = currentMonth+1; i != birthMonth; i++) {
            daysUntil += 31;
            if (i == 12) {
                i = 0;
            }
        }
        return (daysUntil + birthMinus)-2;
    }
}
