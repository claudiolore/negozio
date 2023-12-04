package org.generation.italy;


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
	
	
	public float getSconto() {
		return sconto;
	}

	public boolean setSconto(float sconto) {
	boolean esito=false;
		if(sconto>0&&sconto<100)
		{
			this.sconto = sconto;
			esito=true;
		}
		return esito;
			
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		if(prezzo>0)
			this.prezzo = prezzo;
	}

	public int getQuantitaDisponibile() {
		return quantitaDisponibile;
	}

	public void setQuantitaDisponibile(int quantitaDisponibile) {
		if(quantitaDisponibile>0)
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
