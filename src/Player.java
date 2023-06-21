public class Player {

    public String name;
    public int plays;
    public int wins;

    public Player(String name, int plays, int wins) {
        this.name = name;
        this.plays = plays;
        this.wins = wins;
    }

    public String getName(){
        return this.name;
    }
    public int getPlays(){
        return this.plays;
    }
    public int getWins(){
        return this.wins;
    }

    public void setWins(int wins){
        this.wins = wins;
    }

    public void setPlays(int plays)
    {
        this.plays = plays;
    }
    @Override
    public String toString() {
        return
                "Name:" + name + ',' +
                        " Plays:" + plays +
                        ", Wins:" + wins;
    }
}
