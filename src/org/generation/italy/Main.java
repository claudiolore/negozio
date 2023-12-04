     package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc = new Scanner(System.in);
		Negozio negozio =new Negozio();
		String risposta="",sceltaProdotto="";
		int  quantitaScelta, tipoUtente=-1;
		float prezzo, scontoDaApplicare;
		boolean ripeti=true;
				
	do {	
			do {	
				System.out.println("\tBENVENUTO");
				
				System.out.println("\nInserisci USERNAME");
				String usernameIn=sc.nextLine();
				Cliente clienteAutenticato= null;
				for(Cliente cliente:negozio.getElencoClienti())
				{
					System.out.println("for");
					if(cliente.getUsername().equalsIgnoreCase(usernameIn))
					{
						clienteAutenticato=cliente;
						System.out.println("ok user");
					}
				}
				System.out.println("\nInserisci PASSWORD");
				String passwordIn=sc.nextLine();
				clienteAutenticato= null; 
				
				for(Cliente cliente:negozio.getElencoClienti())
				{
					if(cliente.getPassword().equalsIgnoreCase(passwordIn))
					{
						clienteAutenticato=cliente;
					}
				}
				
				if(clienteAutenticato!=null)
				{
					System.out.println("Benvenuto "+clienteAutenticato.getNome() +
											" "+clienteAutenticato.getCognome()  +
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
		
/////////////////////////////////////////////////////   CLIENTE   ///////////////////////////////////////////////
		if(tipoUtente==1)
		{
			do {
				System.out.println("\n1 - Compra");
				System.out.println("2 - Visualizza Carrello");
				System.out.println("3 - Esci");
				System.out.println("\nCosa vuoi fare?");
				risposta=sc.nextLine();
				if(risposta.equalsIgnoreCase("1"))										//COMPRA
				{
					negozio.elencaProdotti();
					System.out.println("\nQuale prodotto vuoi aggiungere al carrello? (indice)");
				    sceltaProdotto=sc.nextLine();
				    System.out.println("\nQuanti?");
				    int quantita=Integer.parseInt(sc.nextLine());
				    negozio.aggiungiAlCarrello(sceltaProdotto, quantita);
				    System.out.println("\nCarrello: ");
				    negozio.mostraCarrello();
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
				else if(risposta.equalsIgnoreCase("2"))								//VISUALIZZA CARRELLO
				{
					System.out.println("\nIl tuo carrello è composto da: ");
				    negozio.mostraCarrello();
				}
				else if(risposta.equalsIgnoreCase("3"))									//ESCI
				{
					risposta="si";
					continue;																			
				}
				else
				{
					System.out.println("\nInserimento non valido, riprova");
					risposta="si";
					continue;
				}
				System.out.println("\nVuoi comprare altro(si/no)?");
				risposta=sc.nextLine();
			}
			while(risposta.equalsIgnoreCase("si"));
		}
//////////////////////////////////////////////////////////   DIPENDENTE    //////////////////////////////////////////
		else if(tipoUtente==2)	
		{
			do {	
				System.out.println("\n1 - Aggiungi prodotto");
				System.out.println("2 - Applica sconto");
				System.out.println("3 - Controllo disponibilita");
				System.out.println("4 - Carica prodotti");
				System.out.println("5 - Esci");
				System.out.println("\nCosa vuoi fare?");
				
				if(risposta.equals("1"))										//AGGIUNGI PRODOTTO
				{
					do {
						System.out.println("\nQuale prodotto vuoi aggiungere? (nome prodotto)");
						String nuovoDescrizione =sc.nextLine().toUpperCase();
						System.out.println("\nInserisci: (codice prodotto)");
						String nuovoCodice =sc.nextLine().toUpperCase();
						System.out.println("\nInserisci: (prezzo prodotto)");
						float nuovoPrezzo = Float.parseFloat(sc.nextLine());
						if(!negozio.aggiungiProdotto(new Prodotto(nuovoCodice, nuovoDescrizione, nuovoPrezzo)))
						{
							System.out.println("Codice gio esistente, riprova");
							break;
						}
						System.out.println("Prodotto aggiunto");
						negozio.elencaProdotti();
						System.out.println("\nVuoi aggiungere altro (si/no)?");
						risposta=sc.nextLine();
					}
					while(risposta.equalsIgnoreCase("si"));
				
				}
				else if (risposta.equals("2"))									//APPLICA SCONTO
				{
					do {
						negozio.elencaProdotti();
						System.out.println("\nQuale prodotto vuoi scontare?");
					    String codice=sc.nextLine();
					    if(negozio.getElencoProdotti().containsKey(sceltaProdotto))
					    {
					    	System.out.println("\nDi quanto lo vuoi scontare? (percentuale)");
					    	scontoDaApplicare=Float.parseFloat(sc.nextLine());
					    	negozio.applicaSconto(codice,scontoDaApplicare);
					    	negozio.elencaProdotti();
					    }
					    else 
					    {
					    	System.out.println("\nProdotto non esistentte");
					    	risposta="si";
					    	continue;
					    }
					    System.out.println("\nVuoi Scontare altro?");
					}
					while(risposta.equalsIgnoreCase("si"));
				}
				else if (risposta.equals("3"))									//CONTROLLO DISPONIBILITA
				{
					negozio.elencaProdotti();
					System.out.println("\nDi quale prodotto vuoi controllare la quantita?");
					sceltaProdotto=sc.nextLine();
					negozio.controlloQuantita(sceltaProdotto);
				}
				else if (risposta.equals("4"))										//CARICA PRODOTTI
				{
					do {
						System.out.println("\nQuale prodotto vuoi caricare? (codice prodotto)");
						sceltaProdotto=sc.nextLine();
						System.out.println("\nQuani ne vuoi aggiungere?");
						quantitaScelta=Integer.parseInt(sc.nextLine());
						if(negozio.carica(sceltaProdotto, quantitaScelta))
						{
							System.out.println("Prodotto inesistente");
							break;
						}
						System.out.println("Prodotto caricato");
						negozio.elencaProdotti();
						System.out.println("\nVuoi aggiungere altro (si/no)?");
						risposta=sc.nextLine();
					}
					while(risposta.equalsIgnoreCase("si"));
				}
				else if (risposta.equals("5"))											//ESCI
				{
					risposta="si";
					continue;
				}
				else
				{
				System.out.println("\nInserimento non valido, riprova");
				risposta="si";
				continue;
				}
			System.out.println("Vuoi fare altro?");
			risposta=sc.nextLine();	
			}
			while(risposta.equalsIgnoreCase("si"));
		}
		else 
		{
			System.out.println("\nInserimento errato");
			risposta="si";
			continue;
		}
	}
	while(risposta.equalsIgnoreCase("si"));	
	
	System.out.println("\n\nARRIVEDERCI");
	sc.close();
	}
}