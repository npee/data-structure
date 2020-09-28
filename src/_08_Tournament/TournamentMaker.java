package _08_Tournament;

import structures.ArrayOrderedList;

import java.io.IOException;
import java.util.Scanner;

public class TournamentMaker {

    public void make() throws IOException {
        ArrayOrderedList<Team> tournament = new ArrayOrderedList<>();
        String team1, team2, teamName;
        int numWins, numTeams = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Tournament Maker");

        while (numTeams % 2 != 0 || numTeams == 0) {
            System.out.println("Enter the number of teams(must be even): ");
            numTeams = in.nextInt();
            in.nextLine();
        }

        System.out.println("Enter " + numTeams + " team names and number of wins: ");
        System.out.println("Teams may be entered int any order ");

        for (int count = 1; count <= numTeams; count++) {
            System.out.println("Enter team name: ");
            teamName = in.nextLine();
            System.out.println("Enter number of wins: ");
            numWins = in.nextInt();
            in.nextLine();
            tournament.add(new Team(teamName, numWins));
        }

        System.out.println("The first round match-ups are: ");

        for (int count = 1; count <= numTeams / 2; count++) {
            team1 = (tournament.removeFirst()).getTeamName();
            team2 = (tournament.removeLast()).getTeamName();

            System.out.println("Game " + count + " is " + team1 + " against " + team2);
            System.out.println("with the winner to play the winner of game " + (numTeams / 2 + 1 - count));
        }
    }
}
