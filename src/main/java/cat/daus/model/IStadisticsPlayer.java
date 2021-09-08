package cat.daus.model;

import java.util.List;


public interface IStadisticsPlayer {
    double getpercentatgeWins(List<Game> games);
    double getpercentatgeLost(List<Game> games);
    
}
