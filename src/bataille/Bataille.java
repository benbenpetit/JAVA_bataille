package bataille;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bataille {
	public static void main(String[] args) {
		Scanner user_input = new Scanner(System.in);
		
		System.out.println("Entrez le nom du Joueur n°1 :");
		String namePlayer1 = user_input.next( );
		Joueur j1 = new Joueur(namePlayer1);
		
		System.out.println("Entrez le nom du Joueur n°2 :");
		String namePlayer2 = user_input.next( );
		Joueur j2 = new Joueur(namePlayer2);
		
		user_input.close();
		System.out.println("Bataille de " + j1.getName() + " vs. " + j2.getName() + "\n");
		
		Deck deck = new Deck();
		deck.splitDeck(deck, j1, j2);
		int iteration = 0;
        
		//while (verifyPlayerDeckSize() == false) {
        while (j1.getPlayerDeck().size() != 0 && j2.getPlayerDeck().size() != 0) {        	
        	Carte j1Card = managePickedCards(j1);
        	Carte j2Card = managePickedCards(j2);
        	
        	int result = compareCards(j1Card, j2Card);
        	
        	if (result == 1) {
        		manageWinLosePlayersDeck(j1, j2, j1Card, j2Card);
        	} else if (result == 2) {
        		manageWinLosePlayersDeck(j2, j1, j1Card, j2Card);
        	} else {
        		System.out.println("équal");
        		
        		int winner = 0;
        		ArrayList<Carte> keptCards = new ArrayList<Carte>();
        		
        		while (winner == 0) {
        			if (j1.getPlayerDeck().size() <= 1) {
            			System.out.println(j1.getName() + " a perdu");
            			break;
            		} else if (j2.getPlayerDeck().size() <= 1) {
            			System.out.println(j2.getName() + " a perdu");
            			break;
            		} else {
            			keptCards = manageEqualPlayersDeck(j1, j2, j1Card, j2Card);
            			Collections.shuffle(keptCards);
            			winner = compareCards(keptCards.get(keptCards.size() - 2), keptCards.get(keptCards.size() - 1));
            		}
        		}
        		
        		if (winner == 1) {
        			j1.addCards(keptCards);
        		} else if (winner == 2) {
        			j2.addCards(keptCards);
        		}
        	}
        	
        	iteration++;
        	
        	System.out.println(iteration + " iterations       " + j1.getName() + " " + j1.getPlayerDeck().size() + "  vs  " + j2.getPlayerDeck().size() + " " + j2.getName());
        	
        	try{
    		  Thread.sleep(10);
    		} catch(InterruptedException ex){
    		  break;
    		}
        }
        
        if (j1.getPlayerDeck().size() == 0) {
        	System.out.println(j2.getName() + " a gagné!");
        } else {
        	System.out.println(j1.getName() + " a gagné!");
        }
	}
	
	private static Carte managePickedCards(Joueur joueur) {
		Carte card = joueur.getPlayerTopCard();
    	joueur.removeTopCard();
    	
    	return card;
	}
	
	private static int compareCards(Carte j1Card, Carte j2Card) {
		if (j1Card.getNumber() > j2Card.getNumber()) {
			return 1;
		} else if (j1Card.getNumber() < j2Card.getNumber()) {
			return 2;
		} else {
			return 0;
		}
	}
	
	private static void manageWinLosePlayersDeck(Joueur winner, Joueur loser, Carte j1Card, Carte j2Card) {
		ArrayList<Carte> cards = new ArrayList<Carte>();
		List<Carte> awaitingCards = Arrays.asList(j1Card, j2Card);
		cards.addAll(awaitingCards);
		Collections.shuffle(cards);
		winner.addCards(cards);
	}
	
	private static ArrayList<Carte> manageEqualPlayersDeck(Joueur j1, Joueur j2, Carte j1Card, Carte j2Card) {
		Carte j1CardHidden = managePickedCards(j1);
		Carte j2CardHidden = managePickedCards(j2);
		Carte j1CardNew = managePickedCards(j1);
		Carte j2CardNew = managePickedCards(j2);
		
		ArrayList<Carte> keptCards = new ArrayList<Carte>();
		List<Carte> cards = Arrays.asList(j1Card, j1CardHidden, j1CardNew, j2CardHidden, j2Card, j2CardNew);
		keptCards.addAll(cards);
		
		return keptCards;
	}
}