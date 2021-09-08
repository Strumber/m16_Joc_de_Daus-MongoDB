package cat.daus.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="games")
public class Game {

	   
	    @Id
	    private int id;
	   
	    @Field(name= "dau1")
	    private int dau1;
	    
	    @Field(name= "dau2")
	    private int dau2;
	    
	    @Field(name="resultat")
	    private boolean resultat;
	    
	    @Field(name="usuariId")
	    private int usuariId;
	    
	    //Constructor per defecte
	    
	    public Game() {
	    	
	    }
	    
	    //Getter & Setters
	    
	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getDau1() {
			return dau1;
		}

		public void setDau1(int dau1) {
			this.dau1 = dau1;
		}

		public int getDau2() {
			return dau2;
		}

		public void setDau2(int dau2) {
			this.dau2 = dau2;
		}

		public boolean isResultat() {
			return resultat;
		}

		public void setResultat(boolean resultat) {
			this.resultat = resultat;
		}

		public int getUsuari_id() {
			return usuariId;
		}

		public void setUsuari_id(int usuari_id) {
			this.usuariId = usuari_id;
		
		}

		@Override
		public String toString() {
			return "Game [id=" + id + ", dau1=" + dau1 + ", dau2=" + dau2 + ", resultat=" + resultat + ", usuari_id="
					+ usuariId + "]";
		}
	    
		
	   
	    
	    
}

