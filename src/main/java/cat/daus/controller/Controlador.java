package cat.daus.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.daus.model.Game;
import cat.daus.model.Player;
import cat.daus.repository.GameRepositori;
import cat.daus.repository.PlayerRepository;

@RestController
@RequestMapping("")
public class Controlador {
	int idGame=1;
	@Autowired
	private PlayerRepository playerRepositori;
	
	@Autowired
	private GameRepositori gameRepositori;

	@GetMapping("/")

	public String iniciar() {

		return "login";
	}

	// 5 . GET /players/: retorna el llistat de tots els
	// jugadors del sistema amb el seu percentatge mig d’èxits

	@GetMapping("/players")
	public List<Player> getPlayer() {
		// model.addAttribute("titulo", "JOC DE DAUS");
		List<Player> lista = playerRepositori.findAll();

		// model.addAttribute("players", lista);
		return lista;
	}

	// 1 POST: /players : crea un jugador
	@PostMapping("/players")
	public String savePlayer(@RequestBody Player player) {
		player.setData(LocalDateTime.now());
		playerRepositori.save(player);
		return "Usuari insertat : " + player.getId() + "-" + player.getUsuari();
	}

	// 2 PUT /players : modifica el nom del jugador

	@PutMapping ("/players/{usuari_id}")
		public String modifPlayer(@PathVariable("usuari_id") int usuari_id ,
                @RequestBody Player usuari) {
		
		//PlayerReposotory.existById(usuario_id);
		if ( playerRepositori.existsById(usuari_id)){
            playerRepositori.save(usuari);
            return usuari +" modificat";
        }else{
            return "l' usuari " + usuari_id +"No s' ha pogut modificar";
        }
	}
		
		
	//3 POST /players/{id}/games/ : un jugador específic realitza una tirada dels daus.
		@PostMapping("/players/{usuari_id}/games")
		 public void crearGame(@PathVariable("usuari_id") int usuari_id, @RequestBody Game game){
				
		game.setId(idGame);
		game.setUsuari_id(usuari_id);
		game.setDau1(((int) (Math.random() * (6-1))+ 1));
		game.setDau2(((int) (Math.random() * (6-1))+ 1));	
		
		if (game.getDau1()+game.getDau2()==7) {
			game.setResultat(true);
		}else {
			game.setResultat(false);
		}
			
		gameRepositori.save(game);
		idGame++;
		
	}
		
		// 4 DELETE /players/{id}/games: elimina les tirades del jugador

		@DeleteMapping("/players/{usuari_id}/games")
		
		public String eliminaTiradesPlayer (@PathVariable("usuari_id") int usuari_id) {
			
			if(playerRepositori.findById(usuari_id)!=null && gameRepositori.existsGamesByUsuariId(usuari_id)) {
				
				gameRepositori.deleteGamesByUsuariId(usuari_id);
				
				return "Partides de l' usuari : " + usuari_id + " eliminades" ;
			} else {
				
				return "L' ususari seleccionat no te cap partida";
			}
				
			//push Delete
		}
}