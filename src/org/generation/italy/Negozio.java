package org.generation.italy;

import java.util.HashMap;

public class Negozio {
	private HashMap<Integer,Prodotto> elencoProdotti=new HashMap<>();

	public Negozio() {
		elencoProdotti.put(1, new Prodotto("jeans","JE001",30.0f));
		elencoProdotti.put(2, new Prodotto("t-shirt","TS001",15.5f));
		elencoProdotti.put(3, new Prodotto("scarpe","SC001",70.0f));
		elencoProdotti.put(4, new Prodotto("jeans","JE002",35.0f));

	}
	
	public void aggiungiProdotto(String descrizione,String codiceProdotto, float prezzo) {
		elencoProdotti.put(elencoProdotti.size()+1, new Prodotto(descrizione, codiceProdotto, prezzo));
	}
	
	public void applicaSconto(Integer sceltaProdotto, float sconto) {
		elencoProdotti.get(sceltaProdotto).setSconto(sconto);
	}

	public void vendiProdotto(Integer sceltaProdotto) {
		elencoProdotti.get(sceltaProdotto).scalaDisponibilita();;
	}
	
	public void elencaProdotti() {
		for(Integer n:elencoProdotti.keySet())
		{
			System.out.print(n+" "+ elencoProdotti.get(n).getCodiceProdotto());
			System.out.print(" "+elencoProdotti.get(n).getDescrizione());
			System.out.println(" "+ elencoProdotti.get(n).getPrezzo());
		}	
	}
	
	public HashMap<Integer, Prodotto> getElencoProdotti() {
		return elencoProdotti;
	}
	
	public void setElencoProdotti(HashMap<Integer, Prodotto> elencoProdotti) {
		this.elencoProdotti = elencoProdotti;
	}
	
	
}
