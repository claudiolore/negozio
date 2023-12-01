package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		Negozio negozio =new Negozio();
		String risposta;
		int sceltaProdotto;
		float prezzo, scontoDaApplicare;
 
	    System.out.println("\n\n\n\n\n\n");
	System.out.println("***** NEGOZIO ONLINE ***** \n");
	negozio.elencaProdotti();
	System.out.println("\n1 - visualizza prodotti");
	System.out.println("2 - aggiungi prodotto");
	System.out.println("3 - applica sconto");
	System.out.println("4 - aggiungi al carrello");
	System.out.println("5 - esci");
	
	System.out.println("\n **** scegli le opzioni da 1 a 5 ****");
	risposta=sc.nextLine();
	
	if (risposta.equals("1"))
	{
		negozio.elencaProdotti();
	}
	else if(risposta.equals("2"))
	{
		System.out.println("Quale prodotto vuoi aggiungere? (nome prodotto)");
		String nuovoDescrizione =sc.nextLine().toUpperCase();
		System.out.println("(codice prodotto)");
		String nuovoCodice =sc.nextLine().toUpperCase();
		System.out.println("(prezzo prodotto)");
		float nuovoPrezzo = Float.parseFloat(sc.nextLine());
		negozio.aggiungiProdotto(nuovoDescrizione, nuovoCodice, nuovoPrezzo);
		negozio.elencaProdotti();
	}
	else if (risposta.equals("3"))
	{
		negozio.elencaProdotti();
		System.out.println("\nQuale prodotto vuoi scontare? (indice)");
	    sceltaProdotto=Integer.parseInt(sc.nextLine());
	    if(negozio.getElencoProdotti().containsKey(sceltaProdotto))
	    {
	    	System.out.println("\nDi quanto lo vuoi scontare? (percentuale) ");
	    	scontoDaApplicare=Float.parseFloat(sc.nextLine());
	    	negozio.applicaSconto(sceltaProdotto,scontoDaApplicare);
	    	negozio.elencaProdotti();
	    }
	    else 
	    {
	    	System.out.println("prodotto non disponibile");
	    }
	}
	else if (risposta.equals("4"))
	{ 
	    System.out.println("Quale prodotto vuoi aggiungere al carrello? (indice)");
	    negozio.elencaProdotti();
	    sceltaProdotto=Integer.parseInt(sc.nextLine());
	    negozio.aggiungiAlCarrello(sceltaProdotto);
	    System.out.println("il tuo carrello è composto da: ");
	    negozio.elencaCarrello();
	}
}
}
