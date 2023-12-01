package org.generation.italy;

import java.util.HashMap;

public class Prodotto {
	
	private float sconto, prezzo;
	private int quantitaDisponibile;
	private String descrizione, codiceProdotto;
	
	public Prodotto(String descrizione, String codiceProdotto, float prezzo) {

		this.descrizione = descrizione;
		this.codiceProdotto = codiceProdotto;
		this.prezzo = prezzo;
		quantitaDisponibile=10;
		sconto=0;
	}
	public void scalaDisponibilita() {
		if(quantitaDisponibile>0)
			quantitaDisponibile-=1;
		else
			System.out.println("Disponibilita terminate");
	}
	
	public float getSconto() {
		return sconto;
	}

	public void setSconto(float sconto) {
		this.sconto = sconto;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		this.quantitaDisponibile = quantitaDisponibile;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(String codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}
	
	
	
	
}
