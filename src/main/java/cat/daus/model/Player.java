package cat.daus.model;

import java.time.LocalDateTime;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;




@Document(collection = "players")
public class Player {
	
	
	@Id
	private int id;

	@Field(name = "usuari")
	private String usuari;

	@Field(name = "data")
	private LocalDateTime data;

	//Constructors
	public Player() {

	}

	public Player( String usuari, LocalDateTime data) {
		
		this.usuari = usuari;
		this.data = data;
	}

	//Getters & Setters
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuari() {
		return usuari;
	}

	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime localDateTime) {
		this.data = localDateTime;
	}
	
	
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", usuari=" + usuari + ", data=" + data + "]";
	}
	
	
	
	
}
