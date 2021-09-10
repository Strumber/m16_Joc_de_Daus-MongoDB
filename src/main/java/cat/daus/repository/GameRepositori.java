package cat.daus.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.daus.model.Game;

public interface GameRepositori extends MongoRepository<Game, Integer> {
	
	List<Game> findGameByUsuariId (int usuari_id);
	boolean existsGamesByUsuariId(int usuari_id);
	int deleteGamesByUsuariId (int usuari_id);
}
