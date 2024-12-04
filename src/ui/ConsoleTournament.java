package ui;

import java.util.*;
import model.*;
import model.Card.TypeCard;
import model.Goal.GoalRecord;

/**
* ConsoleTournament is the user interface for managing a football tournament.
* It allows registering teams, players, referees, and viewing tournament information.
*/
public class ConsoleTournament {
    //All of this var, allows the correct functionality of program.
    List<Player> players = new ArrayList<>();
    final int MAX_PLAYERS = 20;
    List<Referee> referees = new ArrayList<>();
    Scanner readerConsole = new Scanner(System.in);
    ControllerTournament controllerTournament;
    final int LIMIT_TEAMS = 8;
    Team [] teamsTournament = new Team[LIMIT_TEAMS];
    int option;
    Referee referee;
    Match [] matches = new Match[12];
    int i = 0;
    List <Goal> playersAndAssitsTournament = new ArrayList<>();

    /**
    * Constructor of the ConsoleTournament class.
    * Initializes the tournament controller.
    */
    public ConsoleTournament() {
        controllerTournament = new ControllerTournament(); 
    }

    /**
    * Main method that starts the console application.
    */
    public static void main(String[] args) {
        ConsoleTournament tournament = new ConsoleTournament();
        tournament.menu();
    }

    /**
    * Displays the main menu and manages the options selected by the user.
    */
    public void menu() {
        System.out.println("Bienvenido profesor al aplicativo para el Torneo de Futbol");
        System.out.println("¿Que desea hacer?");
        do {
        System.out.println("[1] Registrar equipos \n" + "[2] Registrar jugadores \n" + "[3] Registrar un árbitros \n"  
        + "[4] Precargar información \n" + "[5] Realizar el fixture \n" + "[6] Asignar equipo arbitral a un partido \n" 
        + "[7] Registrar marcador \n" + "[8] Registrar jugador que marco gol o que asistio \n" + "[9] Registrar tarjetas a jugadores \n"
        + "[10] Consultar tabla de posiciones \n" + "[11] Consultar máximo goleador del torneo \n" + "[12] Consultar Equipo Fair Play \n"
        + "[13] Conusltar ratio de victorias de un equipo \n" + "[14] Consultar ratio de goles de un jugador \n"
        + "[15] Consultar ratio de tarjetas de un árbitro \n------------------------------------------------");
        //User can select a option of menu
        option = readerConsole.nextInt();
        readerConsole.nextLine();

            switch (option) {
                case 1:
                    registerTeam();
                    break;

                case 2:

                    System.out.println("¿A que equipo va a pertenecer la lista de jugadores?");
                    for (int i = 0; i < teamsTournament.length; i++) {
                        if (teamsTournament[i] == null) {
                            System.out.println("No hay más equipos registrados");
                        }else {
                            System.out.println("[" + (i + 1) + "] " + teamsTournament[i].getNameTeam());
                        }
                    }
                    option = readerConsole.nextInt();
                    readerConsole.nextLine();

                    System.out.println("Ingrese todos los jugadores que forman parte del equipo (Recuerde debe ser un total de 20 jugadores)");
                    registerPlayer();

                    teamsTournament[option - 1].setPlayers(new ArrayList<>(players));
                    players.clear();
                    break;

                case 3:

                    registerReferee();
                    break;

                case 4:

                    displayInformation();
                    break;

                case 5:

                    matches = controllerTournament.generateFixture();

                    System.out.println("Fixture del torneo:");
                    for (Match match : matches) {
                        if (match != null) {
                            System.out.println("Partido: " + match.getTeamA().getNameTeam() + " vs " + match.getTeamB().getNameTeam() +
                            ", Fecha: " + match.getDateMatch());
                        } 
                    }

                    break;

                case 6:

                    assignReferee();
                    
                    break;

                case 7:

                    registerScorerMatch();
                    break;
                
                case 8:

                    registerScorerAndAssists();
                    break;

                case 9:

                    registerCard();
                    break;

                case 10:
                    tablePosition();
                    break;

                case 11:

                    consultMaxScorer();
                    break;

                case 12:
                    searchFairPlayTeam();
                    break;

                case 13:
                    calculateRatioWins();
                    break;

                case 14: 
                    System.out.println("No funciona");
                    break;
                case 15:
                    System.out.println("No funciona");
                    break;
            }

            System.out.println("¿Quieres salir del programa?" + "\n" + "[1] Si" + "\n" + "[2] No");
            option = readerConsole.nextInt();
            readerConsole.nextLine();
        } while (option != 1);
        readerConsole.close();
    }

