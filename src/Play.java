import java.util.ArrayList;
import java.util.HashMap;

public class Play {
    public HashMap<Player, Boolean> playersAndWins;
    public String boardGame;

    public Play(ArrayList<Player> players, String boardGame) {
        for(Player player: players){
            this.playersAndWins.put(player, false);
        }
        this.boardGame = boardGame;
    }

    //set which player won, using boolean
    //takes in list of players who won
    public void setPlayersAndWins(ArrayList<Player> players){
        for(Player player: players){
            if(playersAndWins.containsKey(player)){
                this.playersAndWins.put(player, true);
            }
        }
    }

    public void setBoardGame(String boardGame){
        this.boardGame = boardGame;
    }

    public String getBoardGame(){
        return this.boardGame;
    }

    public HashMap<Player, Boolean> getPlayersAndWins(){
        return this.playersAndWins;
    }


}
