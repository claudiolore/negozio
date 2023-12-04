package org.generation.italy;

import java.util.HashMap;

public class Carrello {
	private HashMap<String,Integer> carrello=new HashMap<String, Integer>();

public void aggiungiProdotto(String codice, int quantita) {
	carrello.put(codice,quantita);
}

public HashMap<String, Integer> getCarrello() {
	return carrello;
}

public void setCarrello(HashMap<String, Integer> carrello) {
	this.carrello = carrello;
}
}