    /**
    * Allows registering a team in the tournament.
    */
    public void registerTeam() {

        System.out.println("¿Como se llama el equipo #" + (i+1) + " ?");
        String nameTeam = readerConsole.nextLine();
        
        System.out.println("¿De que país es el equipo?");
        String countryTeam = readerConsole.nextLine();

        System.out.println("¿Como se llama el director técnico?");
        String directorTeam = readerConsole.nextLine();
        teamsTournament = controllerTournament.registerTeam(nameTeam, countryTeam, directorTeam, i);
        i++;

    }

    /**
    * Allows registering players for a team and returns the updated list of players.
    */
    public void registerPlayer() {
        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.println("¿Como se llama el #" + (i + 1) + " jugador que van a ingresar?");
            String namePlayer = readerConsole.nextLine();
    
            System.out.println("¿Que número de dorsal tiene " + namePlayer + "?");
            String numberDorsal = readerConsole.nextLine();
    
            System.out.println("¿De que país es " + namePlayer + "?");
            String countryPlayer = readerConsole.nextLine();
    
            System.out.println("¿Que rol desempeñara " + namePlayer + "?" + "\n"
            + "[1] Arquero" + "\n" + "[2] Defensa" + "\n" + "[3] Volante" + "\n"
            + "[4] Delantero \n---------------");
    
            option = readerConsole.nextInt();
            readerConsole.nextLine();
    
            players = controllerTournament.registerPlayer(countryPlayer, namePlayer, numberDorsal, option);
        }
    }

    /**
    * Allows registering a referee in the tournament.
    */
    public void registerReferee(){

        System.out.println("¿Cual es la identificación del árbitro?");
        String idReferee = readerConsole.nextLine();

        System.out.println("¿Como se llama el árbitro?");
        String nameReferee = readerConsole.nextLine();

        System.out.println("¿De que país es el árbitro?");
        String countryReferee = readerConsole.nextLine();

        System.out.println("¿Qué tipo de árbitro es?" + "\n" + "[1] Central"
        + "\n" + "[2] Asistente");
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        referees = controllerTournament.registerReferee(idReferee, nameReferee, countryReferee, option);

    }

    /**
    * Preload all information to start Soccer Tournament
    *
    */
    public void displayInformation() {

        for (int i = 0; i < 4; i++) {
            controllerTournament.registerReferee("001", "Carlos Pérez", "Colombia", 1); // Central
            controllerTournament.registerReferee("002", "María Gómez", "Argentina", 2); // Assistant
            controllerTournament.registerReferee("003", "Luis Martínez", "Chile", 2);   // Assistant
        }
        
        
        teamsTournament = controllerTournament.registerTeam("Integradora", "Brazil", "John Doe", 0);
        teamsTournament = controllerTournament.registerTeam("Desarrolladores", "Argentina", "Jane Smith",1);
        teamsTournament = controllerTournament.registerTeam("Profesores", "Brazil", "John Doe", 2);
        teamsTournament = controllerTournament.registerTeam("Estudiantes", "Brazil", "John Doe", 3);
        teamsTournament = controllerTournament.registerTeam("Dicembrina", "Brazil", "John Doe", 4);
        teamsTournament = controllerTournament.registerTeam("Noche Buena", "Brazil", "John Doe", 5);
        teamsTournament = controllerTournament.registerTeam("Tiro Alto", "Brazil", "John Doe", 6);
        teamsTournament = controllerTournament.registerTeam("Tiro Bajo", "Brazil", "John Doe", 7);
        
        
        
        for (int i = 0; i < teamsTournament.length; i++) {
            players.clear();
            for (int j = 0; j < 5; j++) {
                players = controllerTournament.registerPlayer("Portugal", "Criistiao Ronaldo", "7", 1);
                players = controllerTournament.registerPlayer("Argentina", "Lionel Messi", "10", 2);
                players = controllerTournament.registerPlayer("Brazil", "Lucas Costa", "3", 3);
                players = controllerTournament.registerPlayer("Brazil", "Ronaldo Souza", "4", 4);
                teamsTournament[i].setPlayers(players);
            }
            
        }
        System.out.println("Equipos y Jugadores:\n" + controllerTournament.showPlayers());
        System.out.println("Árbitros:\n" + controllerTournament.showReferees());
    }

    /**
    * Assigns referees to a match selected by the user.
    */
    public void assignReferee() {

        List<Referee> refereesMatches = new ArrayList<>();
        int i = 1;
        String message = controllerTournament.showMatches();
        if (message != "") {
            System.out.println(message);
            System.out.println("¿A que partido va a asignar arbitros?" + "\n" +
            "Importante:" + "\n" +
            "Recuerde que los árbitros que tengan la misma nacionalidad que los equipos disputantes no estaran disponibles");
            int matchSelected = readerConsole.nextInt();
            readerConsole.nextLine();

            Team validationTeam1 = matches [matchSelected - 1].getTeamA();
            Team validationTeam2 = matches [matchSelected - 1].getTeamB();

            System.out.println("Arbitros centrales disponibles:");

            List<Referee> centralReferees = controllerTournament.avaibleCentralReferees(validationTeam1, validationTeam2);

            for (Referee referee : centralReferees) {
                System.out.println("# " + (i++) + ". Nombre: " + referee.getName() +
                ", ID: " + referee.getIdReferee() +
                ", País: " + referee.getCountry() + "\n----------------------------------\n"); 
            }

            System.out.println("¿Que central dirigira este partido?");
            option = readerConsole.nextInt();
            readerConsole.nextLine();

            refereesMatches.add(centralReferees.get(option - 1));
            
            System.out.println("Árbitros asistentes disponibles:");

            List<Referee> asssistantReferees =  controllerTournament.avaibleAssistantReferees(validationTeam1, validationTeam2);

            for (Referee referee : asssistantReferees) {
                System.out.println("# " + (i++) + ". Nombre: " + referee.getName() +
                ", ID: " + referee.getIdReferee() +
                ", País: " + referee.getCountry()+ "\n----------------------------------\n"); 
            }

            System.out.println("¿Cuales seran los 2 arbitros asistentes que \n" +
            "acompaañaran este partido?");

            for (int j = 0; j < 2; j++) {
                System.out.println("El #" + (j + 1) + " árbitro es: ");
                option = readerConsole.nextInt();
                readerConsole.nextLine();

                refereesMatches.add(asssistantReferees.get(option - 1));
            }

            matches[matchSelected - 1].setReferees(refereesMatches);
        } else {
            System.out.println("No hay encuentros programados");
        }
    }

    /**
    * Allows registering the final score for a specific match.
    * Displays all the matches, prompts the user to select a match, and updates the score.
    */
    public void registerScorerMatch(){
        String message = controllerTournament.showMatches();
        System.out.println(message);
        int resultFirstTeam;
        int resultSecondTeam;

        System.out.println("¿Que partido ha finalizado para registrar el marcador?");
        option = readerConsole.nextInt();
        readerConsole.nextLine();


        System.out.println("¿Como termino el marcador de ese partido? \n" + 
        matches[option - 1].getTeamA().getNameTeam() + ":");
        resultFirstTeam = readerConsole.nextInt();
        readerConsole.nextLine();

        System.out.println(matches[option - 1].getTeamB().getNameTeam()+ ":");
        resultSecondTeam = readerConsole.nextInt();
        readerConsole.nextLine();

        System.out.println(controllerTournament.modifyScorerMatch(option, resultFirstTeam, resultSecondTeam));  
    }

    //Eighth request

    /**
     * Allows User to register quantity of goals or assist of striker or assits.
     * Besides, this allow to have a statitic about who is the max scorer
     */
    public void registerScorerAndAssists() {
        teamsTournament = controllerTournament.getTeamsTournament();
        Player player;
        int quantity;
        Team teamFound;

        String message = controllerTournament.showPlayers();
        System.out.println(message);
        System.out.println("Seleccione el equipo en el que está el goleador");

        option = readerConsole.nextInt();
        readerConsole.nextLine();

        teamFound = teamsTournament[option - 1];

        System.out.println("¿Quien es el goleador? (Escriba el # (No el dorsal))");
        GoalRecord typePlayer = GoalRecord.GOLEADOR;
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        player = teamFound.getPlayers().get(option - 1);

        System.out.println("¿Cuantos goles anoto?");

        quantity = readerConsole.nextInt();
        readerConsole.nextLine();
        playersAndAssitsTournament = controllerTournament.addScorerAndAssits(player, quantity, typePlayer);

        System.out.println("¿Quien asistio? (Escriba el # (No el dorsal))");
        typePlayer = GoalRecord.ASISTIDOR;
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        player = teamFound.getPlayers().get(option - 1);

        System.out.println("¿Cuantas asistencias realizo?");
        quantity = readerConsole.nextInt();
        readerConsole.nextLine();
        playersAndAssitsTournament = controllerTournament.addScorerAndAssits(player, quantity, typePlayer);

        System.out.println("Goleador y asistidor registrados con éxito \n -----------------------------------");
    }

    //Ninth request

    /**
     * Allos register a card for a bad player(Bad guy)
     * User can select if is a yellow card or red card.
     * This allow also to have static to calculate the team fair play.
     */
    public void registerCard() {
        teamsTournament = controllerTournament.getTeamsTournament();
        Player player;
        Team teamFound;
        TypeCard typeCard = null;
        String message = controllerTournament.showPlayers();

        System.out.println("¿En que equipo está el infractor?");
        System.out.println(message);
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        teamFound = teamsTournament[option - 1];
        controllerTournament.cardToTeam(teamFound);

        System.out.println("¿Quien es el infractor?");
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        player = teamFound.getPlayers().get(option - 1);
        

        System.out.println("¿Que tarjeta recibio? \n[1] Amarilla \n[2] Roja");
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        switch (option) {
            case 1:
                typeCard = TypeCard.AMARILLA;
                break;

            case 2 :
                typeCard = TypeCard.ROJA;
        }

        message = controllerTournament.addCardPlayer(player, typeCard);
        System.out.println(message + "\n-------------------------------------------");
    }

    //Tenth request

    /**
     * Matrix that show the position table of Group A and Group B
     * It's updated every time that user modify a scorer match.
     */
    public void tablePosition() {
        System.out.println("¿Que grupo vas a consultar? \n[1]Grupo A \n[2] Grupo B");
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        String [][] tablePosition = controllerTournament.tablePosition(option);

        System.out.println("|   Club   |" + " PJ |" + " G |" + " E |" + " P |" + " GF |" + " GC |" + " DG |" + " PTS |\n");
        for (int i = 0; i < 4; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                row.append("| " + tablePosition[i][j] + " |");
            }
            System.out.println(row);
        }

    }

    //Eleventh request
    
    /**
     * This method search the top scorer of soccer tournament
     */
    public void consultMaxScorer() {
        Goal maxScorer;
        System.out.println("El máximo goleador del torneo es:");

        maxScorer = controllerTournament.searchMaxScorer();

        System.out.println(maxScorer.getPlayer().getName() + " con el dorsal: " + maxScorer.getPlayer().getNumberDorsal() + 
        "\nSu posición es: " + maxScorer.getPlayer().getPositionPlayer() + "\n Cuenta con un total de: " + maxScorer.getQuantity() + 
        " Goles \n------------------------------------");
    }

    //Twelfth request

    /**
     * It's similar to consultMaxScorer, but thiis search the team fair play 
     */
    public void searchFairPlayTeam() {
        Team goodTeam = controllerTournament.goodTeam();
        System.out.println("El equipo Fair PLay es: " + goodTeam.getNameTeam() + " con un total de: " + goodTeam.getNumberCards() + " tarjetas recibidas");
    }

    //Thirteenth request
    
    /**
     * This method calculate ratio wins for a team of the tournament
     */
    public void calculateRatioWins() {
        teamsTournament = controllerTournament.getTeamsTournament();
        String message = controllerTournament.showTeams();
        System.out.println(message);

        System.out.println("¿Que equipo deseas consultar?");
        option = readerConsole.nextInt();
        readerConsole.nextLine();

        double ratioWins = controllerTournament.calculateRatioWins(teamsTournament[option - 1]);

        System.out.println("El equipo: " + teamsTournament[option - 1].getNameTeam() + " tiene un ratio de victorias del: " + ratioWins + "%");
    }
}