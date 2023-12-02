package org.generation.italy;

import java.util.HashMap;

public class Negozio {
	private HashMap<Integer,Prodotto> elencoProdotti=new HashMap<>();
	private HashMap<Integer,Prodotto> carrello =new HashMap<>();
	private HashMap<Integer,Cliente> elencoClienti=new HashMap<>();
	


	public Negozio() {
		elencoProdotti.put(1, new Prodotto("JEANS ANNA PEPE","JE001",30.0f));
		elencoProdotti.put(2, new Prodotto("T-SHIRT ANNA PEPE","TS001",15.5f));
		elencoProdotti.put(3, new Prodotto("SCARPE ANNA PEPE","SC001",70.0f));
		elencoProdotti.put(4, new Prodotto("JEANS RAY MISTIRIO","JE002",35.0f));
	}
	
	public Negozio(HashMap<Integer, Cliente> elencoClienti) {
		elencoClienti.put(1, new Cliente("bendux39", "vincerevinceremo","benito", "mussolini", "cliente"));
		elencoClienti.put(2, new Cliente("zioadolf", "razzapura","adolf", "hitler", "dipendente"));
		elencoClienti.put(3, new Cliente("padreeterno", "amen","dio", "dio", "cliente"));
	}

	
	
	public void aggiungiAlCarrello(Integer prodottoDaAggiungere) {
		
		carrello.put(carrello.size()+1, elencoProdotti.get(prodottoDaAggiungere));
		//aggiungere quantita e classe carrello

	}
	
	public void compra(Integer sceltaProdotto, Integer quantita) {
		int n=elencoProdotti.get(sceltaProdotto).getQuantitaDisponibile();
		elencoProdotti.get(sceltaProdotto).setQuantitaDisponibile(n-quantita);
	}
	
	public void elencaCarrello() {
		for(Integer n:carrello.keySet())
		{
			System.out.print(carrello.get(n).getDescrizione());
			System.out.print(" " +carrello.get(n).getPrezzo()+ "€");
			System.out.println("  sconto " + carrello.get(n).getSconto()+ "%" );
		}
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
			System.out.println("   "+ elencoProdotti.get(n).getPrezzo()+ "€");
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
	
	public HashMap<Integer, Prodotto> getCarrello() {
		return carrello;
	}

	public void setCarrello(HashMap<Integer, Prodotto> carrello) {
		this.carrello = carrello;
	}

	public HashMap<Integer, Cliente> getElencoClienti() {
		return elencoClienti;
	}

	public void setElencoClienti(HashMap<Integer, Cliente> elencoClienti) {
		this.elencoClienti = elencoClienti;
	}

}
