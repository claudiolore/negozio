package org.generation.italy;

import java.util.ArrayList;
import java.util.HashMap;

public class Negozio {
	private HashMap<String,Prodotto> elencoProdotti=new HashMap<>();
	private ArrayList<Cliente> elencoClienti=new ArrayList<>();
	private HashMap<Integer,Prodotto> carrello =new HashMap<>();


	public Negozio() {
		Prodotto p1=new Prodotto("JEANS","JE001",30.0f);
		Prodotto p2=new Prodotto("T-SHIRT","TS001",15.5f);
		Prodotto p3=new Prodotto("SCARPE","SC001",70.0f);
		Prodotto p4=new Prodotto("JEANS","JE002",35.0f);
		elencoProdotti.put(p1.getCodiceProdotto(), p1);
		elencoProdotti.put(p2.getCodiceProdotto(), p2);
		elencoProdotti.put(p3.getCodiceProdotto(), p3);
		elencoProdotti.put(p4.getCodiceProdotto(), p4);
	}
	
	public Negozio(ArrayList<Cliente> elencoClienti) {
		elencoClienti.add(new Cliente("bendux39", "vincerevinceremo","benito", "mussolini", "cliente"));
		elencoClienti.add(new Cliente("zioadolf", "razzapura","adolf", "hitler", "dipendente"));
		elencoClienti.add(new Cliente("padreeterno", "amen","dio", "dio", "cliente"));
	}

	public void aggiungiAlCarrello(String prodottoDaAggiungere) {
	if(elencoProdotti.containsKey(prodottoDaAggiungere)&& elencoProdotti.get(prodottoDaAggiungere).getQuantitaDisponibile()>0)	
		carrello.put(carrello.size()+1, elencoProdotti.get(prodottoDaAggiungere));	
	else
		System.out.println("\nProdotto terminato");
	
	}	
	
	public void compra(String sceltaProdotto, Integer quantita) {
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
		elencoProdotti.put(codiceProdotto, new Prodotto(descrizione, codiceProdotto,prezzo));
	
	}
	
	public void controlloQuantita(String sceltaProdotto) {
		if(elencoProdotti.containsKey(sceltaProdotto))
		{
			elencoProdotti.get(sceltaProdotto).getQuantitaDisponibile();
		}
	}

	public void caricaProdotti(String sceltaProdotto, Integer quantitaScelta) {
		if(elencoProdotti.containsKey(sceltaProdotto))
		{
			elencoProdotti.get(sceltaProdotto).setQuantitaDisponibile(quantitaScelta);
		}
	}
	
	public void elencaProdotti() {
		for(String n:elencoProdotti.keySet())
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
	 public void applicaSconto(String sceltaProdotto, float scontoScelto) {
		if(scontoScelto<90f && scontoScelto>5f)
		{
	    elencoProdotti.get(sceltaProdotto).setSconto(scontoScelto);
		}
		else 
			System.out.println("sconto non applicabile");
			
	}
	
	public HashMap<String, Prodotto> getElencoProdotti() {
		return elencoProdotti;
	}
	
	public void setElencoProdotti(HashMap<String, Prodotto> elencoProdotti) {
		this.elencoProdotti = elencoProdotti;
	}
	
	public HashMap<Integer, Prodotto> getCarrello() {
		return carrello;
	}

	public void setCarrello(HashMap<Integer, Prodotto> carrello) {
		this.carrello = carrello;
	}

	public ArrayList<Cliente> getElencoClienti() {
		return elencoClienti;
	}

	public void setElencoClienti(ArrayList<Cliente> elencoClienti) {
		this.elencoClienti = elencoClienti;
	}


}
