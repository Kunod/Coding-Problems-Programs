import java.util.*;
import static java.lang.System.*;

public class WordScramble {
    public static void main(String[] args) {
        Scanner console = new Scanner(in);
        out.println("Type a word, sentence or entire paragraph followed by enter:");
        String input = console.nextLine();
        out.println();
        out.println("Here is a scrambled version:");
        out.println(scramble(input));
        console.close();
    }

    public static String scramble(String line) {
        String ret = "";
        String[] words = line.split(" ");
        for (String word : words) {
            ret += scrambleWord(word) + " ";
        }
        return ret.trim();
    }

    public static String scrambleWord(String w) {
        if (w.length() <= 1) {
            return w;
        }

        Random randomGen = new Random();
        char[] letters = w.toCharArray();
        int last = letters.length;

        for (int i = 1; i < last - 1; i++) {
            int r = randomGen.nextInt(last - 2) + 1;
            char temp = letters[i];
            letters[i] = letters[r];
            letters[r] = temp;
        }

        return new String(letters);
    }
}
