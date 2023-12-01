package org.generation.italy;

import java.util.HashMap;

public class Negozio {
	private HashMap<Integer,Prodotto> elencoProdotti=new HashMap<>();
	HashMap<Integer,Prodotto> carrello =new HashMap<>();
	
	
	

	public void aggiungiAlCarrello(Integer prodottoDaAggiungere) {
		
		carrello.put(carrello.size()+1, elencoProdotti.get(prodottoDaAggiungere));

	}
	
	public void elencaCarrello() {
		for(Integer n:carrello.keySet())
		{
			System.out.print(carrello.get(n).getDescrizione());
			System.out.print(" " +carrello.get(n).getPrezzo()+ "€");
			System.out.println("  sconto " + carrello.get(n).getSconto()+ "%" );
		}
	}

	public Negozio() {
		elencoProdotti.put(1, new Prodotto("JEANS ANNA PEPE","JE001",30.0f));
		elencoProdotti.put(2, new Prodotto("T-SHIRT ANNA PEPE","TS001",15.5f));
		elencoProdotti.put(3, new Prodotto("SCARPE ANNA PEPE","SC001",70.0f));
		elencoProdotti.put(4, new Prodotto("JEANS RAY MISTIRIO","JE002",35.0f));
	}

	public void aggiungiProdotto(String descrizione, String codiceProdotto, float prezzo ) {
		elencoProdotti.put(elencoProdotti.size()+1, new Prodotto(descrizione, codiceProdotto,prezzo));
	
	}
	
	public void controlloQuantita(Integer sceltaProdotto) {
		if(elencoProdotti.containsKey(sceltaProdotto))
		{
			elencoProdotti.get(sceltaProdotto).getQuantitaDisponibile();
		}
	}

	public void caricaProdotti(Integer sceltaProdotto, Integer quantitaScelta) {
		if(elencoProdotti.containsKey(sceltaProdotto))
		{
			elencoProdotti.get(sceltaProdotto).setQuantitaDisponibile(quantitaScelta);
		}
	}
	
	public void elencaProdotti() {
		for(Integer n:elencoProdotti.keySet())
		{
			System.out.print(n+" "+ elencoProdotti.get(n).getCodiceProdotto());
			System.out.print("   "+elencoProdotti.get(n).getDescrizione());
			System.out.print("   "+ elencoProdotti.get(n).getPrezzo()+ "€");
			if(elencoProdotti.get(n).getSconto()>0)
			{
				System.out.println(elencoProdotti.get(n).getSconto()+ "%");
			}
		}
			
	}
	 public void applicaSconto(Integer sceltaProdotto, float scontoScelto) {
		if(scontoScelto<90f && scontoScelto>5f)
		{
	    elencoProdotti.get(sceltaProdotto).setSconto(scontoScelto);
		}
		else 
			System.out.println("sconto non applicabile");
			
	}
	
	public HashMap<Integer, Prodotto> getElencoProdotti() {
		return elencoProdotti;
	}
	
	public void setElencoProdotti(HashMap<Integer, Prodotto> elencoProdotti) {
		this.elencoProdotti = elencoProdotti;
	}
}
