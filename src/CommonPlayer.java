import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonPlayer implements WheelOfFortunePlayer {
    int index;

    public String playerId() {
        return "Common";
    }

    public void reset () {
        index = 0;
    }

    public char nextGuess() {
        List <Character> letters = new ArrayList <> (Arrays.asList('e', 'a', 'r', 'i', 'o', 't', 'n', 's', 'l', 'c',
                'u', 'd', 'p', 'm', 'h', 'g', 'b', 'f', 'y', 'w', 'k', 'v', 'x', 'z', 'j', 'q'));
        char guess = letters.get(index);
        index++;
        return guess;
    }
}
