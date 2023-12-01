package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner sc=new Scanner(System.in);
		int sceltaProdotto;
		Negozio n1=new Negozio();
		
		
		n1.elencaProdotti();
		System.out.println("\nCosa vuoi comprare?");
		sceltaProdotto=Integer.parseInt(sc.nextLine());
		
		
	}

}
