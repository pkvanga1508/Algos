package arrays;

// [HomeTeam, AwayTeam]
// competitions - [
//    ["TeamA", "TeamB"],
//    ["TeamB", "TeamC"],
//    ["TeamC", "TeamA"]
//]
//results = [0,0,1] ->
// 1 -> Home Team won
// 2 -> Away Team won

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TournamentWinner {

    public String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        int currentMaxPoints = 0;
        String tournamentWinner = "";
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            List<String> competingTeams = competitions.get(i);
            int winningSide = results.get(i);
            String winningTeam = winningSide == 0 ? competingTeams.get(1) : competingTeams.get(0);
            int points = map.getOrDefault(winningTeam, 0);
            map.put(winningTeam, points + 1);
            if (points >= currentMaxPoints) {
                currentMaxPoints = points + 1;
                tournamentWinner = winningTeam;
            }
        }
        return tournamentWinner;
    }
}
