     package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		Negozio negozio =new Negozio();
		String risposta="",sceltaProdotto;
		int  quantitaScelta, tipoUtente;
		float prezzo, scontoDaApplicare;
		boolean ripeti=true;
				
	do {	
		do {	
			System.out.println("\tBENVENUTO");
			System.out.println("\nInserisci USERNAME");
			String usernameIn=sc.nextLine();
			System.out.println("\nInserisci password");
			String passwordIn=sc.nextLine();
			
			Cliente clienteAutenticato= null; 
			
			for(Cliente cliente:elencoClienti)
			{
				if(cliente.getUsername().equals(usernameIn) && cliente.getPassword().equals(passwordIn))
				{
					clienteAutenticato=cliente;
					break;
				}
			}
			
			if(clienteAutenticato!=null)
			{
				System.out.println("Benvenuto "+clienteAutenticato.getNome() +
										" "+clienteAutenticato.getCognome()+
										"-"+clienteAutenticato.getTipologia());
				if(clienteAutenticato.getTipologia().equalsIgnoreCase("cliente"))
					tipoUtente=1;
				else
					tipoUtente=2;
				
				ripeti=false;
			}
			else
			{
				System.out.println("\nUsername e/o password errati");
			}
		}
		while(ripeti==true);
		
												
												///////////////////////////   CLIENTE   ///////////////////////////////////////////////
		if(tipoUtente==1)
		{
			do {
				System.out.println("\n1 - Compra");
				System.out.println("2 - Visualizza Carrello");
				System.out.println("3 - Esci");
				System.out.println("\nCosa vuoi fare?");
				risposta=sc.nextLine();
				if(risposta.equalsIgnoreCase("1"))						//COMPRA
				{
					negozio.elencaProdotti();
					System.out.println("\nQuale prodotto vuoi aggiungere al carrello? (indice)");
				    sceltaProdotto=sc.nextLine();
				    System.out.println("\nQuanti?");
				    int quantita=Integer.parseInt(sc.nextLine());
				    negozio.aggiungiAlCarrello(sceltaProdotto);
				    System.out.println("\nCarrello: ");
				    negozio.elencaCarrello();
				    System.out.println("\nVuoi completare il pagamento?");
				    risposta=sc.nextLine();
				    if(risposta.equals("si"))
				    {
				    	System.out.println("Complimenti ordine avvenuto con successo arrivederci");
				    	negozio.compra(sceltaProdotto, quantita);
				    	break;
				    }
				    else if(risposta.equals("no"))
				    {
				    	break;
				    	
				    }
				    else
				    {
				    	System.out.println("\nInserimento non valido, riprova");
				    }  
				}
				else if(risposta.equalsIgnoreCase("2"))					//VISUALIZZA CARRELLO
				{
					System.out.println("\nIl tuo carrello è composto da: ");
				    negozio.elencaCarrello();
				}
				else if(risposta.equalsIgnoreCase("3"))					//ESCI
				{
					break;																				//controllare
				}
				else
				{
					System.out.println("\nInserimento non valido, riprova");
				}
				System.out.println("\nVuoi comprare altro(si/no)?");
				risposta=sc.nextLine();
			}
			while(risposta.equalsIgnoreCase("si"));
		}
		else if(tipoUtente==2)	///////////////////   DIPENDENTE    //////////////////////////////////////////
		{
			do {	
				System.out.println("\n1 - Aggiungi prodotto");
				System.out.println("2 - Applica sconto");
				System.out.println("3 - Controllo disponibilita");
				System.out.println("4 - Carica prodotti");
				System.out.println("5 - Esci");
				System.out.println("\nCosa vuoi fare?");
				
				if(risposta.equals("1"))			//AGGIUNGI PRODOTTO
				{
					System.out.println("\nQuale prodotto vuoi aggiungere? (nome prodotto)");
					String nuovoDescrizione =sc.nextLine().toUpperCase();
					System.out.println("\nInserisci: (codice prodotto)");
					String nuovoCodice =sc.nextLine().toUpperCase();
					System.out.println("\nInserisci: (prezzo prodotto)");
					float nuovoPrezzo = Float.parseFloat(sc.nextLine());
					negozio.aggiungiProdotto(nuovoDescrizione, nuovoCodice, nuovoPrezzo);
					System.out.println("Prodotto aggiunto");
					negozio.elencaProdotti();
				}
				else if (risposta.equals("2"))							//APPLICA SCONTO
				{
					negozio.elencaProdotti();
					System.out.println("\nQuale prodotto vuoi scontare?");
				    sceltaProdotto=sc.nextLine();
				    if(negozio.getElencoProdotti().containsKey(sceltaProdotto))
				    {
				    	System.out.println("\nDi quanto lo vuoi scontare? (percentuale)");
				    	scontoDaApplicare=Float.parseFloat(sc.nextLine());
				    	negozio.applicaSconto(sceltaProdotto,scontoDaApplicare);
				    	negozio.elencaProdotti();
				    }
				    else 
				    {
				    	System.out.println("prodotto non disponibile");
				    }
				}
				else if (risposta.equals("3"))								//CONTROLLO DISPONIBILITA
				{
					negozio.elencaProdotti();
					System.out.println("\nDi quale prodotto vuoi controllare la quantita?");
					sceltaProdotto=sc.nextLine();
					negozio.controlloQuantita(sceltaProdotto);
				}
				else if (risposta.equals("4"))								//CARICA PRODOTTI
				{
					negozio.elencaProdotti();
					System.out.println("\nQuale prodotto vuoi caricare?");
					sceltaProdotto=sc.nextLine();
					System.out.println("\nQuanti ne vuoi caricare?");
					quantitaScelta=Integer.parseInt(sc.nextLine());
					negozio.caricaProdotti(sceltaProdotto, quantitaScelta);
				}
				else if (risposta.equals("5"))								//ESCI
				{
					break;
				}
				else
				{
				System.out.println("\nInserimento non valido, riprova");
				}
			System.out.println("Vuoi fare altro?");
			risposta=sc.nextLine();	
			}
			while(risposta.equalsIgnoreCase(risposta));
			
		}
		else 
		{
			System.out.println("\nInserimento errato");
			risposta="si";
			continue;
		}
	}
	while(risposta.equalsIgnoreCase("si"));	
	
	
	
	
	
	System.out.println("\n\nSono qui");
	sc.close();
}
}