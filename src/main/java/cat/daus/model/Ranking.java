/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.daus.model;


import java.util.ArrayList;
import java.util.List;
import cat.daus.model.*;

public class Ranking {
    private List<StadisticsPlayer> listaestadistca;
    private List<Player> rankingUsersWiners;
    private List<Player> rankingUsersLosters;
     
     
    public Ranking(List<StadisticsPlayer> listaestadistca){
        this.listaestadistca=listaestadistca;
    }

    public List<StadisticsPlayer> getListaestadistca() {
        return listaestadistca;
    }

    public void setListaestadistca(List<StadisticsPlayer> listaestadistca) {
        this.listaestadistca = listaestadistca;
    }


    

    public List<Player> getRankingUsersWiners() {
        StadisticsPlayer auxUser;
        List<Player> auxList = new ArrayList<Player>();

        for (int i = 0; i < listaestadistca.size() - 1; i++) {
            for (int j = i + 1; j < listaestadistca.size() - 1; j++) {
                //he de comparar el elemento actual con el siguiente
                if (listaestadistca.get(i).getPercentatgeExit() < listaestadistca.get(j).getPercentatgeExit()) {
                    auxUser = listaestadistca.get(i);
                        this.listaestadistca.set(i, this.listaestadistca.get(j));
                        this.listaestadistca.set(j, auxUser);

                }
            }
        }

        for (StadisticsPlayer sp : listaestadistca) {
            if (sp.getPercentatgeExit() != 0) {
                 auxList.add(sp.getPlayer());
            }
        }

       setRankingUsersLosters(auxList);
        return auxList;
    }

    public void setRankingUsersWiners(List<Player> rankingUsersWiners) {
        this.rankingUsersWiners = rankingUsersWiners;
    }

    public List<Player> getRankingUsersLosters() {
        StadisticsPlayer auxUser; 
        List<Player> auxList = new ArrayList<Player>();
        
        if(listaestadistca!=null){
            for (int i = 0; i < listaestadistca.size() - 1; i++) {
                for (int j = i + 1; j < listaestadistca.size() - 1; j++) {
                    //he de comparar el elemento actual con el siguiente
                    if (listaestadistca.get(i).getPercentatgeFracas() < listaestadistca.get(j).getPercentatgeFracas()) {
                        auxUser = listaestadistca.get(i);
                        this.listaestadistca.set(i, this.listaestadistca.get(j));
                        this.listaestadistca.set(j, auxUser);
                    }
                }
            }
            setListaestadistca(listaestadistca);
        }
        
       
       for (StadisticsPlayer sp:getListaestadistca()){
           if(sp.getPercentatgeFracas()!=0){
              auxList.add(sp.getPlayer());
           } 
       }
        setRankingUsersLosters(auxList);
        return auxList;
    }
    
    

    public void setRankingUsersLosters(List<Player> rankingUsersLosters) {
        this.rankingUsersLosters = rankingUsersLosters;
    }

	@Override
	public String toString() {
		return "Ranking [listaestadistca=" + listaestadistca + ", rankingUsersWiners=" + rankingUsersWiners
				+ ", rankingUsersLosters=" + rankingUsersLosters + "]";
	}

	
    
    
}
