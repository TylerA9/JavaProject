import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> gamesPlayers = new HashMap<String, Integer>();
        ArrayList players = new ArrayList<>();
        char option = 't';
        while (option != 'q') {
            option = selector();
            if (option == 'b') {
                viewBoardGames(gamesPlayers);
            } else if (option == 'a') {
                addBoardGame(gamesPlayers);
            } else if (option == 'v') {
                playerInfo(players);
            } else if (option =='r'){
                recordEditPlays(players,gamesPlayers);

            }
        }
    }

    private static char selector() {
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        char option = 't';
        while (valid != true) {
            System.out.print("[B]oard game list, [A]dd board games, [R]ecord or view a plays, [V]iew/Add players, [Q]uit. ");
            String select = scan.nextLine();
            boolean check = select.isEmpty();
            if (check == false) {
                option = select.charAt(0);
                option = Character.toLowerCase(option);
                valid = selectorErrorCheck(option);
            } else {
                System.out.println("Incorrect option inputted.");
            }
        }
        return option;
    }

    public static boolean selectorErrorCheck(char option) {
        if (option == 'b') {
            return true;
        } else if (option == 'r') {
            return true;
        } else if (option == 'v') {
            return true;
        } else if (option == 'a') {
            return true;
        } else {
            System.out.println("Invalid Option");
            return false;
        }
    }

    private static void viewBoardGames(HashMap<String, Integer> gamesPlayers) {
        if (gamesPlayers.size() == 0) {
            System.out.println("No Board Games have been added yet!");
        }
        for (String i : gamesPlayers.keySet()) {
            System.out.println("Board Game:" + i + "," + " Max Players: " + gamesPlayers.get(i));

        }
    }

    private static void addBoardGame(HashMap<String, Integer> gamesPlayers) {
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        boolean leave = false;
        while (leave != true) {
            System.out.print("Type in the name of the Board Game your trying to add. ");
            String select = scan.nextLine();
            System.out.print("Type in the MAX number of players for the Board Game. ");
            int select1 = scan2.nextInt();
            gamesPlayers.put(select, select1);
            leave = checker();

        }

    }

    public static boolean checker() {
        boolean leave = false;
        char choice = 't';
        boolean valid = false;
        Scanner scan = new Scanner(System.in);
        while (valid != true) {
            System.out.println("Would you like to add another Board Game? [Y/N]");
            String option = scan.nextLine();
            choice = option.charAt(0);
            choice = Character.toLowerCase(choice);
            if (choice == 'y') {
                valid = true;
                leave = false;
            } else if (choice == 'n') {
                valid = true;
                leave = true;

            } else {
                System.out.println("Incorrect option chosen");
            }

        }
        return leave;


    }

    public static void playerInfo(ArrayList<Player> players) {
        Scanner scan = new Scanner(System.in);
        char option = 't';
        while (option != 'q') {
            System.out.println("Would you like to [A]dd a player, [V]iew all players, or [Q]uit? ");
            String select = scan.nextLine();
            boolean check = select.isEmpty();
            if (check == false) {
                option = select.charAt(0);
                option = Character.toLowerCase(option);
            } else {
                System.out.println("Incorrect option inputted.");
            }
            if (option == 'a') {
                addPlayers(players);
            } else if (option == 'v'){
                viewPlayers(players);
            }
        }

    }

    public static void addPlayers(ArrayList<Player> players) {
        Scanner scan = new Scanner(System.in);
        char option = 't';
        boolean leave = false;
        while (leave != true) {
            System.out.println("What is the name of the player your trying to add?");
            String select = scan.nextLine();
            players.add(new Player(select,0,0));
            leave = continuePlayer();


        }
    }

    public static boolean continuePlayer() {
        boolean leave = false;
        char choice = 't';
        boolean valid = false;
        Scanner scan = new Scanner(System.in);
        while (valid != true) {
            System.out.println("Would you like to add another player? [Y/N]");
            String option = scan.nextLine();
            choice = option.charAt(0);
            choice = Character.toLowerCase(choice);
            if (choice == 'y') {
                valid = true;
                leave = false;
            } else if (choice == 'n') {
                valid = true;
                leave = true;

            } else {
                System.out.println("Incorrect option chosen");
            }

        }
        return leave;



    }
    public static void viewPlayers(ArrayList<Player> players){
        if (players.size() == 0){
            System.out.println("No players added yet!");
        }
        for (int i=0; i < players.size();i++) {
            System.out.println(players.get(i));
        }
    }
    public static void recordEditPlays(ArrayList<Player> players,HashMap gamesPlayers){
        Scanner scan = new Scanner(System.in);
        char option = 't';
        boolean leave = false;
        while (leave != true) {
            System.out.println("Would you like to [C]reate a new play or [Q]uit?");
            String select = scan.nextLine();
            boolean check = select.isEmpty();
            if (check == false) {
                option = select.charAt(0);
                option = Character.toLowerCase(option);
            } else {
                System.out.println("Incorrect option inputted.");
            }if(option == 'c'){
                createAPlay(players,gamesPlayers);
            } else if (option == 'q') {
                leave = true;
            }


        }

    }
    public static void createAPlay(ArrayList<Player> players, HashMap gamesPlayers) {
        ArrayList newPlayers = new ArrayList<>();
        getPlayers(players,newPlayers,gamesPlayers);
        if (newPlayers.size() > 0){
            System.out.println(newPlayers);
            winner(newPlayers, players);
        }
    }
    public static ArrayList getPlayers(ArrayList<Player> players, ArrayList<String> newPlayers, HashMap gamesPlayers){
        Scanner scan = new Scanner(System.in);
        boolean correctGame = false;
            for (Object i : gamesPlayers.keySet()){
                System.out.println("Boardgame: " + i + " Max Players: " + gamesPlayers.get(i));
            }
            System.out.println("What Boardgame are you playing?");
            String select1 = scan.nextLine();
            if (gamesPlayers.containsKey(select1)){
                correctGame = true;
            }else {
                System.out.println("There isn't a BoardGame with that name.");
            }




        while (correctGame){
            List<String> playerNames = players.stream().map(p->p.getName()).collect(Collectors.toList());
            System.out.println(players);
            System.out.println("Please list the players who played in this game or [Quit].");
            String select = scan.nextLine();
            if (select.equals("Quit")  || select.equals("quit")){
                correctGame = false;
            } else{
                boolean found = false;
                for (Player p : players){
                    if(p.getName().equals(select) && found == false){
                        newPlayers.add(select);
                        p.setPlays((p.getPlays()+1));
                        System.out.println(p.getName() + "" + "has been added!");
                        found = true;

                    }

                }
                if(!found){
                    System.out.println("There is no player with that name. Please check your spelling and capitalization or create a new player.");
            }
            }


        }
        return newPlayers;
    }
    public static void winner(ArrayList newPlayers, ArrayList<Player> players){
        Scanner scan = new Scanner(System.in);
        boolean leave = false;
        while (!leave){
            System.out.println("Who won your board game?");
            String select = scan.nextLine();
            boolean found = false;
            for (Player p : players){
                if(p.getName().equals(select) && found == false){
                    p.setWins((p.getWins()+1));
                    System.out.println( "Congrats" + "" + p.getName() + "!");
                    found = true;
                    leave = true;

                }

            }
            if(!found){
                System.out.println("There is no player with that name. Please check your spelling and capitalization.");
            }
        }
        }
    }




