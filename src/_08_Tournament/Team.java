package _08_Tournament;

public class Team implements Comparable<Team> {
    public String teamName;
    private int wins;

    public Team(String name, int numWins) {
        teamName = name;
        wins = numWins;
    }

    public String getTeamName() {
        return teamName;
    }

    @Override
    public int compareTo(Team other) {
        if (this.wins < other.wins) {
            return -1;
        } else {
            if (this.wins == other.wins) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return teamName;
    }
}
