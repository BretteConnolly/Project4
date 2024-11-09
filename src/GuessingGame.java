//import java.util.List;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Random;
//
//
//public abstract class GuessingGame extends Game {
//    public String phrase;
//    public int phrases;
//    public StringBuilder hiddenPhrase = new StringBuilder();
//    public String previousGuesses = "";
//    public List <String> phraseList;
//    public String playerId;
//    public GameRecord aGameRecord;
//
//    public abstract char getGuess(String previousGuesses);
//    public abstract StringBuilder generateHiddenPhrase();
//
//    public AllGamesRecord playAll() {
//        return super.playAll();
//    }
//
//    public List <String> phraseList (String fileName) {
//        try {
//            this.phraseList = Files.readAllLines(Paths.get(fileName));
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        return this.phraseList;
//    }
//
//
//}
