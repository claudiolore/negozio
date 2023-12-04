package org.generation.italy;

import java.util.ArrayList;
import java.util.HashMap;

public class Negozio {
	private HashMap<String,Prodotto> elencoProdotti=new HashMap<>();
	private ArrayList<Cliente> elencoClienti=new ArrayList<>();
	
	Carrello carrello=new Carrello();

/*	public Negozio() {
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
*/
	public Negozio() {
		Prodotto p1=new Prodotto("JEANS","JE001",30.0f);
		Prodotto p2=new Prodotto("T-SHIRT","TS001",15.5f);
		Prodotto p3=new Prodotto("SCARPE","SC001",70.0f);
		Prodotto p4=new Prodotto("JEANS","JE002",35.0f);
		elencoProdotti.put(p1.getCodiceProdotto(), p1);
		elencoProdotti.put(p2.getCodiceProdotto(), p2);
		elencoProdotti.put(p3.getCodiceProdotto(), p3);
		elencoProdotti.put(p4.getCodiceProdotto(), p4);

		this.elencoClienti.add(new Cliente("bendux39", "vincerevinceremo","benito", "mussolini", "cliente"));
		this.elencoClienti.add(new Cliente("zioadolf", "razzapura","adolf", "hitler", "dipendente"));
		this.elencoClienti.add(new Cliente("padreeterno", "amen","dio", "dio", "cliente"));
	}
	
	
	public void aggiungiAlCarrello(String codice, int quantita) {
		if(elencoProdotti.containsKey(codice)&& elencoProdotti.get(codice).getQuantitaDisponibile()>=quantita)	
		{
			carrello.aggiungiProdotto(codice, quantita);
		}
		else
			System.out.println("\nProdotto terminato");
	
	}	
	
	public void compra(String sceltaProdotto, Integer quantita) {
		int n=elencoProdotti.get(sceltaProdotto).getQuantitaDisponibile();
		elencoProdotti.get(sceltaProdotto).setQuantitaDisponibile(n-quantita);
	}
	
	
	
	public boolean aggiungiProdotto(Prodotto prodotto) {
		boolean esito= false;
		if(!elencoProdotti.containsKey(prodotto.getCodiceProdotto()))
		{
			elencoProdotti.put(prodotto.getCodiceProdotto(), prodotto);
			esito=true;
		}
		return esito;
		}
	
	public boolean carica( String codice, int quantitaScelta) {
		boolean esito= false;
		if(!elencoProdotti.containsKey(codice))
		{
			elencoProdotti.get(codice).setQuantitaDisponibile(quantitaScelta);
			esito=true;
		}
		return esito;
		}
	
	public boolean applicaSconto(String codice, float scontoScelto) {
		boolean esito=false;
		if(elencoProdotti.containsKey(codice))
			{
				if(elencoProdotti.get(codice).setSconto(scontoScelto))
				{	
					esito=true;
				}
			}	
		return esito;
	}
	
	public void mostraCarrello() {
		
	}
	
	public void controlloQuantita(String sceltaProdotto) {
		if(elencoProdotti.containsKey(sceltaProdotto))
		{
			elencoProdotti.get(sceltaProdotto).getQuantitaDisponibile();
		}
	}
	
	public void elencaProdotti() {
		for(String n:elencoProdotti.keySet())
		{
			System.out.print(n+" "+ elencoProdotti.get(n).getCodiceProdotto());
			System.out.print("   "+elencoProdotti.get(n).getDescrizione());
			System.out.print("   "+ elencoProdotti.get(n).getPrezzo()+ "€");
			if(elencoProdotti.get(n).getQuantitaDisponibile()>0)
			{
				System.out.print("   "+elencoProdotti.get(n).getSconto()+ " rimanenti");
			}
			if(elencoProdotti.get(n).getSconto()>0)
			{
				System.out.print("   "+elencoProdotti.get(n).getSconto()+ "%");
			}
			System.out.println("\n");
		}
			
	}
	 
	public HashMap<String, Prodotto> getElencoProdotti() {
		return elencoProdotti;
	}
	
	public void setElencoProdotti(HashMap<String, Prodotto> elencoProdotti) {
		this.elencoProdotti = elencoProdotti;
	}

/*	public ArrayList<Cliente> getElencoClienti() {
		return elencoClienti;
	}

	public void setElencoClienti(ArrayList<Cliente> elencoClienti) {
		this.elencoClienti = elencoClienti;
	}
*/
	
	public ArrayList<Cliente> getElencoClienti() {
		return this.elencoClienti;
	}

	public void setElencoClienti(ArrayList<Cliente> elencoClienti) {
		this.elencoClienti = elencoClienti;
	}

}
