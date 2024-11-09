import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public abstract class WheelOfFortune extends Game {
    public String phrase;
    public int phrases;
    public StringBuilder hiddenPhrase = new StringBuilder();
    public String previousGuesses = "";
    public List <String> phraseList;
    public GameRecord aGameRecord;
    public abstract char getGuess(String previousGuesses);

    @Override
    public void reset () {
        score = 0;
        phrases++;
        hiddenPhrase = new StringBuilder();
        previousGuesses = "";
    }

    public boolean playNext () {
        return phrases <= phraseList.size();
    }

    public StringBuilder generateHiddenPhrase() {
        for (int i = 0; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (!Character.isLetter(c)) {
                hiddenPhrase.append(c);
            } else {
                hiddenPhrase.append("*");
            }
        }
        return hiddenPhrase;
    }

    public boolean processGuess(char guess) {
        boolean match = false;
        if (phrase.indexOf(guess) != -1 || phrase.indexOf(guess + 32) != -1
                || phrase.indexOf(guess - 32) != -1) {
            match = true;
            for (int j = 0; j < phrase.length(); j++) {
                if (Character.toLowerCase(phrase.charAt(j)) == Character.toLowerCase(guess)) {
                    hiddenPhrase.setCharAt(j, phrase.charAt(j));
                }
            }
        }
        return match;
    }

    public AllGamesRecord playAll() {
        return super.playAll();
    }

    public List <String> phraseList (String fileName) {
        try {
            phraseList = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            System.out.println(e);
        }
        return phraseList;
    }


    public GameRecord play(String playerId) {
        System.out.print(
                """
                         
                         Welcome to Wheel of Fortune!
                         Solve the hidden phrase by guessing letters one by one.
                         Guesses of numbers or special characters will not count.
                         Delineations between words will be provided for you.
                         Letter guesses are not case-sensitive.
                         Have fun!

                        """);
        System.out.println("Keep guessing until you solve. The fewer guesses, the better your score.");
        System.out.println("Phrase: ");
        if (phrases == 3) {
            phrases = 0;
        }
        phrase = phraseList.get(phrases);
        StringBuilder hiddenPhrase = generateHiddenPhrase();
        System.out.println(hiddenPhrase);
        int i = 0;
        while (i < 26) {
            char guess = getGuess(previousGuesses);
            System.out.println("Guess: " + guess);
            if (!Character.isLetter(guess)) {
                System.out.println("Guess a letter. ");
            } else {
                if (previousGuesses.indexOf(Character.toLowerCase(guess)) != -1) {
                    System.out.println("You have already guessed this.");
                } else {
                    boolean match = processGuess(guess);
                    if (match) {
                        System.out.println("Correct!");
                        hiddenPhrase.setCharAt(phrase.indexOf(guess), guess);
                    } else {
                        System.out.print("Incorrect.");
                        score++;
                    }
                    previousGuesses += Character.toLowerCase(guess);
                }
            }
            System.out.println(hiddenPhrase);
            if (hiddenPhrase.indexOf("*") == -1) {
                System.out.println("You did it!");
                aGameRecord = new GameRecord(playerId, score);
                reset();
                return aGameRecord;
            }
            System.out.print("Guesses: ");
            System.out.println(previousGuesses);
            i++;
        }
        aGameRecord = new GameRecord(playerId, score);
        System.out.println("New Game Record: " + aGameRecord.playerId + ", " + aGameRecord.score);
        reset();
        return aGameRecord;
     }
}

