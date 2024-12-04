package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Card.TypeCard;
import model.Goal.GoalRecord;
import model.Player.PositionPlayer;
import model.Referee.typeReferee;

/**
* ControllerTournament handles the main functionality for managing teams,
* players, and referees within a tournament.
*/
public class ControllerTournament {
    List<Referee> referees = new ArrayList<>();
    List<Player> players = new ArrayList<>();
    final int LIMIT_TEAMS = 8;
    Team [] teamsTournament = new Team[LIMIT_TEAMS];
    final int TEAMS_GROUP = 4;
    Group groupA;
    Group groupB;
    final int MATCHES_AVAIBLE = 12;
    Match[] matches = new Match[MATCHES_AVAIBLE];
    List <Goal> playersAndAssitsTournament = new ArrayList<>();
    List <Card> badPlayers = new ArrayList<>();
    int i = 0;
    

    /**
    * Registers a new team in the tournament.
    * 
    * @param nameTeam Name of the team.
    * @param countryTeam Country of the team.
    * @param directorTeam Name of the head coach of the team.
    * @param i Position in the tournament's teams teamsTournament where the team will be registered.
    */
    public Team[] registerTeam(String nameTeam, String countryTeam, String directorTeam, int i){
        teamsTournament[i] = new Team(nameTeam, countryTeam, directorTeam);
        return teamsTournament;
    }

    public Team[] getTeamsTournament() {
        return teamsTournament;
    }

    /**
    * Registers a new player for a team based on the specified position.
    * 
    * @param numberDorsal The player's jersey number.
    * @param namePlayer The player's name.
    * @param countryPlayer The player's country.
    * @param option Indicates the position type: [1] Goalkeeper, [2] Defender, [3] Midfielder, [4] Forward.
    * @param players List of players where the newly registered player will be added.
    * 
    * @return Updated list of players with the newly added player.
    */
    public List<Player> registerPlayer(String countryPlayer, String namePlayer, String numberDorsal,
    int option) {

        Player player;
        switch (option) {
            case 1:
                player = new Player(namePlayer, countryPlayer, numberDorsal, PositionPlayer.Arquero);
                players.add(player);
                break;

            case 2:
                player = new Player(namePlayer, countryPlayer, numberDorsal, PositionPlayer.Defensa);
                players.add(player);
                break;

            case 3:
                player = new Player(namePlayer, countryPlayer, numberDorsal, PositionPlayer.Volante);
                players.add(player);
                break;

            case 4:
                player = new Player(namePlayer, countryPlayer, numberDorsal, PositionPlayer.Delantero);
                players.add(player);
                break;
        }

        return players;
    }

    /**
    * Registers a new referee in the tournament.
    * 
    * @param idReferee Referee's ID.
    * @param nameReferee Referee's name.
    * @param countryReferee Referee's country.
    * @param option Indicates the type of referee: [1] Central, [2] Assistant.
    * 
    * @return Updated list of referees with the newly added referee.
    */
    public List<Referee> registerReferee(String idReferee, String nameReferee, String countryReferee, int option){
        Referee referee;
        switch (option) {

            case 1:
                referee = new Referee(nameReferee, countryReferee, idReferee, typeReferee.Central);
                referees.add(referee);
                break;
            
            case 2:
                referee = new Referee(nameReferee, countryReferee, idReferee, typeReferee.Asistente);
                referees.add(referee);
                break;
        }

        return referees;
    }

    /**
    * Generates a detailed summary of tournament teams and their players.
    *
    * @return a formatted String summarizing the tournament's teams and players.
    * - Returns a message indicating "no teams registered" if `teamsTournament` is null.
    * - Includes details about each team and its players, or a message if no players are available.
    */
    public String showTeams() {
        int i = 1;

        String message = "";
        if (teamsTournament == null) {
            message += "Hasta el momento no se ha añadido ningún equipo";
        } else {
            message += "Estos son los equipos que forman parte del torneo:" + "\n";
            for (Team team : teamsTournament) {
                if (team != null) {
                    message += "#" + (i++) + " Equipo: " + team.getNameTeam() + "\n" +
                    "------------------------ \n";
                }
            }
        }
        return message;
    }

