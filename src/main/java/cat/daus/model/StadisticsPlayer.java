package cat.daus.model;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joan
 */
public class StadisticsPlayer implements IStadisticsPlayer{
    private Player player;
    private List<Game> partidasPlayer= new ArrayList<Game>();
    private double percentatgeExit;
    private double percentatgeFracas;
    private int totalWins;
    private int totalLost;
    private int totalPlays;
    
    public StadisticsPlayer(Player player, List<Game> partidas){
        this.player=player;
        this.partidasPlayer=partidas;
    }
    
    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public int getTotalLost() {
        return totalLost;
    }

    public void setTotalLost(int totalLost) {
        this.totalLost = totalLost;
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public void setTotalPlays(int totalPlays) {
        this.totalPlays = totalPlays;
    }

    public List<Game> getPartidasPlayer() {
        return partidasPlayer;
    }

    public void setPartidasPlayer(List<Game> partidasPlayer) {
        this.partidasPlayer = partidasPlayer;
    }

    public double getPercentatgeExit() {
        return percentatgeExit;
    }

    public void setPercentatgeExit(double percentatgeExit) {
        this.percentatgeExit = percentatgeExit;
    }

    public double getPercentatgeFracas() {
        return percentatgeFracas;
    }

    public void setPercentatgeFracas(double percentatgeFracas) {
        this.percentatgeFracas = percentatgeFracas;
    }
    
    
    
    
    @Override
    public double getpercentatgeWins(List<Game> games) {
        int totalwins=0;
        
        setTotalPlays(games.size());
        
        if(getTotalPlays()>0){
            for(Game p:games){
                if(p.isResultat()==true){
                    totalwins++;
                    setTotalWins(totalwins);
                }
            }
                double averga=((getTotalWins()*100)/getTotalPlays());
                setPercentatgeExit(averga);
            return getPercentatgeExit(); 
        }else{
            return 0;
        }
       
    }
    
    @Override
    public double getpercentatgeLost(List<Game> games) {
         int totallost=0;
        
        setTotalPlays(games.size());
        
        if(getTotalPlays()>0){
            for(Game p:games){
                if(p.isResultat()==false){
                    totallost++;
                    setTotalLost(totallost);
                }
            }
            double average=((getTotalLost()*100)/getTotalPlays());
            setPercentatgeFracas(average);
           return  getPercentatgeFracas();
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estadistiques del jugador=").append(player.getUsuari());
        sb.append(", partidasPlayer=").append(getPartidasPlayer().toString());
        sb.append(", percentatge guanyats=").append(getpercentatgeWins(getPartidasPlayer()));
        sb.append(", percentatge perduts=").append(getpercentatgeLost(getPartidasPlayer()));
        sb.append(", Total partides jugadess=").append(getTotalPlays());
        sb.append('}');
        sb.append("\n");
        return sb.toString();
    }

    
    
}
