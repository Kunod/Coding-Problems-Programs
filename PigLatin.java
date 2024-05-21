import java.util.*;

public class PigLatin {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Type a sentence (or \"quit\"): ");
        String sentence = console.nextLine();

        while (!sentence.equalsIgnoreCase("quit")) {
            String pigLatinSentence = convertToPigLatin(sentence);
            System.out.println("Pig Latin: " + pigLatinSentence);

            System.out.print("Type another sentence (or \"quit\") >>> ");
            sentence = console.nextLine();
        }

        System.out.println("Bye!");
        console.close();
    }

    public static String convertToPigLatin(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder pigLatinSentence = new StringBuilder();

        for (String word : words) {
            pigLatinSentence.append(convertWordToPigLatin(word)).append(" ");
        }

        return pigLatinSentence.toString().trim();
    }

    public static String convertWordToPigLatin(String word) {
        String vowels = "AEIOUaeiou";
        int firstVowelIndex = -1;

        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                firstVowelIndex = i;
                break;
            }
        }

        if (firstVowelIndex == -1) {
            return word;
        } else if (firstVowelIndex == 0) {
            return word + "yay";
        } else {
            return word.substring(firstVowelIndex) + word.substring(0, firstVowelIndex) + "ay";
        }
    }
}