        public String showPlayers() {
            int i = 1;

            String message = "";
            if (teamsTournament == null) {
                message += "Hasta el momento no se ha añadido ningún equipo";
            } else {
                message += "Estos son los equipos que forman parte del torneo:" + "\n";
                for (Team team : teamsTournament) {
                    if (team != null) {
                        message += "#" + (i++) + " Equipo: " + team.getNameTeam() + "\n" +
                        "------------------------ \n";
                        int j = 1;
                        players = team.getPlayers();
                        if (team.getPlayers() != null && !team.getPlayers().isEmpty()) {
                            message += "Lista de jugadores:" + "\n";
                        for (Player player : players) {
                            message += "#" + (j++) +" Nombre: " + player.getName() + "\n" + 
                            "Dorsal: "  + player.getNumberDorsal() + "\n" +
                            "Posición:" + player.getPositionPlayer() + "\n" +
                            "-------------------- \n";
                        }
                        } else {
                        message += "No hay jugadores registrados para este equipo. \n ------------------------------------------- \n";
                        }
                    }
                }
            } 
        return message;
    }

    /**
    * Generates a summary of all referees registered for the tournament.
    *
    * @return a formatted String summarizing the referees in the tournament. 
    * - Returns a message indicating "no referees registered" if the list is empty.
    * - Includes the name, ID, country, and type of each referee if available.
    */
    public String showReferees() {
        String message = "";

        if (referees.isEmpty()) {
            message += "Hasta el momento no se a añadido, ningun árbitro al torneo";
        } else {
            message += "La lista de arbitros que conformaran este torneo, es la siguiente:" + "\n";
            int i = 1;
            for (Referee referee : referees) {
                message += "#" + i++ + " Nombre: " + referee.getName() +
                ", ID: " + referee.getIdReferee() +
                ", País: " + referee.getCountry() +
                ", Tipo: " + referee.getTypeReferee() + "\n --------------------------------------------------------------- \n";
            }
        }

        return message;
    }

    /**
    * Generates the fixture for the tournament by shuffling teams and creating matches.
    * 
    * @param teamsTournament Array of Team objects representing the tournament teams.
    *
    * @return Array of Match objects representing the scheduled matches.
    */
    public Match[] generateFixture() {
        Random random = new Random();

        Team [] firstGroup = new Team[TEAMS_GROUP];
        Team [] secondGroup = new Team[TEAMS_GROUP];

        // Shuffle the teams
        for (int i = teamsTournament.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);

            Team temp = teamsTournament[index];
            teamsTournament[index] = teamsTournament[i];
            teamsTournament[i] = temp;
        }

        // Divide teams into two groups
        for (int i = 0; i < TEAMS_GROUP; i++) {
            firstGroup[i] = teamsTournament[i];
            secondGroup[i] = teamsTournament[i + 4];
        }

        groupA = new Group(firstGroup);
        groupB = new Group(secondGroup);

        // Schedule matches within groups
        Match[] groupAMatches = new Match[6];
        int index = 0;
        for (int i = 0; i < firstGroup.length; i++) {
            for (int j = i + 1; j < firstGroup.length; j++) {
                groupAMatches[index] = new Match(firstGroup[i], firstGroup[j], null);
                index++;
            }
        }

        Match[] groupBMatches = new Match[6];
        index = 0;
        for (int i = 0; i < secondGroup.length; i++) {
            for (int j = i + 1; j < secondGroup.length; j++) {
                groupBMatches[index] = new Match(secondGroup[i], secondGroup[j], null);
                index++;
            }
        }

