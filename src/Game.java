public abstract class Game {
    public int score;
    public String playerId;
    public GameRecord aGameRecord = new GameRecord(playerId, score);
    public AllGamesRecord allGamesRecord = new AllGamesRecord();

    public abstract GameRecord play();
    public abstract boolean playNext();

    public void reset () {
        score = 0;
    }

    public AllGamesRecord playAll() {
        while (playNext()) {
            aGameRecord = play();
            allGamesRecord.add(aGameRecord);
            reset();
            playNext();
        }
        allGamesRecord.stats();
        return allGamesRecord;
    }
}
