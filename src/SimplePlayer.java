import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimplePlayer implements WheelOfFortunePlayer {
    int index;

    public String playerId() {
        return "Simple";
    }

    public void reset () {
        index = 0;
    }

    public char nextGuess() {
        List<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        char guess = letters.get(index);
        index++;
        return guess;
    }
}





