package bataille;

import java.util.Scanner;

public class Bataille {
	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Entrez le nom du Joueur n°1 :\n");
		String namePlayer1 = user_input.next( );
		Joueur j1 = new Joueur(namePlayer1, 26);
		
		System.out.println("Entrez le nom du Joueur n°2 :\n");
		String namePlayer2 = user_input.next( );
		Joueur j2 = new Joueur(namePlayer2, 26);
		
		user_input.close();
		System.out.println("Bataille de " + j1.getName() + " vs. " + j2.getName() + "\n");
		
		Deck deck = new Deck();
		deck.splitDeck(deck, j1, j2);
        
        while (j1.getScore() > 1 && j2.getScore() > 1) {
        	Carte j1Card = j1.getPlayerTopCard();
        	Carte j2Card = j2.getPlayerTopCard();
        	j1.removeTopCard();
        	j2.removeTopCard();
        	
        	if (j1Card.getNumber() > j2Card.getNumber()) {
        		j1.decrementScore();
        		j2.incrementScore();
        		j2.addCard(j1Card);
        		j2.addCard(j2Card);
        		System.out.println("j1 win");
        	} else if (j1Card.getNumber() < j2Card.getNumber()) {
        		j1.incrementScore();
        		j2.decrementScore();
        		j1.addCard(j1Card);
        		j1.addCard(j2Card);
        		System.out.println("j2 win");
        	} else if (j1Card.getNumber() == j2Card.getNumber()) {
        		j1.addCard(j1Card);
        		j2.addCard(j2Card);
        		System.out.println("égal");
        	}
        	
        	//System.out.println(j1.getName() + " " + j1.getScore() + "  vs  " + j2.getScore() + " " + j2.getName());
        	System.out.println(j1.getPlayerDeck().size() + " " + j1.getScore() + "  vs  " + j2.getScore() + " " + j2.getPlayerDeck().size());
        	
        	try{
    		  Thread.sleep(0);
    		} catch(InterruptedException ex){
    		  break;
    		}
        }
	}
}