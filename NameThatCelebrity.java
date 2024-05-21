import java.util.*;

public class NameThatCelebrity {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random random = new Random();

        Map<String, String> celebrities = new HashMap<>();
        celebrities.put("Dwayne Johnson", "Hint: Known for movies like 'Jumanji' and 'Fast & Furious'.");
        celebrities.put("Tom Cruise", "Hint: Known for movies like 'Mission: Impossible' and 'Top Gun'.");
        celebrities.put("Scarlett Johansson", "Hint: Known for movies like 'Avengers' and 'Lost in Translation'.");
        celebrities.put("Leonardo DiCaprio", "Hint: Known for movies like 'Titanic' and 'Inception'.");
        celebrities.put("Jennifer Lawrence", "Hint: Known for movies like 'The Hunger Games' and 'Silver Linings Playbook'.");
        celebrities.put("Chris Hemsworth", "Hint: Known for movies like 'Thor' and 'The Avengers'.");
        celebrities.put("Emma Watson", "Hint: Known for movies like 'Harry Potter' and 'Beauty and the Beast'.");
        celebrities.put("Robert Downey Jr.", "Hint: Known for movies like 'Iron Man' and 'Sherlock Holmes'.");
        celebrities.put("Angelina Jolie", "Hint: Known for movies like 'Maleficent' and 'Mr. & Mrs. Smith'.");
        celebrities.put("Brad Pitt", "Hint: Known for movies like 'Fight Club' and 'Ocean's Eleven'.");

        List<String> celebList = new ArrayList<>(celebrities.keySet());
        String celeb = celebList.get(random.nextInt(celebList.size()));
        String[] celebNameParts = celeb.split(" ");
        String celebFirst = celebNameParts[0];
        String celebSecond = celebNameParts[1];

        String easy = "easy";
        String medium = "medium";
        String hard = "hard";

        System.out.print("Choose a difficulty level (easy, medium, or hard) >>> ");
        String difficulty = console.nextLine().toLowerCase();
        System.out.println();

        String clue = "";
        if (difficulty.equals(easy)) {
            clue = celebFirst.substring(1) + " " + celebSecond.substring(1);
        } else if (difficulty.equals(medium)) {
            clue = celebFirst.substring(2) + " " + celebSecond.substring(2);
        } else if (difficulty.equals(hard)) {
            clue = celebFirst.substring(3) + " " + celebSecond.substring(3);
        } else {
            System.out.println("Invalid difficulty level. Please restart the game and choose either easy, medium, or hard.");
            return;
        }

        boolean correctGuess = false;
        for (int attempt = 0; attempt < 4; attempt++) {
            if (attempt == 3) {
                System.out.println(celebrities.get(celeb)); 
            }
            System.out.println("Here's your clue: " + clue);
            System.out.print("What's your guess? >>> ");
            String guess = console.nextLine();

            if (guess.equalsIgnoreCase(celeb)) {
                System.out.println("Correct!! Nice job.");
                correctGuess = true;
                break;
            } else {
                System.out.println("Incorrect, sorry!\n");
            }
        }

        if (!correctGuess) {
            System.out.println("You lose! The answer was " + celeb);
        }
    }
}
