import java.util.ArrayList;
import java.util.Collections;

public class WheelOfFortuneAIGame extends WheelOfFortune{
    public WheelOfFortunePlayer player;
    public ArrayList <WheelOfFortunePlayer> players;

    public WheelOfFortuneAIGame () {
        super.phraseList = super.phraseList("phrases.txt");
    }

    public WheelOfFortuneAIGame (WheelOfFortunePlayer player) {
        this.player = player;
        super.phraseList = super.phraseList("phrases.txt");
    }

    public WheelOfFortuneAIGame (ArrayList <WheelOfFortunePlayer> players) {
        this.players = players;
        super.phraseList = super.phraseList("phrases.txt");
    }

    @Override
    public char getGuess (String previousGuesses) {
        return player.nextGuess();
    }

    @Override
    public GameRecord play() {
        return super.play();
    }

    @Override
    public AllGamesRecord playAll() {
        for (WheelOfFortunePlayer player : players) {
            this.player = player;
            System.out.println("Player: " + this.player.playerId());
            //while (playNext()) {
            int i = 0;
            while (i < phraseList.size()) {
                aGameRecord = play();
                allGamesRecord.add(aGameRecord);
                this.player.reset();
                i++;
            }
        }
        return allGamesRecord;
    }

    public static void main (String [] args) {
        WheelOfFortunePlayer simplePlayer = new SimplePlayer();
        WheelOfFortunePlayer commonPlayer = new CommonPlayer();
        WheelOfFortunePlayer mysteryPlayer = new MysteryPlayer();
        ArrayList <WheelOfFortunePlayer> players = new ArrayList <> ();
        Collections.addAll(players, simplePlayer, commonPlayer, mysteryPlayer);
        WheelOfFortuneAIGame wofAIGame = new WheelOfFortuneAIGame(players);
        AllGamesRecord record = wofAIGame.playAll();
        record.stats();
    }
}
