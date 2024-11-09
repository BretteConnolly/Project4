public class GameRecord implements Comparable {
    public int score;
    public String playerId;

    public GameRecord (String anId, int aScore) {
        super();
    }

    public int compareTo(int score) {
        return score - this.score;
    }
}
