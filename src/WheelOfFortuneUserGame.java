import java.util.Scanner;

public class WheelOfFortuneUserGame extends WheelOfFortune {
    public String playerId = "User";

    public WheelOfFortuneUserGame() {
        super.phraseList = super.phraseList("phrases.txt");
    }

    @Override
    public char getGuess (String previousGuesses) {
        System.out.println("Enter a guess: ");
        Scanner input = new Scanner(System.in);
        char guess = input.next().charAt(0);
        while (previousGuesses.indexOf(guess) != -1) {
            System.out.println("You have already guessed this. Guess again. ");
            input = new Scanner(System.in);
            guess = input.next().charAt(0);
        }
        previousGuesses += guess;
        return guess;
    }

    public boolean canPlay () {
        return super.phrases <= phraseList.size();
    }

    @Override
    public boolean playNext() {
        if (canPlay()) {
            System.out.println("Play again? Y/N");
            Scanner scan = new Scanner(System.in);
            if (scan.equals("Y")) {
                super.phrases++;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public GameRecord play() {
        return super.play("User");
    }

    public AllGamesRecord playAll() {
        return super.playAll();
    }

    public static void main (String [] args) {
        WheelOfFortuneUserGame wofUserGame = new WheelOfFortuneUserGame();
        AllGamesRecord record = wofUserGame.playAll();
        System.out.println(record);
    }
}

