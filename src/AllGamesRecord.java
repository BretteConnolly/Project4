import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;

public class AllGamesRecord {
    public HashMap <String, Integer> gamesRecord = new HashMap <> ();

    public void add(GameRecord gameRecord) {
        gamesRecord.put(gameRecord.playerId, gameRecord.score);
    }

    public int average() {
        int sum = 0;
        for (Integer value: gamesRecord.values()) {
            sum += value;
        }
        return sum / gamesRecord.size();
    }

    public int average(String playerId) {
        int sum = 0;
        int count = 0;
        for (String key: gamesRecord.keySet()) {
            if (key.equals(playerId)) {
                sum += gamesRecord.get(key);
                count++;
            }
        }
        return sum / count;
    }

    public ArrayList highGameList() {
        ArrayList<Integer> sortedScores = new ArrayList <> ();
        for (Integer value : gamesRecord.values()) {
            sortedScores.add(value);
        }
        sortedScores.sort(Comparator.reverseOrder());
        return sortedScores;
    }

    public ArrayList highGameList(String playerId) {
        ArrayList <Integer> sortedScores = new ArrayList <> ();
        for (String key: gamesRecord.keySet()) {
            if (key.equals(playerId)) {
                sortedScores.add(gamesRecord.get(key));
                System.out.println("Sorted scores: " + sortedScores);
            }
        }
        Collections.sort(sortedScores);
        return sortedScores;
    }

    public void stats() {
        System.out.println("Games Record size: " + gamesRecord.size());
        System.out.println("Average: " + average());
        for (String key: gamesRecord.keySet()) {
            System.out.println("Average for " + key + ": " + average(key));
        }
        System.out.println("High Game List:" + highGameList());
        for (String key: gamesRecord.keySet()) {
            System.out.println("High Game List for " + key + ": " + highGameList(key));
        }
    }
    }
