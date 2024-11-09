import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class MysteryPlayer implements WheelOfFortunePlayer {
    int index;
    String previousGuesses = "";

    public String playerId() {
        return "Mystery";
    }

    public void reset () {
        index = 0;
        previousGuesses = "";
    }

    public char nextGuess() {
        List<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        Collections.shuffle(letters);
        char guess = letters.get(index);
        while (previousGuesses.indexOf(guess) != -1) {
            index++;
            if (index < 25) {
                guess = letters.get(index);
            } else {
                break;
            }
        }
        if (index == 26) {
            index = 25;
        }
        previousGuesses += guess;
        System.out.println("Prior guesses: " + previousGuesses);
        return guess;
    }
}
