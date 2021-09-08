package cat.daus.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import cat.daus.model.Player;

public interface PlayerRepository extends MongoRepository<Player, Integer> {
	
		
	//public ArrayList<Player> getPlayers();
		
	}