        // Assign dates to matches
        int matchIndex = 0;
        LocalDate currentDate = LocalDate.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        for (int i = 0; i < 4; i++) {
            matches[matchIndex] = groupAMatches[i];
            groupAMatches[i].setDateMatch(currentDate.format(formatter));
            matchIndex++;
            currentDate = currentDate.plusDays(2);

            matches[matchIndex] = groupBMatches[i];
            groupBMatches[i].setDateMatch(currentDate.format(formatter));
            matchIndex++;
            currentDate = currentDate.plusDays(2);
        }

        // Set simultaneous dates for last matches in each group
        matches[matchIndex] = groupAMatches[4];
        groupAMatches[4].setDateMatch(currentDate.format(formatter));
        matchIndex++;

        matches[matchIndex] = groupAMatches[5];
        groupAMatches[5].setDateMatch(currentDate.format(formatter));
        matchIndex++;

        matches[matchIndex] = groupBMatches[4];
        groupBMatches[4].setDateMatch(currentDate.format(formatter));
        matchIndex++;

        matches[matchIndex] = groupBMatches[5];
        groupBMatches[5].setDateMatch(currentDate.format(formatter));
        matchIndex++;

        return matches;
    } 

    /**
    * Generates a summary of all scheduled matches in the tournament.
    *
    * @param matches an array of Match objects representing the scheduled matches. 
    * Must not be null but may contain null elements.
    *
    * @return a formatted String listing all the matches with their details. 
    * - Each match includes the teams playing, and the match date.
    * - Returns an empty String if the array contains no non-null matches.
    */
    public String showMatches() {
        String message = "";
        int i = 1;
        List<Referee> refereesMatch;
        for (Match match : matches) {
            
            if (match != null) {
                message += "Partido #" + i++ + ": " + match.getTeamA().getNameTeam() + " vs " + match.getTeamB().getNameTeam() +
                ", Fecha: " + match.getDateMatch();

                refereesMatch = match.getReferees();
                if (refereesMatch != null) {
                    message += "\nÁrbitros del partido: \n" + refereesMatch.get(0).name + " " + refereesMatch.get(0).getTypeReferee() +
                    "\n"  + refereesMatch.get(1).name + " " + refereesMatch.get(1).getTypeReferee() +
                    "\n"  + refereesMatch.get(2).name + " " + refereesMatch.get(2).getTypeReferee() +
                    "\n---------------------------------------------------------------\n";
                } else {
                    message += "\nAún no se han asignado árbitros para este partido \n-------------------------------------------------\n";
                }
            } 
        }

        return message;
    }

    /**
    * Retrieves a list of available central referees who can officiate a match between two teams.
    *
    * @param validationTeam1 the first team in the match. Must not be null.
    * @param validationTeam2 the second team in the match. Must not be null.
    *
    * @return a list of Referee objects representing the available central referees.
    * - The referees returned are of type "Central" and do not share the same nationality as either team.
    * - Returns an empty list if no central referees meet the criteria.
    */
    public List<Referee> avaibleCentralReferees(Team validationTeam1, Team validationTeam2) {
        
        List<Referee> centralReferees = new ArrayList<>();
            
        for (Referee referee : referees) {
            if (validationTeam1.getCountryTeam() != referee.getCountry() && 
                validationTeam2.getCountryTeam() != referee.getCountry() && 
                referee.getTypeReferee() == typeReferee.Central) {

                centralReferees.add(referee);
            }
        }  
        return centralReferees;
    }

    /**
    * Retrieves a list of available assistant referees who can officiate a match between two teams.
    *
    * @param validationTeam1 the first team in the match. Must not be null and should have a valid country.
    * @param validationTeam2 the second team in the match. Must not be null and should have a valid country.
    *
    * @return a list of Referee objects representing the available assistant referees.
    * - The referees returned are of type "Assistant" and do not share the same nationality as either team.
    * - Returns an empty list if no assistant referees meet the criteria.
    */
    public List<Referee> avaibleAssistantReferees(Team validationTeam1, Team validationTeam2) {
        
        List<Referee> assistantReferees = new ArrayList<>();
            
        for (Referee referee : referees) {
            if (validationTeam1.getCountryTeam() != referee.getCountry() && 
                validationTeam2.getCountryTeam() != referee.getCountry() && 
                referee.getTypeReferee() == typeReferee.Asistente) {

                assistantReferees.add(referee);
            }
        }  
        return assistantReferees;
    }

    /**
    * Updates the result of a specific match in the tournament.
    *
    * @param result a String representing the new result of the match. 
    *               Must not be null or empty.
    * @param option an integer representing the match index to be updated. 
    * Must be a valid index within the matches array.
    *
    * @return a confirmation message indicating the match result has been updated.
    */
    public String modifyScorerMatch(int option, int resultFirstTeam, int resultSecondTeam) {
        matches[option - 1].getTeamA().setMatchesPlayed(matches[option - 1].getTeamA().getMatchesPlayed() + 1);
        matches[option - 1].getTeamB().setMatchesPlayed(matches[option - 1].getTeamB().getMatchesPlayed() + 1);

        matches[option - 1].setResultFirstTeam(resultFirstTeam);
        matches[option - 1].setResultSecondTeam(resultSecondTeam);

        matches[option - 1].getTeamA().setGoalsFavor(matches[option - 1].getTeamA().getGoalsFavor() + resultFirstTeam);
        matches[option - 1].getTeamA().setGoalsAgaint(matches[option - 1].getTeamA().getGoalsAgaint() +resultSecondTeam);

        matches[option - 1].getTeamB().setGoalsFavor(matches[option - 1].getTeamB().getGoalsFavor() + resultSecondTeam);
        matches[option - 1].getTeamB().setGoalsAgaint(matches[option - 1].getTeamB().getGoalsAgaint() + resultFirstTeam);

        if (resultFirstTeam > resultSecondTeam) {
            matches[option - 1].getTeamA().setMatchesWon(matches[option - 1].getTeamA().getMatchesWon() + 1);
            matches[option - 1].getTeamA().setPoints(matches[option - 1].getTeamA().getPoints() + 3);
            matches[option - 1].getTeamB().setMatchesLost(matches[option - 1].getTeamB().getMatchesLost() + 1);

        } else if (resultSecondTeam > resultFirstTeam) {
            matches[option - 1].getTeamB().setMatchesWon(matches[option - 1].getTeamB().getMatchesWon() + 1);
            matches[option - 1].getTeamB().setPoints(matches[option - 1].getTeamB().getPoints() + 3);
            matches[option - 1].getTeamA().setMatchesLost(matches[option - 1].getTeamA().getMatchesLost() + 1);
        } else if (resultFirstTeam == resultSecondTeam) {
            matches[option - 1].getTeamA().setMatchesTied(matches[option - 1].getTeamA().getMatchesTied() + 1);
            matches[option - 1].getTeamA().setPoints(matches[option - 1].getTeamA().getPoints() + 1);
            matches[option - 1].getTeamB().setMatchesTied(matches[option - 1].getTeamB().getMatchesTied() + 1);
            matches[option - 1].getTeamB().setPoints(matches[option - 1].getTeamB().getPoints() + 1);
        }
        matches[option - 1].getTeamA().setRatioWins((matches[option - 1].getTeamA().getMatchesWon()/matches[option - 1].getTeamA().getMatchesPlayed()));
        matches[option - 1].getTeamB().setRatioWins((matches[option - 1].getTeamB().getMatchesWon()/matches[option - 1].getTeamB().getMatchesPlayed()));
        return "Marcador actualizado";
    }

    //Eighth request

    /** 
     * Add a scorer or assists player.
     * 
     * @param player Player who score/assist
     * @param quantity Quantity of score/assist
     * @param typePlayer Define the type of goal, if is a scorer or a assit
     * 
     * @return a List of Object Goal, that saved the scorers and assists of soccer tournament
     * 
     */
    public List <Goal> addScorerAndAssits(Player player, int quantity, GoalRecord typePlayer) {

        boolean foundScorer = false;
        boolean foundAssists = false;

        for (int i = 0; i < playersAndAssitsTournament.size(); i++) {
            if (player.getName().equals(playersAndAssitsTournament.get(i).getPlayer().getName())  && 
            player.getNumberDorsal() == playersAndAssitsTournament.get(i).getPlayer().getNumberDorsal() &&
            typePlayer.equals(GoalRecord.GOLEADOR)) {
                playersAndAssitsTournament.get(i).setQuantity(playersAndAssitsTournament.get(i).getQuantity() + quantity);
                foundScorer = true;
            } 

            if (player.getName().equals(playersAndAssitsTournament.get(i).getPlayer().getName()) && 
            player.getNumberDorsal() == playersAndAssitsTournament.get(i).getPlayer().getNumberDorsal() &&
            typePlayer.equals(GoalRecord.ASISTIDOR)) {
                playersAndAssitsTournament.get(i).setQuantity(playersAndAssitsTournament.get(i).getQuantity() + quantity);
                foundAssists = true;
            }
        }

        if (!foundScorer || !foundAssists) {
            playersAndAssitsTournament.add(new Goal(player, quantity, typePlayer));
        }

        return playersAndAssitsTournament;
    }

    //Ninth request

    /**
     * Add a card to a player
     * 
     * @param player The bad guy, player who received a card by a referee
     * @param typeCard Yellow or Red
     * 
     * @return a message of confirmation about the admonition was done.
     */
    public String addCardPlayer (Player player, TypeCard typeCard) {

        String message = "";
        boolean foundYellow = false;
        boolean foundRed = false;

        for (int i = 0; i < badPlayers.size(); i++) {
            if (player.getName().equals(badPlayers.get(i).getPlayerWithCard().getName())  && 
            player.getNumberDorsal() == badPlayers.get(i).getPlayerWithCard().getNumberDorsal() &&
            typeCard.equals(TypeCard.AMARILLA)) {
                badPlayers.get(i).setNumberCards(badPlayers.get(i).getNumberCards() + 1);
                foundYellow = true;
            } 

            if (player.getName().equals(badPlayers.get(i).getPlayerWithCard().getName())  && 
            player.getNumberDorsal() == badPlayers.get(i).getPlayerWithCard().getNumberDorsal() &&
            typeCard.equals(TypeCard.ROJA)) {
                badPlayers.get(i).setNumberCards(badPlayers.get(i).getNumberCards() + 1);
                foundYellow = true;
            } 
        }

        if (!foundYellow || !foundRed) {
            badPlayers.add(new Card(player, 1 , typeCard));
        }

        message += "Amonestación añadida a jugador";

        return message;
    }

    //Tenth request

    /**
     * Shows the table position
     * 
     * @param option Option selected by user, this var is use, to define 
     * what group of position table wants to see User.
     * 
     * @return a matrix like a String, that show: Name of Team, Matches won, matches tied,
     * matches lost, goals a favor, goals againts, diference goals and points
     */
    public String [][] tablePosition(int option) {
        String [][] tablePosition = new String[4][9];
        Team [] teamsGroupA = groupA.getGroup();
        Team [] teamsGroupB = groupB.getGroup();
        if (option == 1) {
            
            for (int i = 0; i < teamsGroupA.length; i++) {
                tablePosition [i][0] = teamsGroupA[i].getNameTeam();
                tablePosition [i][1] = String.valueOf(teamsGroupA[i].getMatchesPlayed());
                tablePosition [i][2] = String.valueOf(teamsGroupA[i].getMatchesWon());
                tablePosition [i][3] = String.valueOf(teamsGroupA[i].getMatchesTied());
                tablePosition [i][4] = String.valueOf(teamsGroupA[i].getMatchesLost());
                tablePosition [i][5] = String.valueOf(teamsGroupA[i].getGoalsFavor());
                tablePosition [i][6] = String.valueOf(teamsGroupA[i].getGoalsAgaint());
                tablePosition [i][7] = String.valueOf(teamsGroupA[i].getGoalsFavor() - teamsGroupA[i].getGoalsAgaint());
                tablePosition [i][8] = String.valueOf(teamsGroupA[i].getPoints());
            }
            
        } else if (option == 2) {
            for (int i = 0; i < teamsGroupB.length; i++) {
                tablePosition [i][0] = teamsGroupB[i].getNameTeam();
                tablePosition [i][1] = String.valueOf(teamsGroupB[i].getMatchesPlayed());
                tablePosition [i][2] = String.valueOf(teamsGroupB[i].getMatchesWon());
                tablePosition [i][3] = String.valueOf(teamsGroupB[i].getMatchesTied());
                tablePosition [i][4] = String.valueOf(teamsGroupB[i].getMatchesLost());
                tablePosition [i][5] = String.valueOf(teamsGroupB[i].getGoalsFavor());
                tablePosition [i][6] = String.valueOf(teamsGroupB[i].getGoalsAgaint());
                tablePosition [i][7] = String.valueOf(teamsGroupB[i].getGoalsFavor() - teamsGroupB[i].getGoalsAgaint());
                tablePosition [i][8] = String.valueOf(teamsGroupB[i].getPoints());
            }
        }
        
        return tablePosition;
    }

    //Eleventh request

    /**
     * Shows max scorer of tournament
     * 
     * @return Goal, that will show user the max scorer of tournament
     */
    public Goal searchMaxScorer() {
        Goal maxScorer = null;
        int maxGoals = 0;
    
        for (Goal record : playersAndAssitsTournament) {
            if (record.getTypeGoal().equals(GoalRecord.GOLEADOR)) {
                if (record.getQuantity() > maxGoals) {
                    maxGoals = record.getQuantity();
                    maxScorer = record;
                }
            }
        }
    
        return maxScorer;
    }    

    //Twelfth request

    /**
     * Add a card for a team, if a player of the team recieve some
     * 
     * @param teamFound assigns a counter for a team to can calculate the fair play team
     */
    public void cardToTeam(Team teamFound){
        for (int i = 0; i < LIMIT_TEAMS; i++) {
            if (teamFound.getNameTeam().equals(teamsTournament[i].getNameTeam())) {
                teamsTournament[i].setNumberCards(teamsTournament[i].getNumberCards() + 1);
            }
        }
    }

    /**
     * This method show User the fair play team
     * 
     * @return Team who is the good team, less faults in all tournament, It's the fair play team
     */
    public Team goodTeam() {
        Team goodTeam = new Team("Validador", "Colombia", "Andres");
        goodTeam.setNumberCards(100000);
        for (Team team : teamsTournament) {
            if (team.getNumberCards() < goodTeam.getNumberCards()) {
                goodTeam = team;
            }
        }
        return goodTeam;
    }

    //Thirteenth request
    
    /**
     * Calculate the ratio of wins for a team
     * 
     * @param teamSearch Team that user are searching to calculate his win rate
     * 
     * @return double that saved ratio wins of the team
     */
    public double calculateRatioWins(Team teamSearch){
        double ratioWins = 0.0;
        if (teamSearch != null) {
            for (Match match : matches) {
                if (match.getTeamA().getNameTeam().equals(teamSearch.getNameTeam())) {
                    if (match.getTeamA().getRatioWins() != 0) {
                        ratioWins = match.getTeamA().getRatioWins();
                    }
                } else if (match.getTeamB().getNameTeam().equals(teamSearch.getNameTeam())) {
                    if (match.getTeamB().getRatioWins() != 0) {
                        ratioWins = match.getTeamB().getRatioWins();
                    }
                }
            }
               
        }
        return ratioWins;
    }
}
